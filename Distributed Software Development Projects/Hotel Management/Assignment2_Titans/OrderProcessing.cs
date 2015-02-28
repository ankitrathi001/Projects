/* Assignment 2 : CSE 598 : DSOD
 * Team Name: Titans
 * Team Members: Anshul Jain
 *               Surya Vamsi Kopella
 *               Sai Kishore Petla
 * Class Name: OrderProcessing
 * This class contains the methods to process the order and will trigger the 
 * event as soon as an order is completed.
 * 
 */
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;

namespace Assignment2_Titans
{
    public delegate void OrderCompletedEventDelegate(string order);
    public class OrderProcessing
    {
        EncryptDecryptService.ServiceClient proxy = new EncryptDecryptService.ServiceClient();
        public event OrderCompletedEventDelegate orderCompleted;
        private Random rng = new Random();
        private BankService BS;
        private object lockobj = new object();
        public OrderProcessing(MultiCellBuffer buffer, BankService bs) 
        {
            this.BS = bs;
        }
        /* Methods to calculate the prices and process the order */
        public void orderProcessing(string order)
        {
            try
            {
                Decoder d = new Decoder();
                Order o = (Order)d.StringToObject(order);
                string format = "HH:mm:ss";
                Console.WriteLine("{0} : Travel Agency {1} placed an order of {2} rooms in {3} @ ${4}", o.getTimeStamp().ToString(format), o.getSenderID(), o.getRooms(), o.getReceiverID(), o.getPrice());
                Thread OrderProc = new Thread(new ParameterizedThreadStart(orderProcessingFunc));
                OrderProc.Start(order);
            }
            catch (NullReferenceException e) { Console.WriteLine("Nothing present in Multicell Buffer"); }
        }

        public void orderProcessingFunc(object order)
        {
            try
            {
                int sleepTime = rng.Next(500, 1000);
                Thread.Sleep(sleepTime);
                lock (lockobj)
                {
                    string Order = (string)order;
                    Decoder d = new Decoder();
                    Order o = (Order)d.StringToObject(Order);
                    double TotalPrice = o.getRooms() * o.getPrice();
                    TotalPrice += TotalPrice * 8.1 / 100;
                    string encryptedCardNumber = proxy.Encrypt(o.getCardNo().ToString()).ToString();
                
                    if (String.Equals(BS.checkCardNumber(Convert.ToInt32(o.getSenderID()), encryptedCardNumber), "Valid", StringComparison.Ordinal))
                    {
                        Console.Write("____________________________________________________________________________");
                        Console.WriteLine("\nHotel Supplier: {0}\nCard Authentication Done", o.getReceiverID());
                        Console.Write("Order processing completed for Travel Agency {0}  \nNo. of rooms: {1}, Total price: {2}, Time to complete: {3}\n", o.getSenderID(), o.getRooms(), TotalPrice, DateTime.Now - o.getTimeStamp());
                        Console.WriteLine("----------------------------------------------------------------------------");
                    }
                    else
                    {
                        Console.WriteLine("\nCard Authentication Failed for Travel Agency {0}", o.getSenderID());
                    }
                    OnOrderCompleted(Order);
                }
            }
            catch (Exception e) { Console.WriteLine("Order Not processed. Check your card number and try again"); }
        }
        public void OnOrderCompleted(string order)
        {
            if (orderCompleted != null)
                orderCompleted(order);
        }
    }
}
