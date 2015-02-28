using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;
using System.Xml;

namespace CrimeData
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "CrimeDataService" in code, svc and config file together.
    // NOTE: In order to launch WCF Test Client for testing this service, please select CrimeDataService.svc or CrimeDataService.svc.cs at the Solution Explorer and start debugging.
    public class CrimeDataService : ICrimeDataService
    {
        private string API_KEY="AIzaSyAYrd6epdfXMbiOdl2_AEHCTwEGDGAxa38";
        public string getAPIKEY() { return this.API_KEY; }
        public string getCrimeData(string lat, string lang)
        {
            string res = "";
            try
            {
                string baseURL1 = "https://maps.googleapis.com/maps/api/geocode/";
                string query1 = String.Format("xml?latlng={0},{1}&key={2}",lat,lang,API_KEY);
                XmlDocument getZip = new XmlDocument();
                getZip.Load(baseURL1 + query1);
                string zipcode = "";
                XmlNodeList xnl = getZip.SelectNodes("/GeocodeResponse/result");
                foreach (XmlNode xn in xnl)
                {
                    if (xn["type"].InnerText == "postal_code")
                    {
                        zipcode = xn["address_component"]["long_name"].InnerText;
                    }
                }
                
                string baseURL2 = "https://azure.geodataservice.net/GeoDataService.svc/";
                string query2 = String.Format("GetUSDemographics?includecrimedata=true&zipcode={0}", zipcode);
                XmlDocument woeidData = new XmlDocument();
                woeidData.Load(baseURL2+query2);

                int ViolentCrime = Convert.ToInt32(woeidData.GetElementsByTagName("ViolentCrime")[0].InnerText);
                int Murder = Convert.ToInt32(woeidData.GetElementsByTagName("MurderAndManslaughter")[0].InnerText);
                int Rape = Convert.ToInt32(woeidData.GetElementsByTagName("ForcibleRape")[0].InnerText);
                int Robbery = Convert.ToInt32(woeidData.GetElementsByTagName("Robbery")[0].InnerText);
                int Assault = Convert.ToInt32(woeidData.GetElementsByTagName("AggravatedAssault")[0].InnerText);
                int Property = Convert.ToInt32(woeidData.GetElementsByTagName("PropertyCrime")[0].InnerText);
                int Burglary = Convert.ToInt32(woeidData.GetElementsByTagName("Burglary")[0].InnerText);
                int Theft = Convert.ToInt32(woeidData.GetElementsByTagName("LarcenyTheft")[0].InnerText);
                int Motor = Convert.ToInt32(woeidData.GetElementsByTagName("MotorVehicleTheft")[0].InnerText);
                int Arson = Convert.ToInt32(woeidData.GetElementsByTagName("Arson")[0].InnerText);

                res += "<b>" + woeidData.GetElementsByTagName("City")[0].InnerText + ", " + woeidData.GetElementsByTagName("State")[0].InnerText + "</b><br /><br />";
                res += "Violent Crime:  " + ViolentCrime + "<br />";
                res += "Murder and Manslaughter:    " + Murder + "<br />";
                res += "Forcible Rape:    " + Rape + "<br />";
                res += "Robbery:    " + Robbery + "<br />";
                res += "Aggravated Assault:    " + Assault + "<br />";
                res += "Property Crime:    " + Property + "<br />";
                res += "Burglary:    " + Burglary + "<br />";
                res += "Larceny Theft:    " + Theft + "<br />";
                res += "Motor-Vehicle Theft:    " + Motor + "<br />";
                res += "Arson:    " + Arson + "<br />";
                int TotalCrime = ViolentCrime + Murder + Rape + Robbery + Assault + Property + Burglary + Theft + Motor + Arson;
                int TotalPopulation = Convert.ToInt32(woeidData.GetElementsByTagName("Population")[0].InnerText);
                long CrimeRate = (((long)TotalCrime * 10000) / TotalPopulation);
                res += "<br />Total Crimes: " + TotalCrime;
                Console.WriteLine(res);
                return res;
            }
            catch (Exception e)
            {
                return ("Please enter correct values!");
            }
        }
        public int getTotalCrimes(string lat, string lang)
        {
            try
            {
                string baseURL1 = "https://maps.googleapis.com/maps/api/geocode/";
                string query1 = String.Format("xml?latlng={0},{1}&key={2}", lat, lang, API_KEY);
                XmlDocument getZip = new XmlDocument();
                getZip.Load(baseURL1 + query1);
                string zipcode = "";
                XmlNodeList xnl = getZip.SelectNodes("/GeocodeResponse/result");
                foreach (XmlNode xn in xnl)
                {
                    if (xn["type"].InnerText == "postal_code")
                    {
                        zipcode = xn["address_component"]["long_name"].InnerText;
                    }
                }

                string baseURL2 = "https://azure.geodataservice.net/GeoDataService.svc/";
                string query2 = String.Format("GetUSDemographics?includecrimedata=true&zipcode={0}", zipcode);
                XmlDocument woeidData = new XmlDocument();
                woeidData.Load(baseURL2 + query2);

                int ViolentCrime = Convert.ToInt32(woeidData.GetElementsByTagName("ViolentCrime")[0].InnerText);
                int Murder = Convert.ToInt32(woeidData.GetElementsByTagName("MurderAndManslaughter")[0].InnerText);
                int Rape = Convert.ToInt32(woeidData.GetElementsByTagName("ForcibleRape")[0].InnerText);
                int Robbery = Convert.ToInt32(woeidData.GetElementsByTagName("Robbery")[0].InnerText);
                int Assault = Convert.ToInt32(woeidData.GetElementsByTagName("AggravatedAssault")[0].InnerText);
                int Property = Convert.ToInt32(woeidData.GetElementsByTagName("PropertyCrime")[0].InnerText);
                int Burglary = Convert.ToInt32(woeidData.GetElementsByTagName("Burglary")[0].InnerText);
                int Theft = Convert.ToInt32(woeidData.GetElementsByTagName("LarcenyTheft")[0].InnerText);
                int Motor = Convert.ToInt32(woeidData.GetElementsByTagName("MotorVehicleTheft")[0].InnerText);
                int Arson = Convert.ToInt32(woeidData.GetElementsByTagName("Arson")[0].InnerText);
                int TotalCrime = ViolentCrime + Murder + Rape + Robbery + Assault + Property + Burglary + Theft + Motor + Arson;
                return TotalCrime;
            }
            catch (Exception e)
            {
                return (0);
            }
        }
    }
}
