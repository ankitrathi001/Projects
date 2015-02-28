using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using TemperatureConversionWebsiteProxy;

public partial class _Default : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }

    protected void TextBox1_TextChanged(object sender, EventArgs e)
    {

    }
    protected void TextBox2_TextChanged(object sender, EventArgs e)
    {

    }

    protected void Button1_Click1(object sender, EventArgs e)
    {
        Label1.Text = "°C";
        /*  Exception handling */
        try
        {
            TemperatureServiceClient T = new TemperatureServiceClient();        //Creating the proxy client.
            int num;
            if (int.TryParse(TextBox1.Text, out num))                           //To check if entered value is integer or not.
            {
                int F = Convert.ToInt32(TextBox1.Text);
                int C = T.f2c(F);                                               //Calling the function to convert °F to °C.
                Label1.Text = C.ToString() + " " + Label1.Text;
            }
            else
                Label1.Text = "Please enter integer value";
            T.Close();                                                          //Proxy client closed.
        }
        catch (Exception)
        {
            Label1.Text = "Service not available! Please check the configuration.";
            return;
        }
    }

    protected void Button2_Click(object sender, EventArgs e)
    {
        Label2.Text = "°F";
        /*  Exception handling */
        try
        {
            TemperatureServiceClient T = new TemperatureServiceClient();        //Creating the proxy client.
            int num;
            if (int.TryParse(TextBox2.Text, out num))                           //To check if entered value is integer or not.
            {
                int C = Convert.ToInt32(TextBox2.Text);
                int F = T.c2f(C);                                               //Calling the function to convert °C to °F.
                Label2.Text = F.ToString() + " " + Label2.Text;
            }
            else
                Label2.Text = "Please enter integer value";
            T.Close();                                                          //Proxy client closed.
        }
        catch (Exception)
        {
            Label2.Text = "Service not available! Please check the configuration.";
            return;
        }
    }
}