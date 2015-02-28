<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Register.aspx.cs" Inherits="Project5_XML.Register" %>
<%@ Register TagPrefix="myControl" TagName="Combined" Src="~/Combined.ascx" %>
<%@ Register TagPrefix="myControl" TagName="Copyright" Src="~/Copyright.ascx" %>


<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <header><myControl:Combined runat="server" /></header>
    <div>
    
        Name:<asp:TextBox ID="TextBox1" runat="server" required="required"></asp:TextBox>
        <br />
        E-mail:<asp:TextBox ID="TextBox2"  type="email" runat="server" required="required"></asp:TextBox>
        <br />
        Username:<asp:TextBox ID="TextBox3" runat="server" required="required"></asp:TextBox>
        <br />
        Password:<asp:TextBox ID="TextBox4"  type="password" runat="server" required="required"></asp:TextBox>
        <br />
        Confirm Password:<asp:TextBox ID="TextBox5"  type="password" runat="server" required="required"></asp:TextBox>
        <br />
        <asp:Image ID="Image1" runat="server" />
        <asp:Button ID="Button2" runat="server" OnClick="Button2_Click" Text="Change Image" />
        <br />
        Enter Captcha:<asp:TextBox ID="TextBox6" runat="server" required="required"></asp:TextBox>
        <br />
        <asp:Label ID="Label1" runat="server" Text="Label"></asp:Label>
        <br />
        <asp:Button ID="Button1" runat="server" OnClick="Button1_Click" Text="Register" />
    
    </div>
    </form>
    <footer><myControl:Copyright runat="server" /></footer>
</body>
</html>
