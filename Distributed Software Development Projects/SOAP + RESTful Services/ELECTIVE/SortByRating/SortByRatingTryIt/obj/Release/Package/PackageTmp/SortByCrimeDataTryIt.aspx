<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="SortByCrimeDataTryIt.aspx.cs" Inherits="SortByRatingTryIt.TryIt" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>TryIt Page for Sorting Cities by Crime Data
</title><link rel="stylesheet" href="Content/StyleSheet1.css" /><meta name="viewport" content="width=device-width" />
</head>
<body>
    <form id="form1" runat="server">
    <div>
    
        <strong>Description</strong>: This service is used for sorting the list of cities according to the Crime Rate. It uses another service to get the crime rate for a particular city.<br />
        <strong>WSDL URL</strong>:<br />
        <strong>Operation</strong>: sortCitiesByCrimeRate<br />
        <strong>Input</strong>: string cities<br />
        <strong>Output</strong>: string[] SortedListOfCities
        <br />
        Enter the list of cities separated by comma (,):&nbsp; <asp:TextBox ID="TextBox1" required="required" runat="server" Width="476px"></asp:TextBox>
        <asp:Button ID="Button1" runat="server" OnClick="Button1_Click" Text="Sort By Crime Rate" Width="125px" />
    
    </div>
        <p>
            <asp:Label ID="Label1" runat="server" Text="Label"></asp:Label>
        </p>
    </form>
</body>
</html>
