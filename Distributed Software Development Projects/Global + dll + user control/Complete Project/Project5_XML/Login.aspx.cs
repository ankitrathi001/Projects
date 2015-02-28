using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using OneWayHashing;
using System.Web.Security;

namespace Project5_XML
{
    public partial class Login : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            Label1.Text = "";
            if(Session["uname"]!=null)
                Response.Redirect(String.Format("{0}/{1}.aspx", Session["role"], Session["role"]));
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            LoginService ls = new LoginService();
            string role=ls.login(TextBox1.Text, Hashing.getHash(TextBox2.Text));
            if (role!=null)
            {
                Label1.Text = "Login Success!";
                if (role == "null")
                    Label1.Text += "<br />Role not assigned for you. So logging you out!";
                else 
                {
                    Session["uname"] = TextBox1.Text;
                    Session["role"] = role;
                    //Label1.Text = String.Format("{0}.aspx", role);
                    FormsAuthenticationTicket ticket = new FormsAuthenticationTicket(
                        1, // Ticket version
                        TextBox1.Text, // Username associated with ticket
                        DateTime.Now, // Date/time issued
                        DateTime.Now.AddMinutes(30), // Date/time to expire
                        true, // "true" for a persistent user cookie
                        role, // User-data, in this case the roles
                        FormsAuthentication.FormsCookiePath// Path cookie valid for
                    );
                    string hash = FormsAuthentication.Encrypt(ticket);
                    HttpCookie cookie = new HttpCookie(
                        FormsAuthentication.FormsCookieName, // Name of auth cookie
                        hash
                    ); // Hashed ticket
                    // Set the cookie's expiration time to the tickets expiration time
                    if (ticket.IsPersistent) cookie.Expires = ticket.Expiration;

                    // Add the cookie to the list for outgoing response
                    Response.Cookies.Add(cookie);

                    Response.Redirect(String.Format("{0}/{1}.aspx",role,role));
                }
            }
            else
                Label1.Text = "Login Failure!";
        }
    }
}