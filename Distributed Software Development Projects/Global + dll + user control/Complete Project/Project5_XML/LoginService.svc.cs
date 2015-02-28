using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;
using System.IO;
using System.Web;
using System.Xml;

namespace Project5_XML
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "LoginService" in code, svc and config file together.
    // NOTE: In order to launch WCF Test Client for testing this service, please select LoginService.svc or LoginService.svc.cs at the Solution Explorer and start debugging.
    public class LoginService : ILoginService
    {
        public string login(string username, string password)
        {
            try
            {
                string fLocation = Path.Combine(HttpRuntime.AppDomainAppPath, @"App_Data");
                string file = Path.Combine(fLocation, "Role.xml");
                XmlDocument xDoc = new XmlDocument();
                xDoc.Load(file);
                XmlNodeList nodes = xDoc.GetElementsByTagName("User");
                string role = null;
                string Error="";
                bool flag = false;
                foreach (XmlNode node in nodes)
                {
                    if (node["Uname"].InnerText == username)
                    {
                        flag = true;
                        if (node["Password"].InnerText == password)
                        {
                            return node["Role"].InnerText;
                        }
                        else
                            return null;
                    }
                }
                if (flag == false)
                    Error = "User does not exist";
            }
            catch (FileNotFoundException) { return null; }
            catch (Exception) { return null; }
            return null;
        }
    }
}
