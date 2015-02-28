<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="ParseXML.aspx.cs" Inherits="Hotels.ParseXML" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <link rel="stylesheet" href="Style.css" />
    <meta name="viewport" content="width=device-width">
</head>
<body>
    <form id="form1" runat="server">
    <div>
    
        Enter the URL for the XML:
        <asp:TextBox ID="TextBox1" runat="server" Width="586px">http://www.public.asu.edu/~ajain89/DSOD_Assignment4/Hotels.xml</asp:TextBox>
        <asp:Button ID="Button1" runat="server" OnClick="Button1_Click" Text="Parse" />
        <br />
        <asp:Label ID="Label1" runat="server" Text="Label"></asp:Label>
    
    </div>
    </form>
</body>
</html>
