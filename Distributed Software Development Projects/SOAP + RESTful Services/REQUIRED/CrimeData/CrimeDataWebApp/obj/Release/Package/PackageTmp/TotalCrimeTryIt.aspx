<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="TotalCrimeTryIt.aspx.cs" Inherits="CrimeDataWebApp.TotalCrimeTryIt" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>TryIt Page for Crime Data Service</title>
    <link rel="stylesheet" href="/StyleSheet1.css" />
</head>
<body>
    <form id="form1" runat="server">
        <div>
    <div class="gradientBoxesWithOuterShadows">
         
        <strong>TryIt page for Crime Data Service<br />
        </strong><br />
        <b>Description:</b> This service is used to get the crime data for a particular city based on its Latitude and longitude.<br />
        <b>URL: </b><a href="http://webstrar42.fulton.asu.edu/Page2/CrimeDataService.svc?wsdl">http://webstrar42.fulton.asu.edu/Page2/CrimeDataService.svc?wsdl</a>
        <br />
        <b>Operation: </b>int getTotalCrimes(string latitude, string longitude)<br />
        <b>Input: </b>string latitude, string longitude<br />
        <b>Output: </b>int TotalCrimes<br />
        <b>Example:</b>Latitude: 40.7127, Longitude: -74.0059 - For New York<br />    
    
        Enter Latitude:&nbsp;&nbsp;&nbsp;
        <asp:TextBox ID="TextBox1" runat="server" required="required"></asp:TextBox>
        <br />
        Enter Longitude:
        <asp:TextBox ID="TextBox2" runat="server" required="required"></asp:TextBox>
        <br />
        <asp:Button ID="Button1" runat="server" OnClick="Button1_Click" Text="Get Crime Data" CssClass="button" />
        <br />
        Total Crimes:
        <asp:Label ID="Label1" runat="server" Text="Label"></asp:Label>
        </div></div>
    </form>
    Click <a href="CrimeDataTryIt.aspx">HERE</a> to go to CrimeDataTryIt Page.
</body>
</html>
