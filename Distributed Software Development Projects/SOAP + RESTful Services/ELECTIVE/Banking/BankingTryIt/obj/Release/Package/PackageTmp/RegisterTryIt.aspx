<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="RegisterTryIt.aspx.cs" Inherits="BankingTryIt.RegisterTryIt" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <link rel="stylesheet" href="/StyleSheet1.css" />
    <title></title>
</head>
<body>
    <p>
            <strong>Description:</strong> This is a TryIt page for a function that belongs to BankingService. The function returns generates a credit card and returns the card details.<br />
            <strong>Operation:</strong> string[] Registration(string FirstName, string LastName, string Email, string Password, string Amount);<br />
            <strong>Input:</strong> string FirstName, string LastName, string Email, string Password, string Amount<br />
            <strong>Output:</strong> string[] CardDetails<br />
    </p>
    <div><a href="Main.aspx">Home</a></div>
    <form id="form1" runat="server">
    <div>
        <div class="Error"><asp:Label ID="Label1" runat="server" Text="Label"></asp:Label></div>
        <div>
            <div class="Label">First Name:</div>
            <div class="TextBox"><asp:TextBox ID="TextBox1" required="required" runat="server"></asp:TextBox></div>
            <div class="Label">Last Name:</div>
            <div class="TextBox"><asp:TextBox ID="TextBox2" required="required" runat="server"></asp:TextBox></div>
        </div>
        <div>
            <div class="Label">E-mail Id:</div>
            <div class="TextBox"><asp:TextBox ID="TextBox3" Columns="50" required="required" runat="server" type="email"></asp:TextBox></div>
        </div>
        <div>
            <div class="Label">Password:</div>
            <div class="TextBox"><asp:TextBox ID="TextBox4" required="required" TextMode="password" runat="server"></asp:TextBox></div>
            <div class="Label">Confirm Password:</div>
            <div class="TextBox"><asp:TextBox ID="TextBox5" required="required" TextMode="password" runat="server"></asp:TextBox></div>
        </div>
        <div>
            <div class="Label">Initial Amount:</div>
            <div class="TextBox"><asp:TextBox ID="TextBox6" required="required" runat="server"></asp:TextBox></div>
        </div>
        <div><asp:Button ID="Button1" CssClass="Button" runat="server" OnClick="Button1_Click" Text="Register" /></div>
        <div style="padding:5px;"><asp:Label ID="Label2" runat="server" Text="Label"></asp:Label></div>
        </div>
    </form>
</body>
</html>
