using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SortByRatingTryIt
{
    public partial class TryIt : System.Web.UI.Page
    {
        SortByRatingProxy.IsortByCrimeDataServiceClient sbr = new SortByRatingProxy.IsortByCrimeDataServiceClient();
        protected void Page_Load(object sender, EventArgs e)
        {
            Label1.Text = "";
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            string cities = TextBox1.Text;
            string[] sortedCities = sbr.sortCitiesByCrimeRate(cities);
            for (int i = 0; i < sortedCities.Length; i++)
            {
                Label1.Text += sortedCities[i] + "<br />";
            }
        }
    }
}