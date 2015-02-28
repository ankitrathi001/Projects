<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:tns="http://www.public.asu.edu/~ajain89/DSOD_Assignment4/Hotels.xml">
	<xsl:template match="/">
		<html>
		<head>
		<link rel="stylesheet" href="Style.css" />
		<meta name="viewport" content="width=device-width" /></head>
		<body>
		<h1>List Of Hotels</h1>
		<table border="1" align="center"  class="stylishTable">
			<tr>
				<th colspan="2">Hotel</th>
				<th colspan="5">Address</th>
				<th colspan="2">Contact Information</th>
			</tr>
			<tr>
				<th>Hotel Name</th>
				<th>Star</th>
				<th>Number</th>
				<th>Street</th>
				<th>City</th>
				<th>Zip</th>
				<th>Bus Lines</th>
				<th>Phone Number</th>
				<th>Email</th>
			</tr>
        <xsl:for-each select="Hotels/Hotel">
			<tr>
				<td><xsl:value-of select="Name" /></td>
				<td class="star"><xsl:value-of select="@Stars" /></td>
                <td><xsl:value-of select="Address/Number" /></td>
                <td><xsl:value-of select="Address/Street" /></td>
                <td><xsl:value-of select="Address/City" /></td>
                <td><xsl:value-of select="Address/Zip" /></td>
                <td>
                <xsl:if test="Address/@BusLines">
                Bus Lines: <xsl:value-of select="Address/@BusLines" /><br />
                </xsl:if>
                </td>
                <td><xsl:value-of select="Contact/Phone" /></td>
                <td><xsl:value-of select="Contact/Email" /></td>
			</tr>
        </xsl:for-each>
		</table>
		</body>
		</html>
	</xsl:template>
</xsl:stylesheet>