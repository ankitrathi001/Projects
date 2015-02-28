using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using TemperatureServiceWindowsTestApp.TemperatureServiceProxy;

namespace TemperatureServiceWindowsTestApp
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            label3.Text = "°C";
            /*  Exception handling  */
            try
            {
                TemperatureServiceClient T = new TemperatureServiceClient();        //Creating the proxy client.
                int num;
                if (int.TryParse(textBox1.Text, out num))                           //To check if entered value is integer or not.
                {
                    int F = Convert.ToInt32(textBox1.Text);
                    int C = T.f2c(F);                                               //Calling the function to convert °F to °C.
                    label3.Text = C.ToString() + " " + label3.Text;
                }
                else
                    label3.Text = "Please enter integer value";
                T.Close();                                                          //Proxy client closed.
            }
            catch (Exception)
            {
                label3.Text = "Service not available!";
                return;
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            /*  Exception Handling  */
            try
            {
                label4.Text = "°F";
                TemperatureServiceClient T = new TemperatureServiceClient();        //Creating the proxy client.
                int num;
                if (int.TryParse(textBox2.Text, out num))                           //To check if entered value is integer or not.
                {
                    int C = Convert.ToInt32(textBox2.Text);
                    int F = T.c2f(C);                                               //Calling the function to convert °C to °F.
                    label4.Text = F.ToString() + " " + label4.Text;
                }
                else
                    label4.Text = "Please enter integer value";
                T.Close();                                                          //Proxy client closed.
            }
            catch (Exception)
            {
                label4.Text = "Service not available!";
                return;
            }
            
        }
    }
}
