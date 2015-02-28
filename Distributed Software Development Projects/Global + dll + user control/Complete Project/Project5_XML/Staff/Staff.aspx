<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Staff.aspx.cs" Inherits="Project5_XML.Staff" %>
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
        <b>This is a Staff Page</b><br /><br />
        <b>My Profile:</b><br />
        Name:
        <asp:Label ID="Label1" runat="server" Text="Label"></asp:Label>
        <br />
        User Name:
        <asp:Label ID="Label2" runat="server" Text="Label"></asp:Label>
        <br />
        E-mail:<asp:Label ID="Label3" runat="server" Text="Label"></asp:Label>
        <br />
    
    </div>
    </form>
    <footer><myControl:Copyright runat="server" /></footer>
</body>
</html>
