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
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "getProfileService" in code, svc and config file together.
    // NOTE: In order to launch WCF Test Client for testing this service, please select getProfileService.svc or getProfileService.svc.cs at the Solution Explorer and start debugging.
    public class getProfileService : IgetProfileService
    {
        public string[] getProfile(string username)
        {
            string fLocation = Path.Combine(HttpRuntime.AppDomainAppPath, @"App_Data");
            string file = Path.Combine(fLocation, "Register.xml");
            XmlDocument xDoc = new XmlDocument();
            xDoc.Load(file);
            XmlNodeList nodes = xDoc.GetElementsByTagName("User");
            foreach (XmlNode node in nodes)
            {
                if (node["Uname"].InnerText == username)
                {
                    string[] res = { node["Name"].InnerText, node["Uname"].InnerText, node["Email"].InnerText };
                    return res;
                }
            }
            return null;
        }
    }
}
