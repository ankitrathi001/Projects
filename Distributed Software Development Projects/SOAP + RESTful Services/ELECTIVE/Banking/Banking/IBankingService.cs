using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace Banking
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the interface name "IBankingService" in both code and config file together.
    [ServiceContract]
    public interface IBankingService
    {
        [OperationContract]
        string[] Registration(string FirstName, string LastName, string Email, string Password, string Amount);
        [OperationContract]
        bool LoginVerification(string uname, string password);
        [OperationContract]
        string processTransaction(string UserName, string CardNumber, string CVV, string ExpMonth, string ExpYear, string Amount);
        [OperationContract]
        string[] getTransactionHistory(string UserName);
    }
}
