using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace TemperatureConversionTryIt
{
    public partial class TemperatureConversionTryIt : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            Response.Redirect(String.Format("http://webstrar42.fulton.asu.edu/page2/TemperatureConversionService.svc/f2c?f={0}",TextBox1.Text));
        }

        protected void Button2_Click(object sender, EventArgs e)
        {
            Response.Redirect(String.Format("http://webstrar42.fulton.asu.edu/page2/TemperatureConversionService.svc/c2f?c={0}", TextBox2.Text));
        }
    }
}