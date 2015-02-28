/* Team Name: Titans
 * Team Members: Anshul Jain
 *               Surya Vamsi Kopella
 *               Sai Kishore Petla
 * Class Name: Program
 * This class contains the information of the Travel Agencies. Each travel agency will
 * apply for the credit card and will place their order according to the price cut event.
 * 
 */
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;

namespace Assignment2_Titans
{
    class TravelAgency
    {
        static Random rng = new Random();
        private int ID;
        MultiCellBuffer Buffer;
        private int cardNumber;
        public TravelAgency(int id, MultiCellBuffer buffer, BankService BS) 
        {
            ID = id;
            Buffer = buffer;
            cardNumber = BS.getCardNo(ID);
        }
        /* Event Handler */
        public void roomsOnSale(int price, int prev)
        {
            Order o = new Order(this.ID.ToString(), this.cardNumber, Thread.CurrentThread.Name, getRooms(), price);
            object ord = (object)o;
            Thread TA = new Thread(new ParameterizedThreadStart(PlaceOrderFunc));
            TA.Start(ord);
        }
        /* Thread function to place an order */
        public void PlaceOrderFunc(object order)
        {
            Random rng = new Random();
            int sleepTime = rng.Next(100,300);
            Thread.Sleep(sleepTime);
            Order o = (Order)order;
            Encoder e = new Encoder();
            string OrderEncodedString = e.ObjectToString(o);
            this.Buffer.addNewOrder(OrderEncodedString);
        }
        /* Model to calculate the number of rooms for booking (random number) */
        public int getRooms()
        {
            return rng.Next(1, 10);
        }
    }
}
