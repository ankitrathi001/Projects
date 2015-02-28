using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WeatherUpdateWebApp
{
    public partial class WeatherServiceTryIt : System.Web.UI.Page
    {
        WeatherServiceProxy.WeatherServiceClient w = new WeatherServiceProxy.WeatherServiceClient();
        protected void Page_Load(object sender, EventArgs e)
        {
            Label1.Text = "";
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            Label1.Text = w.getWeatherUpdate(TextBox1.Text);
        }
    }
}