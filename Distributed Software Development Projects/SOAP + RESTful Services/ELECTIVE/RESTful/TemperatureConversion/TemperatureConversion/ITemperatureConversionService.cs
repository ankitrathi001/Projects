using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;
using System.ServiceModel.Web;

namespace TemperatureConversion
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the interface name "ITemperatureConversionService" in both code and config file together.
    [ServiceContract]
    public interface ITemperatureConversionService
    {
        [OperationContract]
        [WebGet(UriTemplate = "c2f?c={c}")]
        double c2f(double c);
        [OperationContract]
        [WebGet(UriTemplate = "f2c?f={f}")]
        double f2c(double f);
    }
}
