<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="TemperatureConversionTryIt.aspx.cs" Inherits="TemperatureConversionTryIt.TemperatureConversionTryIt" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
    
        Description: This is a RESTful service to convert Temperature.<br />
        URL1: <a href="http://webstrar42.fulton.asu.edu/page2/TemperatureConversionService.svc/f2c?f="">http://webstrar42.fulton.asu.edu/page2/TemperatureConversionService.svc/f2c?f=""</a><br />
        URL2: <a href="http://webstrar42.fulton.asu.edu/page2/TemperatureConversionService.svc/c2f?c="">http://webstrar42.fulton.asu.edu/page2/TemperatureConversionService.svc/c2f?c=""</a><br />
        <br />
        Enter Temperature in °F: <asp:TextBox ID="TextBox1" runat="server"></asp:TextBox>
        <asp:Button ID="Button1" runat="server" OnClick="Button1_Click" Text="Get Temperature in °C" />
        <br />
        Enter Temperature in °C: <asp:TextBox ID="TextBox2" runat="server"></asp:TextBox>
        <asp:Button ID="Button2" runat="server" OnClick="Button2_Click" Text="Get Temperature in °F" />
    
    </div>
    </form>
</body>
</html>
