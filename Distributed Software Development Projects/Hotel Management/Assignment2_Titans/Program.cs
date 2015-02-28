/* Assignment 2 : CSE 598 : DSOD
 * Team Name: Titans
 * Team Members: Anshul Jain
 *               Surya Vamsi Kopella
 *               Sai Kishore Petla
 * Class Name: Program
 * This is the main class. This will create 3 hotel suppliers and 5 travel agencies
 * and the travel agencies will subscribe to price cut event here.
 * 
 */
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;

namespace Assignment2_Titans
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("***********************Assignment #2, Team Titans************************\n");
            BankService BS = new BankService();
            MultiCellBuffer buffer = new MultiCellBuffer();
            buffer.checkMCB.Release(3);
            
            HotelSupplier hotel = new HotelSupplier();
            hotel.priceCut += new priceCutEventDelegate(roomsOnSale);
            HotelSupplier hotel1 = new HotelSupplier();
            hotel1.priceCut += new priceCutEventDelegate(roomsOnSale);
            HotelSupplier hotel2 = new HotelSupplier();
            hotel2.priceCut += new priceCutEventDelegate(roomsOnSale);
            
            Thread supplier1 = new Thread (new ThreadStart(hotel.HotelSupplierFunc));
            Thread supplier2 = new Thread(new ThreadStart(hotel1.HotelSupplierFunc));
            Thread supplier3 = new Thread(new ThreadStart(hotel2.HotelSupplierFunc));
            supplier1.Name = "HoidaysInn";
            supplier1.Start();
            supplier2.Name = "Taj";
            supplier2.Start();
            supplier3.Name = "Four Points";
            supplier3.Start();
            for (int i = 0; i < 5; i++)
            {
                TravelAgency t = new TravelAgency(i, buffer, BS);
                hotel.priceCut += new priceCutEventDelegate(t.roomsOnSale);
                hotel1.priceCut += new priceCutEventDelegate(t.roomsOnSale);
                hotel2.priceCut += new priceCutEventDelegate(t.roomsOnSale);
            }
            OrderProcessing OP = new OrderProcessing(buffer, BS);
            buffer.newOrder += new NewOrderEventDelegate(OP.orderProcessing);
            OP.orderCompleted += new OrderCompletedEventDelegate(buffer.orderProcCompleted);
        }

        public static void roomsOnSale(int price, int prev)
        {
            Console.WriteLine("Hotel Supplier: {0} - Rooms on Sale: Price changed from ${1} to ${2} ", Thread.CurrentThread.Name, prev, price);
        }
    }
}
