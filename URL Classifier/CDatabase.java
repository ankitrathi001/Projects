import java.sql.*;

class CDatabase 
{
	static Connection getConnection()
	{
		Connection cn=null ;
		 
		 try
		 {
		 	Class.forName("com.mysql.jdbc.Driver");
		 	
		 	cn = DriverManager.getConnection("jdbc:mysql:///crawler","root","");
		 	
		 }
		 catch(SQLException exp)
		 {
		 	exp.printStackTrace();
		 }
		 catch(ClassNotFoundException exp)
		 {
		 	exp.printStackTrace();
		 }
		 
		 return cn;
	}
	
	static Statement getStatement(Connection cn)
	{
		Statement st = null;
		try
		{
			st = cn.createStatement();
		}
		catch(SQLException exp)
		{
			exp.printStackTrace();
		}
		return st;
	}
}