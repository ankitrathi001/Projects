using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace CrimeDataWebApp
{
    public partial class TotalCrimeTryIt : System.Web.UI.Page
    {
        CrimeDataProxy.CrimeDataServiceClient cds = new CrimeDataProxy.CrimeDataServiceClient();
        protected void Page_Load(object sender, EventArgs e)
        {
            Label1.Text = "";
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            Label1.Text = cds.getTotalCrimes(TextBox1.Text, TextBox2.Text).ToString();
        }
    }
}