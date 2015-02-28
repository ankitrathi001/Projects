using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Project5_XML
{
    public partial class Copyright : System.Web.UI.UserControl
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            string cpyrte = "&copy; 2014 Titans. All rights reserved!!";
            if (Application["Last Access time"] != null)
                Label2.Text = Application["Last Access time"].ToString();
            else
                Label2.Text = "First Time Login";
            Label1.Text = cpyrte;
        }
    }
}