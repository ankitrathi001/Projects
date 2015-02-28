using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;
using System.IO;
using System.Web;
using System.Xml.XPath;
using System.Xml;
using OneWayHashing;

namespace Project5_XML
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "RegisterService" in code, svc and config file together.
    // NOTE: In order to launch WCF Test Client for testing this service, please select RegisterService.svc or RegisterService.svc.cs at the Solution Explorer and start debugging.
    public class RegisterService : IRegisterService
    {
        public string registerMember(string name, string email, string username, string password, string role)
        {
            string err = "";
            string fLocation = Path.Combine(HttpRuntime.AppDomainAppPath, @"App_Data");
            string path = Path.Combine(fLocation, "Register.xml");
            try{
                XPathDocument xPathDocument = new XPathDocument(path);
                XPathNavigator xPathNavigator = xPathDocument.CreateNavigator();
                XPathNodeIterator xPathNodeIterator = xPathNavigator.Select("//User");
                int i = 0;
                while (xPathNodeIterator.MoveNext())
                {
                    i++;
                    XPathNodeIterator unameXml = xPathNodeIterator.Current.Select("Uname");
                    unameXml.MoveNext();
                    if (username.Equals(unameXml.Current.InnerXml))
                        return "" + username + " already exists.";
                }

                XmlDocument xDoc = new XmlDocument();
                xDoc.Load(path);
                XmlDocument xDoc2 = new XmlDocument();
                xDoc2.Load(Path.Combine(fLocation, "Role.xml"));

                XmlNode nodeUser = xDoc.CreateNode(XmlNodeType.Element, "User", null);
                XmlNode nodeUser2 = xDoc2.CreateNode(XmlNodeType.Element, "User", null);

                XmlNode Name = xDoc.CreateElement("Name");
                Name.InnerText = name;
                XmlNode Email = xDoc.CreateElement("Email");
                Email.InnerText = email;
                XmlNode Username = xDoc.CreateElement("Uname");
                Username.InnerText = username;
                XmlNode Username2 = xDoc2.CreateElement("Uname");
                Username2.InnerText = username;
                XmlNode Password = xDoc2.CreateElement("Password");
                Password.InnerText = Hashing.getHash(password);
                XmlNode Role = xDoc2.CreateElement("Role");
                Role.InnerText = role;

                nodeUser.AppendChild(Name);
                nodeUser.AppendChild(Email);
                nodeUser.AppendChild(Username);
                nodeUser2.AppendChild(Username2);
                nodeUser2.AppendChild(Password);
                nodeUser2.AppendChild(Role);

                XmlNode root = xDoc.DocumentElement;
                root.AppendChild(nodeUser);
                xDoc.Save(path);
                XmlNode root2 = xDoc2.DocumentElement;
                root2.AppendChild(nodeUser2);
                xDoc2.Save(Path.Combine(fLocation, "Role.xml"));

                return "Registration successful";
            }
            catch(Exception e){err=e+"<br />Unable to Register!";}

            return err;
        }
    }
}
