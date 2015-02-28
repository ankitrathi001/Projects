using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace Anshul_Jain_Assignment1
{
    public class TemperatureService : ITemperatureService
    {
        public int c2f(int c)       // Function to convert temperature from Celsius to Fahrenheit.
        {
            return (c*9/5)+32;      // F = ( C * 9 / 5 ) + 32
        }

        public int f2c(int f)       // Function to convert temperature from Fahrenheit to Celsius.
        {
            return (f-32)*5/9;      // C = ( F -32 ) * 5 / 9
        }
    }
}
