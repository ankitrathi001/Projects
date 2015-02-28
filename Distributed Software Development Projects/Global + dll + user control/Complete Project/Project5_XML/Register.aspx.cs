using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Xml;

namespace Project5_XML
{
    public partial class Register : System.Web.UI.Page
    {
        static string s;
        Random rnd = new Random();
        XmlDocument woeidData = new XmlDocument();
        protected void Page_Load(object sender, EventArgs e)
        {
            Label1.Text = "";
            if (!IsPostBack)
            {
                int n = rnd.Next(5, 10);
                woeidData.Load(String.Format("http://venus.eas.asu.edu/WSRepository/Services/ImageVerifier/Service.svc/GetVerifierString/{0}", n));
                s = woeidData.GetElementsByTagName("string")[0].InnerText;
                Image1.ImageUrl = String.Format("http://venus.eas.asu.edu/WSRepository/Services/ImageVerifier/Service.svc//GetImage/{0}", s);
            }
        }

        protected void Button2_Click(object sender, EventArgs e)
        {
            int n = rnd.Next(5, 10);
            woeidData.Load(String.Format("http://venus.eas.asu.edu/WSRepository/Services/ImageVerifier/Service.svc/GetVerifierString/{0}", n));
            s = woeidData.GetElementsByTagName("string")[0].InnerText;
            Image1.ImageUrl = String.Format("http://venus.eas.asu.edu/WSRepository/Services/ImageVerifier/Service.svc//GetImage/{0}", s);
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            if (TextBox4.Text != TextBox5.Text)
                Label1.Text = "Passwords do not match!";
            else
            {
                if (TextBox6.Text == s)
                {
                    RegisterService rs = new RegisterService();
                    Label1.Text = rs.registerMember(TextBox1.Text, TextBox2.Text,TextBox3.Text, TextBox4.Text, "Member");
                }
                else
                    Label1.Text = "Invalid Captcha!";
            }
        }
    }
}