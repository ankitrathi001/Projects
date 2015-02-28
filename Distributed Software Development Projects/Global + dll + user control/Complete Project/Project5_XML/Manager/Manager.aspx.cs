using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Collections;
using System.Data;
using System.IO;
using System.Xml;

namespace Project5_XML
{
    public partial class Manager : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            try
            {
                string username = (string)Session["uname"];
                string role = (string)Session["role"];
                getProfileService gps = new getProfileService();
                string[] res = gps.getProfile(username);
                Label4.Text = "";
                Label5.Text = "";
                Label6.Text = "";
                if (res != null)
                {
                    Label1.Text = res[0];
                    Label2.Text = res[1];
                    Label3.Text = res[2];
                }
                else
                    Response.Redirect("/Login.aspx");
                if (!IsPostBack)
                {
                    DropDownList1.DataSource = CreateDataSource();
                    DropDownList1.DataTextField = "TextField";
                    DropDownList1.DataValueField = "ValueField";
                    DropDownList1.DataBind();
                }
            }
            catch (Exception) { Response.Redirect("/Login.aspx"); }
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            Session.Clear();
            Response.Redirect("/Login.aspx");
        }

        protected void Button2_Click(object sender, EventArgs e)
        {
            getProfileService gps = new getProfileService();
            string[] res = gps.getProfile(DropDownList1.SelectedItem.Text);
            if (res != null)
            {
                Label4.Text = "Name: "+res[0];
                Label5.Text = "User Name: "+res[1];
                Label6.Text = "Email: "+res[2];
            }
        }
        ICollection CreateDataSource()
        {
            DataTable dt = new DataTable();
            dt.Columns.Add(new DataColumn("TextField", typeof(String)));
            dt.Columns.Add(new DataColumn("ValueField", typeof(String)));
            string fLocation = Path.Combine(HttpRuntime.AppDomainAppPath, @"App_Data");
            string file = Path.Combine(fLocation, "Role.xml");
            XmlDocument xDoc = new XmlDocument();
            xDoc.Load(file);
            XmlNodeList nodes = xDoc.GetElementsByTagName("User");

            foreach (XmlNode node in nodes)
            {
                if (node["Role"].InnerText == "Staff" || node["Role"].InnerText == "Member")
                {
                    dt.Rows.Add(CreateRow(node["Uname"].InnerText, node["Uname"].InnerText, dt));
                }
            }
            DataView dv = new DataView(dt);
            return dv;
        }

        DataRow CreateRow(String Text, String Value, DataTable dt)
        {
            DataRow dr = dt.NewRow();
            dr[0] = Text;
            dr[1] = Value;
            return dr;
        }
    }
}