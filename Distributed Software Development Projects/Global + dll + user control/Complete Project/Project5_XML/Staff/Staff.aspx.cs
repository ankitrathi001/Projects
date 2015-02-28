using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Project5_XML
{
    public partial class Staff : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            try
            {
                string username = (string)Session["uname"];
                string role = (string)Session["role"];
                getProfileService gps = new getProfileService();
                string[] res = gps.getProfile(username);
                if(res!=null)
                {
                    Label1.Text = res[0];
                    Label2.Text = res[1];
                    Label3.Text = res[2];
                }
                else
                    Response.Redirect("/Login.aspx");
            }
            catch (Exception) { Response.Redirect("/Login.aspx"); }
        }
    }
}