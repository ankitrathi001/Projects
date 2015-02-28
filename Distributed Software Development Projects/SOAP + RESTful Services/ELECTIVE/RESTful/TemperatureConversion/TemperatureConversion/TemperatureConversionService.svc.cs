using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace TemperatureConversion
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "TemperatureConversionService" in code, svc and config file together.
    // NOTE: In order to launch WCF Test Client for testing this service, please select TemperatureConversionService.svc or TemperatureConversionService.svc.cs at the Solution Explorer and start debugging.
    public class TemperatureConversionService : ITemperatureConversionService
    {
        public double c2f(double c)
        {
            return (c * (double)9 / 5) + (double)32;
        }
        public double f2c(double f)
        {
            return (f - (double)32) * (double)5 / 9;
        }
    }
}
