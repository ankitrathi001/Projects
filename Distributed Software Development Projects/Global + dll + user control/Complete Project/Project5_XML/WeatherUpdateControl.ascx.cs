using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Xml;
using System.Net;
using System.Text.RegularExpressions;

namespace Project5_XML
{
    public partial class WeatherUpdateControl : System.Web.UI.UserControl
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            Label1.Text = "";
            string IP = System.Web.HttpContext.Current.Request.ServerVariables["HTTP_X_FORWARDED_FOR"];
            if (string.IsNullOrEmpty(IP))
            {
                IP = System.Web.HttpContext.Current.Request.Params["REMOTE_ADDR"];
            }
            IPAddress addrss = IPAddress.Parse(IP);
            Label1.Text = "Your IP Addr: ";
            Label1.Text += addrss.MapToIPv4().ToString() + "<br /> WeatherUpdate: <br />";

            string baseURL = "https://query.yahooapis.com/v1/public/";
            string YQL = String.Format("yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22{0}%22)&format=xml&env=store%3A%2F%2Fdatatables.org%2Falltableswithkey", "Tempe");
            XmlDocument woeidData = new XmlDocument();
            woeidData.Load(baseURL + YQL);
            string res = "";
            res += woeidData.GetElementsByTagName("description")[1].InnerText;
            string[] result = Regex.Split(res, "<BR />");

            Label1.Text += result[0] + "<br />" + result[1] + "<br />";
        }
    }
}