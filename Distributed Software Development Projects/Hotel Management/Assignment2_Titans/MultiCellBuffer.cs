/* Assignment 2 : CSE 598 : DSOD
 * Team Name: Titans
 * Team Members: Anshul Jain
 *               Surya Vamsi Kopella
 *               Sai Kishore Petla
 * Class Name: MultiCellBuffer
 * This is a multicell buffer (3 cells) that contains a semaphore (0,3) to check if any
 * buffer is free or not. This class also throws an event to trigger the order processing
 * as soon as there is an order added in buffer.
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
    public delegate void NewOrderEventDelegate(string order);
    public class MultiCellBuffer
    {
        public Semaphore checkMCB;
        private string[] OrderString;
        public event NewOrderEventDelegate newOrder;
        public MultiCellBuffer()
        {
            checkMCB = new Semaphore(0, 3);
            OrderString = new string[3];
        }
        /* Set one cell method */
        public void addNewOrder(string order)
        {
            try
            {
                checkMCB.WaitOne();
                int index = -1;
                bool flag = false;
                for (int i = 0; i < 3; i++)
                {
                    if (OrderString[i] == null)
                    {
                        index = i;
                        flag = true;
                        break;
                    }
                }
                if (flag == true)
                {
                    OrderString[index] = order;
                    onNewOrder(order);
                }

            }
            catch (SemaphoreFullException e)
            {
                Console.WriteLine("Multicell Buffer is full!");
            }

        }
        /* Triggering an event whenever a new order is added in the buffer */
        public void onNewOrder(string order)
        {    
            if (newOrder != null)
            {
                newOrder(order);
            }
        }
        /* Get one cell method */
        public void orderProcCompleted(string order)
        {
            try
            {
                int index = -1;
                bool flag = false;
                for (int i = 0; i < 3; i++)
                {
                    if (OrderString[i] == order)
                    {
                        index = i;
                        flag = true;
                        break;
                    }
                }
                if (flag == true)
                {
                    OrderString[index] = null;
                    checkMCB.Release();
                }
            }
            catch (Exception e)
            {
                Console.WriteLine("Multicell buffer is already empty!");
            }
        }
    }
}
