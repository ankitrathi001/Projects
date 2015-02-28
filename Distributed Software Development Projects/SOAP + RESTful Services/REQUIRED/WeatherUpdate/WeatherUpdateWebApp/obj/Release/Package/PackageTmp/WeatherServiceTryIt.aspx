<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WeatherServiceTryIt.aspx.cs" Inherits="WeatherUpdateWebApp.WeatherServiceTryIt" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>TryIt Page for Weather Service</title>
    <link rel="stylesheet" href="/StyleSheet1.css" />
</head>
<body>
    <form id="form1" runat="server">
        <div>
    <div class="gradientBoxesWithOuterShadows">
    
        <strong>TryIt Page for Weather Service<br />
        <br />
        </strong><br />
        <b>Description:</b> This service is used to get the weather update and forecast for a particular city based on city name or zipcode.<br />
        <b>URL: </b><a href="http://webstrar42.fulton.asu.edu/Page2/WeatherService.svc?wsdl" style="font-family:Arial; font-size:14px;">http://webstrar42.fulton.asu.edu/Page2/WeatherService.svc?wsdl</a><br />
        <b>Operation: </b>string getWeatherUpdate(string zipcode)<br />
        <b>Input: </b>string zipcode<br />
        <b>Output: </b>string WeatherUpdate<br />
        <b>Example: </b>zipcode: 85281<br /> 
        Enter the City Name or Zip code: <asp:TextBox ID="TextBox1" runat="server"></asp:TextBox>
        <asp:Button ID="Button1" runat="server" OnClick="Button1_Click" Text="Get Weather Update" CssClass="button" />
    
    
        <p style="text-align:center;">
            <asp:Label ID="Label1" runat="server" Text="Label"></asp:Label>
        </p>
        </div></div>
    </form>
</body>
</html>
