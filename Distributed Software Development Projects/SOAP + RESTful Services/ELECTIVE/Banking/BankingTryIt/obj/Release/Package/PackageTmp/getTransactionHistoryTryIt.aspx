<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="getTransactionHistoryTryIt.aspx.cs" Inherits="BankingTryIt.getTransactionHistoryTryIt" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <link rel="stylesheet" href="/StyleSheet1.css" />
</head>
<body>
    <form id="form1" runat="server">
    <div>
    
        <div>
            <strong>Description:</strong> This is a TryIt page for a function that belongs to BankingService. The function returns the transaction history for a particular user. This TryIt page is using the session variable (username) to call the function.<br />
            <strong>Operation:</strong> string[] getTransactionHistory(string UserName)<br />
            <strong>Input:</strong> string UserName<br />
            <strong>Output:</strong> string[] TransactionHistory<br />
            <asp:Button ID="Button2" CssClass="Button" runat="server" OnClick="Button2_Click" Text="Back" />
            <asp:Button ID="Button1" CssClass="Button" runat="server" OnClick="Button1_Click" Text="Get Transaction History" /></div>
        
        <div style="padding:5px;"><asp:Label ID="Label1" runat="server" Text="Label"></asp:Label></div>
    
    </div>
    </form>
</body>
</html>
