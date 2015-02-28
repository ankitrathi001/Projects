import java.io.*;
import java.sql.*;

class DayToDB
{
	public static void main (String[] args) 
	{
		try
		{
			st.execute("create view url_sort as select * from url order by url_imp desc");
  			String input="";
  			
  			Connection cn1= CDatabase.getConnection();
  			Statement st1 = CDatabase.getStatement(cn1);
  			ResultSet rs = st1.executeQuery("select * from url_sort");
  			/*while(!input.equals("exit"))
  			{
  				input = System.console().readLine();
  				int i;
  				
  				for(i=0;i<input.length();i++)
  				{
  					
  				}
  					
  			}
  			*/
  			
  			FileOutputStream fos = new FileOutputStream("E:\\study\\Web Mining Project\\webMiningImproved\\project_information\\url_svmlight\\Day0_important_URLs.svm,",true);
  			
  			while(rs.next())
  			{
  				String toFile=rs.getInt("sno")+" "+rs.getFloat("url_imp");
  				toFile+="\n";
  				fos.write(toFile.getBytes());
  			}
			
  			
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
		}
	}
}