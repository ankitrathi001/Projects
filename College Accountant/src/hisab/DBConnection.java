package hisab;
/**
 *
 * @author Anshul
 */
import java.sql.Connection;
import java.sql.DriverManager;
	
public class DBConnection {

	static Connection con=null;
	public static Connection getConnection()
	{				
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://172.22.29.123:3306/Hisab","root","anshulDB");
		}
		catch(Exception ex)
		{
			System.out.println("no Connection");
		}
		
		return con;
	}
	
}
