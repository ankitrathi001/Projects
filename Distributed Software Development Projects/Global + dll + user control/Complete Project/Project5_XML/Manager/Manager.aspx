<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Manager.aspx.cs" Inherits="Project5_XML.Manager" %>
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
        <b>This is a Manager Page</b><br /><br />
        <b>My Profile:</b><br />
        Name: <asp:Label ID="Label1" runat="server" Text="Label"></asp:Label>
        <br />
        Username: <asp:Label ID="Label2" runat="server" Text="Label"></asp:Label>
        <br />
        Email: <asp:Label ID="Label3" runat="server" Text="Label"></asp:Label>
        <br />
        <br />
        <asp:DropDownList ID="DropDownList1" runat="server">
        </asp:DropDownList>
        <asp:Button ID="Button2" runat="server" OnClick="Button2_Click" Text="View Profile" />
    
        <br />
        <br />
        <asp:Label ID="Label4" runat="server" Text="Label"></asp:Label>
        <br />
        <asp:Label ID="Label5" runat="server" Text="Label"></asp:Label>
        <br />
        <asp:Label ID="Label6" runat="server" Text="Label"></asp:Label>
    
    </div>
    </form>
    <footer><myControl:Copyright runat="server" /></footer>
</body>
</html>
