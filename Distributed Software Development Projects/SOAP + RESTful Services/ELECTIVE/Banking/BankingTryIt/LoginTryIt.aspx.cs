using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Runtime.Serialization;

namespace BankingTryIt
{
    public partial class LoginTryIt : System.Web.UI.Page
    {
        BankingServiceProxy.BankingServiceClient BSC = new BankingServiceProxy.BankingServiceClient();
        protected void Page_Load(object sender, EventArgs e)
        {
            Label1.Text = "";
            string uname = (string)Session["Uname"];
            if (!String.IsNullOrEmpty(uname))
                Response.Redirect("ProcessTransactionTryIt.aspx");
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            if (BSC.LoginVerification(TextBox1.Text, TextBox2.Text))
            {
                Label1.Text = "LoggedIn";
                Session["Uname"] = TextBox1.Text;
                Response.Redirect("ProcessTransactionTryIt.aspx");
            }
            else
                Label1.Text = "Invalid";
        }
    }
}