<%@ Control Language="C#" AutoEventWireup="true" CodeBehind="HeaderControl.ascx.cs" Inherits="Project5_XML.HeaderControl" %>
    <a href="/">Home Page</a>&nbsp;&nbsp;&nbsp; <a href="/Admin/Admin.aspx">Admin Page</a>&nbsp;&nbsp;&nbsp; <a href="/Manager/Manager.aspx">Manager Page</a>&nbsp;&nbsp;&nbsp; <a href="/Staff/Staff.aspx">Staff Page</a>&nbsp;&nbsp;&nbsp; <a href="/Member/Member.aspx">Member Page</a>&nbsp;&nbsp;&nbsp; 
<%if(Session["uname"]!=null){ %><a href="/Logout.aspx">Logout</a>
<%} else{ %><a href="/Login.aspx">Login</a><% } %>
<br />