/* Assignment 2 : CSE 598 : DSOD
 * Team Name: Titans
 * Team Members: Anshul Jain
 *               Surya Vamsi Kopella
 *               Sai Kishore Petla
 * Class Name: BankService
 * This class allows Travelagency to register for a card and validate an 
 * encrypted card number using the decryption service that is available 
 * in ASU repository
 * 
 */
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Assignment2_Titans
{
    public class BankService
    {
        EncryptDecryptService.ServiceClient proxy1 = new EncryptDecryptService.ServiceClient();  
        private int[] cardNo;
        private Random rng = new Random();
        public BankService(){
            cardNo = new int[5];
        }
        /* Method to generate a card number */
        public int getCardNo(int id)
        {
            cardNo[id] = rng.Next(424234, 787987);
            return cardNo[id];
        }
        /* Method to validate the encoded cardnumber */
        public string checkCardNumber(int id, string encryptedcardNumber)
        {
            try
            {
                int cardNumber = Convert.ToInt32(proxy1.Decrypt(encryptedcardNumber));
                if (cardNo[id] == cardNumber)
                    return "Valid";
                else
                    return "Not Valid";
            }
            catch (Exception e)
            {
                Console.WriteLine("Encryption service not available! Please check the configuration");
                return "null";
            }
        }
    }
}
