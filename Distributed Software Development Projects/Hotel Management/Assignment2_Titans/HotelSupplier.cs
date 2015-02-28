/* Assignment 2 : CSE 598 : DSOD
 * Team Name: Titans
 * Team Members: Anshul Jain
 *               Surya Vamsi Kopella
 *               Sai Kishore Petla
 * Class Name: HotelSupplier
 * This class contains the information of the hotel suppliers. It uses a pricing model (random number)
 * to generate the prices (only 10 times for each hotel supplier) and trigger an event if the price is 
 * lower than the previous price.
 * 
 */
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Threading;

namespace Assignment2_Titans
{
    public delegate void priceCutEventDelegate(int price, int PrevPrice);
    class HotelSupplier
    {
        private int RoomPrice = 1000;
        static Random rng = new Random();
        public event priceCutEventDelegate priceCut;
        public HotelSupplier() { }
        /* Triggering the event if price is lower than previous price */ 
        public void changePrice(int price)
        {
            if (price < this.RoomPrice)
            {
                int prev = this.RoomPrice;
                this.RoomPrice = price;
                onPriceCutEvent(this.RoomPrice, prev);
            }
            else
            {
                this.RoomPrice = price;
                Console.WriteLine("{0} : Price changed to ${1} - No Price Cut!",Thread.CurrentThread.Name, this.RoomPrice);
            }
        }

        public void onPriceCutEvent(int price, int prev)
        {
            if (priceCut != null)
                priceCut(price, prev);
        }
        /* Pricing Model */
        public int pricingModel()
        {
            return rng.Next(500, 1000);
        }
        /* Thread method to generate prices */
        public void HotelSupplierFunc()
        {
            for (int i = 0; i < 10; i++)
            {
                Thread.Sleep(1000);
                int price = pricingModel();
                changePrice(price);
            }
        }
    }
}
