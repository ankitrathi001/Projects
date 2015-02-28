using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Xml;
using System.IO;
using System.Text;

namespace Hotels
{
    public partial class ParseXML : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            Label1.Text = "";
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            XmlTextReader xmlReader = new XmlTextReader(TextBox1.Text);
            int i = 0;

            Label1.Text += "<br /><div class=\"element\">Element - Displayed in black color</div><br />";
            Label1.Text += "<div class=\"attribute\">Attribute (Name and Value) - Displayed in red color</div><br />";
            Label1.Text += "<div class=\"value\">Text Content - Displayed in blue color</div></div>";
            while (xmlReader.Read())
            {
                switch (xmlReader.NodeType)
                {
                    case XmlNodeType.Element:
                        Label1.Text += "<br />";
                        for (int j = 0; j < i; j++)
                            Label1.Text += "&nbsp;&nbsp;&nbsp;&nbsp;";
                        Label1.Text += "<div class=\"element\">" + xmlReader.Name + "</div>";
                        if (xmlReader.HasAttributes)
                        {
                            Label1.Text += " <div class=\"attribute\">[ ";
                            while (xmlReader.MoveToNextAttribute())
                            {
                                Label1.Text += String.Format(" {0} = {1}", xmlReader.Name, xmlReader.Value);
                            }
                            Label1.Text += " ]</div>";
                        }
                        i++;
                        break;
                    case XmlNodeType.Text:
                        Label1.Text += ":&nbsp;&nbsp;&nbsp;&nbsp;<div class=\"value\">" + xmlReader.Value + "</div>";
                        break;
                    case XmlNodeType.EndElement:
                        i--;
                        break;
                }
            }
        }
    }
}