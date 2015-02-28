using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace CrimeData
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the interface name "ICrimeDataService" in both code and config file together.
    [ServiceContract]
    public interface ICrimeDataService
    {
        [OperationContract]
        string getCrimeData(string lat, string lang);
        [OperationContract]
        int getTotalCrimes(string lat, string lang);
    }
}
