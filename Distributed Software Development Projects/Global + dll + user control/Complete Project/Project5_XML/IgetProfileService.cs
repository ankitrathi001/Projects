using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace Project5_XML
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the interface name "IgetProfileService" in both code and config file together.
    [ServiceContract]
    public interface IgetProfileService
    {
        [OperationContract]
        string[] getProfile(string username);
    }
}
