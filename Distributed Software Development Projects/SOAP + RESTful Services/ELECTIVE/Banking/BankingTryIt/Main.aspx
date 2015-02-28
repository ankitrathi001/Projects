<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Main.aspx.cs" Inherits="BankingTryIt.Main" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <link rel="stylesheet" href="/StyleSheet1.css" />
</head>
<body>
    <p>
        <strong>Description:</strong> This is a TryIt page for BankingService. It contains 4 functions as follows:
    </p>
    <p>
        <br />
        <strong>Operation:</strong> bool LoginVerification(string uname, string password);<br />
        <strong>Input:</strong> string UserName, string Password<br />
        <strong>Output:</strong> bool VerificationResult</p>
    <p>
            <strong>Operation:</strong> string[] getTransactionHistory(string UserName)<br />
            <strong>Input:</strong> string UserName<br />
            <strong>Output:</strong> string[] TransactionHistory</p>
    <p>
            <strong>Operation:</strong> string processTransaction(string UserName, string CardNumber, string CVV, string ExpMonth, string ExpYear, string Amount);<br />
            <strong>Input:</strong> string UserName, string CardNumber, string CVV, string ExpMonth, string ExpYear, string Amount<br />
            <strong>Output:</strong> string success/error_Message</p>
    <p>
            <strong>Operation:</strong> string[] Registration(string FirstName, string LastName, string Email, string Password, string Amount);<br />
            <strong>Input:</strong> string FirstName, string LastName, string Email, string Password, string Amount<br />
            <strong>Output:</strong> string[] CardDetails</p>
    <form id="form1" runat="server">
    <div>
        <asp:Button ID="Button1" CssClass="Button" runat="server" OnClick="Button1_Click" Text="Login" />
        <asp:Button ID="Button2" CssClass="Button" runat="server" OnClick="Button2_Click" Text="Register" />
    </div>
    </form>
</body>
</html>
