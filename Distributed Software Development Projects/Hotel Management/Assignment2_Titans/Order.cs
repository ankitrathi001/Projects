/* Assignment 2 : CSE 598 : DSOD
 * Team Name: Titans
 * Team Members: Anshul Jain
 *               Surya Vamsi Kopella
 *               Sai Kishore Petla
 * Class Name: Order
 * This class contains all the information required for order processing
 * 
 */
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Assignment2_Titans
{

    [Serializable]
    public class Order
    {
        private string senderID;
        private int cardNo;
        private string receiverID;
        private int rooms;
        private int price;
        private DateTime TimeStamp;

        public Order(string senderID, int cardNo, string receiverID, int rooms, int price)
        {
            setSenderID(senderID);
            setCardNo(cardNo);
            setReceiverID(receiverID);
            setRooms(rooms);
            setPrice(price);
            setTimeStamp(DateTime.Now);
        }
        public string getSenderID()
        {
            return (this.senderID);
        }
        public void setSenderID(string senderID)
        {
            this.senderID = senderID;
        }

        public void setCardNo(int cardNo)
        {
            this.cardNo = cardNo;
        }
        public int getCardNo()
        {
            return (this.cardNo);
        }

        public void setReceiverID(string receiverID)
        {
            this.receiverID = receiverID;
        }
        public string getReceiverID()
        {
            return (this.receiverID);
        }

        public int getRooms()
        {
            return (this.rooms);
        }
        public void setRooms(int rooms)
        {
            this.rooms = rooms;
        }
        public int getPrice()
        {
            return (this.price);
        }
        public void setPrice(int price)
        {
            this.price = price;
        }
        public DateTime getTimeStamp()
        {
            return (this.TimeStamp);
        }
        public void setTimeStamp(DateTime TimeStamp)
        {
            this.TimeStamp = TimeStamp;
        }
    }
}

