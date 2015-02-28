using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace Anshul_Jain_Assignment1
{
    [ServiceContract]
    public interface ITemperatureService
    {
        [OperationContract]
        int c2f(int c);         // Function to convert temperature from Celsius to Fahrenheit.

        [OperationContract]
        int f2c(int f);         // Function to convert temperature from Fahrenheit to Celsius.
    }
}
