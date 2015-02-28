<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="ProcessTransactionTryIt.aspx.cs" Inherits="BankingTryIt.ProcessTransactionTryIt" %>

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
            <div class="success">
            <strong>Description:</strong> This is a TryIt page for a function that belongs to BankingService. The function returns the success/error string for a transaction. This TryIt page is using the session variable (username) to call the function.<br />
            <strong>Operation:</strong> string processTransaction(string UserName, string CardNumber, string CVV, string ExpMonth, string ExpYear, string Amount);<br />
            <strong>Input:</strong> string UserName, string CardNumber, string CVV, string ExpMonth, string ExpYear, string Amount<br />
            <strong>Output:</strong> string success/error_Message<br />
                <br />
                <asp:Label ID="Label1" runat="server" Text="Label"></asp:Label>- Successfully Logged In!</div>
            <div><a href="Logout.aspx">Sign Out</a></div>
        </div>
        <div>
            <div class="Label">Card Number:</div>
            <div class="TextBox"><asp:TextBox ID="TextBox1" required="required" runat="server"></asp:TextBox></div>
        </div>
        <div>
            <div class="Label">CVV:</div>
            <div class="TextBox"><asp:TextBox ID="TextBox2" required="required" TextMode="password" runat="server"></asp:TextBox></div>
        </div>
        <div>
            <div class="Label">Expiry (Month):</div>
            <div class="TextBox"><asp:TextBox ID="TextBox3" required="required" runat="server" type="number" min="1" max="12"></asp:TextBox></div>
        </div>
        <div>
            <div class="Label">Expiry (Year):</div>
            <div class="TextBox"><asp:TextBox ID="TextBox4" required="required" runat="server" type="number" min="2014"></asp:TextBox></div>
        </div>
        <div>
            <div class="Label">Amount:</div>
            <div class="TextBox"><asp:TextBox ID="TextBox5" required="required" runat="server"></asp:TextBox></div>
        </div>
        <div><asp:Button ID="Button1" CssClass="Button" runat="server" OnClick="Button1_Click" Text="Submit" /></div>
        
        <div style="padding:5px"><asp:Label ID="Label2" runat="server" Text="Label"></asp:Label></div>
  
        <div>Click <a href="getTransactionHistoryTryIt.aspx">HERE</a> to get complete transaction history</div>
    
    </div>
    </form>
</body>
</html>
