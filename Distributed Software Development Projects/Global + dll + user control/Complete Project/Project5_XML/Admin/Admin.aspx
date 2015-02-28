<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Admin.aspx.cs" Inherits="Project5_XML.Admin.Admin" %>
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
    
        This is the Admin page. This page is only accessible to the users with role = &quot;Admin&quot;.<br />
        <a href="AdminRegister.aspx">Register a new user</a></div>
        <footer><myControl:Copyright runat="server" /></footer>
    </form>
    
</body>
</html>
