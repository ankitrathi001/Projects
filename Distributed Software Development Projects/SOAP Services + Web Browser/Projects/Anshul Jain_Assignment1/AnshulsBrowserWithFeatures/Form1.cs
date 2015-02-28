using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Xml;
using System.Xml.Linq;

namespace AnshulsBrowserWithFeatures
{
    public partial class Form1 : Form
    {
        public Button flatButton(Button button)
        {
            button.TabStop = false;
            button.FlatStyle = FlatStyle.Flat;
            button.FlatAppearance.BorderSize = 0;
            return button;
        }
        public Form1()
        {
            InitializeComponent();
            button1 = flatButton(button1);
            button2 = flatButton(button2);
            button7 = flatButton(button7);
            button4 = flatButton(button4);
            button8 = flatButton(button8);
            textBox1.TabStop = false;
            // To load currencies in the comboBox
            foreach (proxyCurrencyConverter.Currency item in Enum.GetValues(typeof(proxyCurrencyConverter.Currency)))
            {
                comboBox1.Items.Add(item);
                comboBox2.Items.Add(item);
            }
            // changing the label text to null
            label2.Text = label3.Text = label4.Text = label5.Text = label13.Text = label14.Text = label16.Text = "";
            label7.Text = label8.Text = label9.Text = label10.Text = label11.Text = label12.Text = label15.Text = "";
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void button5_Click(object sender, EventArgs e)
        {
            if (String.IsNullOrEmpty(textBox2.Text.Trim()))     // To check if user has entered any stock symbol or not
            {
                label2.Text = "Enter Stock Symbol";
            }
            else
            {
                /* Exception handling. If service is not available or there is some problem in configuration */
                try
                {
                    proxyStockQuote.StockQuoteSoapClient StockClient = new proxyStockQuote.StockQuoteSoapClient("StockQuoteSoap");  // Stock Proxy Client
                    string result = StockClient.GetQuote(textBox2.Text.Replace(" ", string.Empty));                                 // Calling the function to get the stock quotes
                    XmlDocument doc = new XmlDocument();
                    /* Parsing the XML resulte received from the webservice */
                    doc.LoadXml(result);
                    XmlNodeList Change = doc.GetElementsByTagName("Change");
                    if (Change[0].InnerXml.Equals("N/A"))           // To check if details are available for a given stock symbol
                    {
                        label2.Text = "Company listing not available!";
                        label3.Text = label4.Text = label5.Text = label13.Text = label14.Text = label16.Text = "";
                        label7.Text = label8.Text = label9.Text = label10.Text = label11.Text = label12.Text = label15.Text = "";
                    }
                    else
                    {
                        label7.Text = "Company Name";
                        label8.Text = "Value";
                        label9.Text = "Change";
                        label10.Text = "% Change";
                        label11.Text = "Last Trade";
                        label12.Text = "Volume";
                        label15.Text = "High/Low";
                        if (Change[0].InnerXml.Contains("+"))
                            label4.ForeColor = System.Drawing.Color.Green;
                        else if (Change[0].InnerXml.Contains("-"))
                            label4.ForeColor = System.Drawing.Color.Red;
                        label4.Text = Change[0].InnerXml;
                        XmlNodeList Name = doc.GetElementsByTagName("Name");
                        label2.Text = Name[0].InnerXml;
                        XmlNodeList LastValue = doc.GetElementsByTagName("Last");
                        label3.Text = LastValue[0].InnerXml;
                        XmlNodeList PercentageChange = doc.GetElementsByTagName("PercentageChange");
                        if (PercentageChange[0].InnerXml.Contains("+"))
                            label5.ForeColor = System.Drawing.Color.Green;
                        else if (PercentageChange[0].InnerXml.Contains("-"))
                            label5.ForeColor = System.Drawing.Color.Red;
                        label5.Text = PercentageChange[0].InnerXml;
                        XmlNodeList Date = doc.GetElementsByTagName("Date");
                        XmlNodeList Time = doc.GetElementsByTagName("Time");
                        label13.Text = Date[0].InnerXml + " " + Time[0].InnerXml;
                        XmlNodeList Volume = doc.GetElementsByTagName("Volume");
                        label14.Text = Volume[0].InnerXml;
                        XmlNodeList High = doc.GetElementsByTagName("High");
                        XmlNodeList Low = doc.GetElementsByTagName("Low");
                        label16.Text = High[0].InnerXml + "/" + Low[0].InnerXml;
                    }
                    StockClient.Close();                                                        // Closed the stock client
                }
                catch(Exception)
                {
                    label2.Text = "Stock service not available! Please check the configuration";
                    label3.Text = label4.Text = label5.Text = label13.Text = label14.Text = label16.Text = "";
                    label7.Text = label8.Text = label9.Text = label10.Text = label11.Text = label12.Text = label15.Text = "";
                    return;
                }
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            webBrowser1.GoBack();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            webBrowser1.GoForward();
        }

        private void button4_Click(object sender, EventArgs e)
        {
            webBrowser1.Stop();
            button7.Visible = true;
            button4.Visible = false;
        }

        private void button6_Click(object sender, EventArgs e)
        {
            /* Exception handling. If service is not available or there is some problem in configuration */
            try
            {
                proxyCurrencyConverter.CurrencyConvertorSoapClient CurrencyClient = new proxyCurrencyConverter.CurrencyConvertorSoapClient("CurrencyConvertorSoap");    // Creating proxy client for CurrencyConverter service
                if (comboBox1.SelectedIndex > -1 && comboBox2.SelectedIndex > -1)                                                                                       // To check if currency is selected or not
                {
                    label6.ForeColor = System.Drawing.Color.Black;
                    label6.Text = "1 " + comboBox1.Text + " = " + CurrencyClient.ConversionRate((proxyCurrencyConverter.Currency)comboBox1.SelectedItem, (proxyCurrencyConverter.Currency)comboBox2.SelectedItem) + " " + comboBox2.Text;
                }
                else
                {
                    label6.ForeColor = System.Drawing.Color.Red;
                    label6.Text = "Currency not selected";
                }
                CurrencyClient.Close();                 //Closed the CurrencyClient
            }
            catch (Exception)
            {
                label6.Text = "Service not available!";
                return;
            }
        }

        private void menuStrip1_ItemClicked(object sender, ToolStripItemClickedEventArgs e)
        {

        }

        private void textBox1_KeyDown(object sender, KeyEventArgs e)            // Navigating to a website as soon as user press enter key
        {
            if (e.KeyCode == Keys.Enter)
            {
                try
                {
                    webBrowser1.Navigate(textBox1.Text);
                }
                catch (System.UriFormatException)
                {
                    return;
                }
            }
        }

        private void webBrowser1_Navigated(object sender, WebBrowserNavigatedEventArgs e)
        {
            button7.Visible=true;
            button4.Visible = false;
            textBox1.Text = webBrowser1.Url.ToString();
        }

        private void textBox1_Click(object sender, EventArgs e)
        {
            textBox1.SelectAll();
        }

        private void webBrowser1_Navigating(object sender, WebBrowserNavigatingEventArgs e)
        {
            button7.Visible = false;
            button4.Visible = true;
        }

        private void button7_Click(object sender, EventArgs e)
        {
            webBrowser1.Refresh();
        }

        private void webBrowser1_DocumentCompleted(object sender, WebBrowserDocumentCompletedEventArgs e)
        {

        }

        private void button8_Click(object sender, EventArgs e)
        {
            webBrowser1.GoHome();
        }

        private void exitToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form1.ActiveForm.Close();
        }

        private void goToolStripMenuItem_Click(object sender, EventArgs e)
        {
            try
            {
                webBrowser1.Navigate(textBox1.Text);
            }
            catch (System.UriFormatException)
            {
                return;
            }
        }

        private void backToolStripMenuItem_Click(object sender, EventArgs e)
        {
            webBrowser1.GoBack();
        }

        private void forwardToolStripMenuItem_Click(object sender, EventArgs e)
        {
            webBrowser1.GoForward();
        }

        private void refreshToolStripMenuItem_Click(object sender, EventArgs e)
        {
            webBrowser1.Refresh();
        }

        private void stopToolStripMenuItem_Click(object sender, EventArgs e)
        {
            webBrowser1.Stop();
        }
    }
}
