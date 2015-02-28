using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace BankingTryIt
{
    public partial class ProcessTransactionTryIt : System.Web.UI.Page
    {
        BankingServiceProxy.BankingServiceClient BSC = new BankingServiceProxy.BankingServiceClient();
        protected void Page_Load(object sender, EventArgs e)
        {
            if (String.IsNullOrEmpty((string)Session["Uname"]))
                Response.Redirect("LoginTryIt.aspx");
            Label1.Text = (string)Session["Uname"];
            Label2.Text = "";
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            if (String.IsNullOrEmpty((string)Session["Uname"]))
                Response.Redirect("LoginTryIt.aspx");
            try
            {
                double a = Convert.ToDouble(TextBox5.Text);
                if (a < 0)
                    Response.Redirect("ProcessTransactionTryIt.aspx?Err=Invalid_amount");
            }
            catch (Exception) { Response.Redirect("ProcessTransactionTryIt.aspx?Err=Invalid_amount"); }
            Label2.Text = BSC.processTransaction((string)Session["Uname"], TextBox1.Text, TextBox2.Text, TextBox3.Text, TextBox4.Text, TextBox5.Text);
        }

        protected void Button2_Click(object sender, EventArgs e)
        {
            if (String.IsNullOrEmpty((string)Session["Uname"]))
                Response.Redirect("LoginTryIt.aspx");
            Response.Redirect("getTransactionHistoryTryIt.aspx");
        }
    }
}