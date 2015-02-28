using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace TotalCrimeTryIt
{
    public partial class TryIt : System.Web.UI.Page
    {
        
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            CrimeProxy.CrimeDataServiceClient cp = new CrimeProxy.CrimeDataServiceClient();
            Label1.Text = cp.getTotalCrimes(TextBox1.Text, TextBox2.Text).ToString();

        }
    }
}