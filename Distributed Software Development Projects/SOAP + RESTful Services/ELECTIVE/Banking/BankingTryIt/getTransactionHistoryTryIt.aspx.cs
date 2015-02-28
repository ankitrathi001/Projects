using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace BankingTryIt
{
    public partial class getTransactionHistoryTryIt : System.Web.UI.Page
    {
        BankingServiceProxy.BankingServiceClient BSC = new BankingServiceProxy.BankingServiceClient();
        protected void Page_Load(object sender, EventArgs e)
        {
            Label1.Text = "";
            if (String.IsNullOrEmpty((string)Session["Uname"]))
                Response.Redirect("LoginTryIt.aspx");
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            if (String.IsNullOrEmpty((string)Session["Uname"]))
                Response.Redirect("LoginTryIt.aspx");
            string[] result = BSC.getTransactionHistory((string)Session["Uname"]);
            if (result != null)
            {
                foreach (string s in result)
                {
                    Label1.Text += s + "<br />";
                }
            }
            else
                Label1.Text = "History not available!";
        }

        protected void Button2_Click(object sender, EventArgs e)
        {
            if (String.IsNullOrEmpty((string)Session["Uname"]))
                Response.Redirect("LoginTryIt.aspx");
            Response.Redirect("ProcessTransactionTryIt.aspx");
        }
    }
}