<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="LoginTryIt.aspx.cs" Inherits="BankingTryIt.LoginTryIt" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <link rel="stylesheet" href="/StyleSheet1.css" />
</head>
<body>
    <p>
        <strong>Description:</strong> This is a TryIt page for a function that belongs to BankingService. The function returns a boolean value after validating the login details.
        <br />
        <strong>Operation:</strong> bool LoginVerification(string uname, string password);<br />
        <strong>Input:</strong> string UserName, string Password<br />
        <strong>Output:</strong> bool VerificationResult<br />
    </p>
    <div><a href="Main.aspx">Home</a></div>
    <form id="form1" runat="server">
    <div>
        <div>
            <div class="Label">Email ID:</div>
            <div class="TextBox"><asp:TextBox ID="TextBox1" required="required" runat="server" type="email"></asp:TextBox></div>
        </div>
        <div>
            <div class="Label">Password:</div>
            <div class="TextBox"><asp:TextBox ID="TextBox2" required="required" TextMode="password" runat="server"></asp:TextBox></div>
        </div>
        <div><asp:Button ID="Button1" CssClass="Button" runat="server" OnClick="Button1_Click" Text="Login" /></div>
        <div class="Error">
            <asp:Label ID="Label1" runat="server" Text="Label"></asp:Label>
        </div>
    </div>
    </form>
</body>
</html>
