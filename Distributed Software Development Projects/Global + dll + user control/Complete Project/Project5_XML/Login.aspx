<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Login.aspx.cs" Inherits="Project5_XML.Login" %>
<%@ Register TagPrefix="myControl" TagName="Copyright" Src="~/Copyright.ascx" %>
<%@ Register TagPrefix="myControl" TagName="Combined" Src="~/Combined.ascx" %>
<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <header><myControl:Combined runat="server" /></header>
    <div>
        
        Username:<asp:TextBox ID="TextBox1" runat="server"></asp:TextBox>
        <br />
        Password:<asp:TextBox ID="TextBox2" type="password" runat="server"></asp:TextBox>
        <br />
        <asp:Label ID="Label1" runat="server" Text="Label"></asp:Label>
        <br />
        <asp:Button ID="Button1" runat="server" OnClick="Button1_Click" Text="Login" />
    
    </div>
        
    </form>
    <footer><myControl:Copyright runat="server" /></footer>
</body>
</html>
