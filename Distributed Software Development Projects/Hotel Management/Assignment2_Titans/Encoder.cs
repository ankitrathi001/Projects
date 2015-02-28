/* Assignment 2 : CSE 598 : DSOD
 * Team Name: Titans
 * Team Members: Anshul Jain
 *               Surya Vamsi Kopella
 *               Sai Kishore Petla
 * Class Name: Encoder
 * This class encodes the Order object to binary formatted string.
 * 
 */
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;
using System.Runtime.Serialization.Formatters.Binary;

namespace Assignment2_Titans
{
    class Encoder
    {
        public string ObjectToString(object obj)
        {
            using (MemoryStream ms = new MemoryStream())
            {
                new BinaryFormatter().Serialize(ms, obj);
                return Convert.ToBase64String(ms.ToArray());
            }
        }
    }
}
