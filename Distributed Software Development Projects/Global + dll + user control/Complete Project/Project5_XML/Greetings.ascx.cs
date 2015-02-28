using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Project5_XML
{
    public partial class Greetings : System.Web.UI.UserControl
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            String greet = "";
            Int32 h = DateTime.Now.Hour;
            string uname = "";
            if (Session["uname"] != null)
                uname = (string)Session["uname"];
            else
                uname = "Guest";
            if (h > 5 && h <= 12) greet = "Good Morning "+uname;
            else if (h > 12 && h <= 17) greet = "Good Afternoon " + uname;
            else if (h > 17 && h <= 5) greet = "Good Evening " + uname;
            Label1.Text = greet;
        }
    }
}