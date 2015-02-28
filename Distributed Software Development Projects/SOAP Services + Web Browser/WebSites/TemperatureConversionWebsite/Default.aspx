<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Default.aspx.cs" Inherits="_Default" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <meta charset="UTF-8">
    <title>Temperature Conversion Website</title>
    <link rel="stylesheet" type="text/css" href="StyleSheet.css">
    <link href="favicon.ico" rel="icon" type="image/x-icon" />
    <style type="text/css">
        .auto-style1 {
            width: 70px;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
    <div style="font-family:Arial">
        <table>
            <tr><td colspan="4" style="padding-left:100px">Temperature Converter</td></tr>
            <tr>
                <td class="auto-style1"><asp:TextBox type="number" ID="TextBox1" runat="server" OnTextChanged="TextBox1_TextChanged" CssClass="input"></asp:TextBox></td>
                <td class="lowPadding">°F</td>
                <td><asp:Button ID="Button1" runat="server" Text="Convert to" OnClick="Button1_Click1" CssClass="button" /></td>
                <td><asp:Label ID="Label1" runat="server" Text="°C"></asp:Label></td>
            </tr>
            <tr>
                <td class="auto-style1">
                    <asp:TextBox ID="TextBox2" type="number" runat="server" OnTextChanged="TextBox2_TextChanged" CssClass="input"></asp:TextBox>
                </td>
                <td class="lowPadding">°C</td>
                <td><asp:Button ID="Button2" runat="server" Text="Convert to" OnClick="Button2_Click" CssClass="button" /></td>
                <td><asp:Label ID="Label2" runat="server" Text="°F"></asp:Label></td>
            </tr>
        </table>
    </div>
    </form>
</body>
</html>
