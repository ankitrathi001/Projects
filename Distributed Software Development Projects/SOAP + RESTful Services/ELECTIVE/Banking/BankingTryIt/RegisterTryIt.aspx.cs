using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace BankingTryIt
{
    public partial class RegisterTryIt : System.Web.UI.Page
    {
        BankingServiceProxy.BankingServiceClient BSC = new BankingServiceProxy.BankingServiceClient();
        protected void Page_Load(object sender, EventArgs e)
        {
            Label1.Text = "";
            Label2.Text = "";
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            string Error="";
            if (TextBox1.Text.Trim() == "")
                Error = "Please enter First Name <br />";
            if (TextBox2.Text.Trim() == "")
                Error += "Please enter Last Name <br />";
            if (TextBox3.Text.Trim() == "")
                Error += "Please enter E-mail Id <br />";
            if (TextBox4.Text.Trim() == "")
                Error += "Please enter Password <br />";
            if (TextBox5.Text.Trim() == "")
                Error += "Confirm Password field is empty <br />";
            if (TextBox6.Text.Trim() == "")
                Error += "Please enter Initial Amount <br />";
            if (TextBox4.Text != TextBox5.Text)
                Error += "Passwords do not match";
            if (Error != "")
                Response.Redirect("RegisterTryIt.aspx?Err=Err");
            try
            {
                double a = Convert.ToDouble(TextBox6.Text);
                if(a<0)
                    Response.Redirect("RegisterTryIt.aspx?Err=Invalid_amount");
            }
            catch (Exception) { Response.Redirect("RegisterTryIt.aspx?Err=Invalid_amount"); }
            string[] result = BSC.Registration(TextBox1.Text, TextBox2.Text, TextBox3.Text, TextBox4.Text, TextBox6.Text);
            if (result != null)
            {
                Label2.Text = "User Successfully Registered! <br />";
                Label2.Text += "Please use the following details for all your transactions<br />";
                Label2.Text += "Card Number: " + result[0] + "<br />";
                Label2.Text += "CVV: " + result[1] + "<br />";
                Label2.Text += "Expiry (Month): " + result[2] + "<br />";
                Label2.Text += "Expiry (Year): " + result[3] + "<br />";
            }
            else
                Label2.Text = "Unable to register! Please try again";
        }
    }
}