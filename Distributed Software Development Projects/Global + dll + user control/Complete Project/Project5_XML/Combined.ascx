<%@ Control Language="C#" AutoEventWireup="true" CodeBehind="Combined.ascx.cs" Inherits="Project5_XML.Combined" %>
<%@ Register TagPrefix="myControl" TagName="Greeting" Src="~/Greetings.ascx" %>
<%@ Register TagPrefix="myControl" TagName="Header" Src="~/HeaderControl.ascx" %>
<%@ Register TagPrefix="myControl" TagName="Weather" Src="~/WeatherUpdateControl.ascx" %>
<p>
    
<p>
    <strong>Project 5 - TITAN</strong>
    <div style="float:right;"><myControl:Weather runat="server" /></div>
    <br />
    <myControl:Header runat="server" /><br /><br />
    <myControl:Greeting runat="server" /><br />
    </p>
