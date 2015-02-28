using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;
using System.Xml;
using System.Web.UI;
using System.Xml.Linq;
using System.Text.RegularExpressions;

namespace WeatherUpdate
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "WeatherService" in code, svc and config file together.
    // NOTE: In order to launch WCF Test Client for testing this service, please select WeatherService.svc or WeatherService.svc.cs at the Solution Explorer and start debugging.
    public class WeatherService : IWeatherService
    {
        public string getWeatherUpdate(string city)
        {
            try
            {
                string baseURL = "https://query.yahooapis.com/v1/public/";
                string YQL = String.Format("yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22{0}%22)&format=xml&env=store%3A%2F%2Fdatatables.org%2Falltableswithkey", city);
                XmlDocument woeidData = new XmlDocument();
                woeidData.Load(baseURL+YQL);
                string res = "";
                res += woeidData.GetElementsByTagName("title")[0].InnerText + "<br>";
                res += woeidData.GetElementsByTagName("lastBuildDate")[0].InnerText + "<br>";
                res += woeidData.GetElementsByTagName("description")[1].InnerText + "<br>";
                return res;
            }
            catch (Exception e)
            {
                return ("Please enter a valid city name or zip code!");
            }
        }
        public string[] getWeatherUpdate2(string city)
        {
            try
            {
                string baseURL = "https://query.yahooapis.com/v1/public/";
                string YQL = String.Format("yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22{0}%22)&format=xml&env=store%3A%2F%2Fdatatables.org%2Falltableswithkey", city);
                XmlDocument woeidData = new XmlDocument();
                woeidData.Load(baseURL + YQL);
                string res = "";
                res += woeidData.GetElementsByTagName("title")[0].InnerText + "<br>";
                res += woeidData.GetElementsByTagName("lastBuildDate")[0].InnerText + "<br>";
                res += woeidData.GetElementsByTagName("description")[1].InnerText + "<br>";
                return Regex.Split(res,"<br />");
            }
            catch (Exception e)
            {
                var a = new List<String>();
                a.Add("!");
                a.Add("Please enter a valid city name or zip code!");
                return a.ToArray();
            }
        }
    }
}
