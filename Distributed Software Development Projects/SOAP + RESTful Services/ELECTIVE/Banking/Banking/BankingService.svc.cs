using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;
using System.Xml.Serialization;
using System.Xml;
using System.Web;
using System.IO;
using System.Text.RegularExpressions;

namespace Banking
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "BankingService" in code, svc and config file together.
    // NOTE: In order to launch WCF Test Client for testing this service, please select BankingService.svc or BankingService.svc.cs at the Solution Explorer and start debugging.
    public class CompleteDetails
    {
        public string FirstName;
        public string LastName;
        public string Email;
        public string initialAmount;
        public CompleteDetails() { }
        public CompleteDetails(string[] details)
        {
            this.FirstName = details[0];
            this.LastName = details[1];
            this.Email = details[2];
            this.initialAmount = details[4];
        }
    }
    public class LoginDetails
    {
        public string Email;
        public string Password;
        public LoginDetails() { }
        public LoginDetails(string[] details) 
        {
            this.Email = details[2];
            this.Password = details[3];
        }

    }
    public class AccountDetails
    {
        public string Email;
        public string CardNumber;
        public string CVV;
        public string ExpMonth;
        public string ExpYear;
        public string amount;
        public AccountDetails() { }
        public AccountDetails(string[] details) 
        {
            DateTime now = DateTime.Now;
            this.Email = details[2];
            this.CardNumber = generateCardNumber();
            this.CVV = generateCVV();
            this.ExpMonth = now.Month.ToString();
            this.ExpYear = (now.Year+2).ToString();
            this.amount = details[4];
        }
        public string generateCardNumber()
        {
            string cardnumber = "";
            Random rnd = new Random();
            for (int i = 0; i < 4; i++)  
                cardnumber+= rnd.Next(1000, 9999); 
            return cardnumber;
        }
        public string generateCVV()
        {
            string cvv = "";
            Random rnd = new Random();
            cvv = rnd.Next(100,999).ToString();
            return cvv;
        }
    }
    public class TransactionDetails
    {
        public string Email;
        public string Date;
        public string Time;
        public string Amount;
        public string Type;
        public TransactionDetails(string Email, string Amount, string Type)
        {
            DateTime now = DateTime.Now;
            this.Email = Email;
            this.Date = now.ToString("M/d/yyyy");
            this.Time = now.ToString("HH:mm:ss");
            this.Amount = Amount;
            this.Type = Type;
        }
    }
    public class BankingService : IBankingService
    {
        public string[] Registration(string fname, string lname, string email, string password, string amount)
        {
            try
            {
                string[] details = { fname, lname, email, password, amount };
                CompleteDetails cd = new CompleteDetails(details);
                LoginDetails ld = new LoginDetails(details);
                AccountDetails ad = new AccountDetails(details);
                string fLocation = Path.Combine(HttpRuntime.AppDomainAppPath, @"App_Data");
                string file1 = Path.Combine(fLocation, "Registration.xml");
                string file2 = Path.Combine(fLocation, "LoginInfo.xml");
                XmlDocument xDocument = new XmlDocument();
                xDocument.Load(file2);
                XmlNodeList nodesX = xDocument.GetElementsByTagName("LoginDetails");
                foreach (XmlNode nodeX in nodesX)
                {
                    if (nodeX["Uname"].InnerText == email)
                    {
                        return null;
                    }
                }

                string file3 = Path.Combine(fLocation, "AccountInfo.xml");
                string file4 = Path.Combine(fLocation, "TransactionDetails.xml");
                if (!File.Exists(file1))
                {
                    StreamWriter sw = File.CreateText(file1);
                    sw.WriteLine("<root xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">");
                    sw.Close();
                    sw = File.CreateText(file2);
                    sw.WriteLine("<root xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">");
                    sw.Close();
                    sw = File.CreateText(file3);
                    sw.WriteLine("<root xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">");
                    sw.Close();
                    sw = File.CreateText(file4);
                    sw.WriteLine("<root xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">");
                    sw.Close();
                }
                else
                {
                    List<string> lines = File.ReadAllLines(file1).ToList();
                    File.WriteAllLines(file1, lines.GetRange(0, lines.Count - 1).ToArray());
                    List<string> lines2 = File.ReadAllLines(file2).ToList();
                    File.WriteAllLines(file2, lines2.GetRange(0, lines2.Count - 1).ToArray());
                    List<string> lines3 = File.ReadAllLines(file3).ToList();
                    File.WriteAllLines(file3, lines3.GetRange(0, lines3.Count - 1).ToArray());
                    List<string> lines4 = File.ReadAllLines(file4).ToList();
                    File.WriteAllLines(file4, lines4.GetRange(0, lines4.Count - 1).ToArray());
                }
                using (StreamWriter sw = File.AppendText(file1))
                {
                    sw.WriteLine("   <CompleteDetails>");
                    sw.WriteLine(String.Format("      <FirstName>{0}</FirstName>", cd.FirstName));
                    sw.WriteLine(String.Format("      <LastName>{0}</LastName>", cd.LastName));
                    sw.WriteLine(String.Format("      <Email>{0}</Email>", cd.Email));
                    sw.WriteLine(String.Format("      <Amount>{0}</Amount>", cd.initialAmount));
                    sw.WriteLine("   </CompleteDetails>");
                    sw.WriteLine("</root>");
                    sw.Close();
                }
                using (StreamWriter sw = File.AppendText(file2))
                {
                    sw.WriteLine("   <LoginDetails>");
                    sw.WriteLine(String.Format("      <Uname>{0}</Uname>", ld.Email));
                    sw.WriteLine(String.Format("      <Password>{0}</Password>", ld.Password));
                    sw.WriteLine("   </LoginDetails>");
                    sw.WriteLine("</root>");
                    sw.Close();
                }
                using (StreamWriter sw = File.AppendText(file3))
                {
                    sw.WriteLine("   <AccountDetails>");
                    sw.WriteLine(String.Format("      <Email>{0}</Email>", ad.Email));
                    sw.WriteLine(String.Format("      <CardNumber>{0}</CardNumber>", ad.CardNumber));
                    sw.WriteLine(String.Format("      <CVV>{0}</CVV>", ad.CVV));
                    sw.WriteLine(String.Format("      <ExpMonth>{0}</ExpMonth>", ad.ExpMonth));
                    sw.WriteLine(String.Format("      <ExpYear>{0}</ExpYear>", ad.ExpYear));
                    sw.WriteLine(String.Format("      <Amount>{0}</Amount>", ad.amount));
                    sw.WriteLine("   </AccountDetails>");
                    sw.WriteLine("</root>");
                    sw.Close();
                }
                using (StreamWriter sw = File.AppendText(file4))
                {
                    sw.WriteLine("   <TransactionDetails>");
                    sw.WriteLine(String.Format("      <Uname>{0}</Uname>", ld.Email));
                    sw.WriteLine("   </TransactionDetails>");
                    sw.WriteLine("</root>");
                    sw.Close();
                }
                XmlDocument xDoc = new XmlDocument();
                xDoc.Load(file4);
                XmlNodeList nodes = xDoc.GetElementsByTagName("TransactionDetails");
                foreach (XmlNode node in nodes)
                {
                    if (node["Uname"].InnerText == cd.Email)
                    {
                        TransactionDetails td = new TransactionDetails(cd.Email, cd.initialAmount, "Credit");
                        XmlElement newNode = xDoc.CreateElement("Transaction");
                        newNode.SetAttribute("Date", td.Date);
                        newNode.SetAttribute("Time", td.Time);
                        newNode.SetAttribute("Type", td.Type);
                        newNode.InnerText = td.Amount;
                        node.AppendChild(newNode);
                        xDoc.Save(file4);
                    }
                }
                string[] result = { ad.CardNumber, ad.CVV, ad.ExpMonth, ad.ExpYear };
                return result;
            }
            catch (FileNotFoundException) { return null; }
            catch (Exception) { return null; }
            
        }
        public bool LoginVerification(string uname, string password)
        {
            try
            {
                string fLocation = Path.Combine(HttpRuntime.AppDomainAppPath, @"App_Data");
                string file = Path.Combine(fLocation, "LoginInfo.xml");
                XmlDocument xDoc = new XmlDocument();
                xDoc.Load(file);
                XmlNodeList nodes = xDoc.GetElementsByTagName("LoginDetails");
                string Error = "";
                bool flag = false;
                foreach (XmlNode node in nodes)
                {
                    if (node["Uname"].InnerText == uname)
                    {
                        flag = true;
                        if (node["Password"].InnerText == password)
                        {
                            return true;
                        }
                        else
                            Error = "Invalid Password";
                    }
                }
                if (flag == false)
                    Error = "User does not exist";
            }
            catch (FileNotFoundException) { return false; }
            catch (Exception) { return false; }
            return false;
        }
        public string processTransaction(string UserName, string CardNumber, string CVV, string ExpMonth, string ExpYear, string Amount)
        {
            try
            {
                string fLocation = Path.Combine(HttpRuntime.AppDomainAppPath, @"App_Data");
                string file = Path.Combine(fLocation, "AccountInfo.xml");
                string file4 = Path.Combine(fLocation, "TransactionDetails.xml");
                XmlDocument xDoc = new XmlDocument();
                xDoc.Load(file);
                XmlNodeList nodes = xDoc.GetElementsByTagName("AccountDetails");
                foreach (XmlNode node in nodes)
                {
                    if (node["Email"].InnerText == UserName)
                    {
                        if (node["CardNumber"].InnerText == CardNumber && node["CVV"].InnerText == CVV && node["ExpMonth"].InnerText == ExpMonth && node["ExpYear"].InnerText == ExpYear)
                        {
                            if (Convert.ToDouble(node["Amount"].InnerText) >= Convert.ToDouble(Amount))
                            {
                                node["Amount"].InnerText = "" + (Convert.ToDouble(node["Amount"].InnerText) - Convert.ToDouble(Amount));
                                xDoc.Save(file);
                                xDoc.Load(file4);
                                XmlNodeList nodes1 = xDoc.GetElementsByTagName("TransactionDetails");
                                foreach (XmlNode node1 in nodes1)
                                {
                                    if (node1["Uname"].InnerText == UserName)
                                    {
                                        TransactionDetails td = new TransactionDetails(UserName, Amount, "Debit");
                                        XmlElement newNode = xDoc.CreateElement("Transaction");
                                        newNode.SetAttribute("Date", td.Date);
                                        newNode.SetAttribute("Time", td.Time);
                                        newNode.SetAttribute("Type", td.Type);
                                        newNode.InnerText = td.Amount;
                                        node1.AppendChild(newNode);
                                        xDoc.Save(file4);
                                    }
                                }
                                return String.Format("Transaction Successfully Completed! <br />Current Balance: {0}", node["Amount"].InnerText);
                            }
                            else
                                return String.Format("Not enough balance in your account! <br />Current Balance: {0}", node["Amount"].InnerText);
                        }
                        else
                            return "Invalid Data!";
                    }
                }
                return "Invalid Data!";
            }
            catch (FileNotFoundException) { return "Cannot process the transaction!"; }
            catch (Exception) { return "Server Error!"; }
        }
        public string[] getTransactionHistory(string UserName)
        {
            try
            {
                string[] result = null;
                string fLocation = Path.Combine(HttpRuntime.AppDomainAppPath, @"App_Data");
                string file = Path.Combine(fLocation, "TransactionDetails.xml");
                XmlDocument xDoc = new XmlDocument();
                xDoc.Load(file);
                XmlNodeList nodes = xDoc.GetElementsByTagName("TransactionDetails");
                foreach (XmlNode node in nodes)
                {
                    if (node["Uname"].InnerText == UserName)
                    {
                        XmlNodeList Transactions = node.ChildNodes;
                        double balance = 0;
                        string temp = "";
                        foreach (XmlNode trans in Transactions)
                        {
                            if (trans.Name == "Transaction")
                            {
                                temp += trans.Attributes["Date"].Value + "&nbsp;&nbsp;&nbsp;";
                                temp += trans.Attributes["Time"].Value + "&nbsp;&nbsp;&nbsp;";
                                temp += trans.Attributes["Type"].Value + "&nbsp;&nbsp;&nbsp;";
                                if (trans.Attributes["Type"].Value == "Credit")
                                    balance += Convert.ToDouble(trans.InnerText);
                                else
                                    balance -= Convert.ToDouble(trans.InnerText);
                                temp += trans.InnerText + "<br />";
                            }
                        }
                        temp += "Balance: " + balance;
                        return Regex.Split(temp, "<br />");
                    }
                }
                return result;
            }
            catch (FileNotFoundException) { return null; }
            catch (Exception) { return null; }
        }
    }
}
