import java.io.*;
import java.sql.*;
import java.util.Date;
import java.text.*;

class urltodatabase
{
	String day;
	int totalURL;
	urltodatabase(String day, int totalURL) throws Exception 
	{
		System.out.println("Final Step...");
		this.totalURL=totalURL;
		this.day=day;
		fnc();
	}
	public void fnc() throws Exception
	{
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss.S");
		String strDate=sdf.format(date);
		System.out.println("Started at : "+strDate);
			int i=1;
			FileInputStream fstream = new FileInputStream("importance value\\"+day+"_importance_value.svm");
			DataInputStream in = new DataInputStream(fstream);
  			BufferedReader br = new BufferedReader(new InputStreamReader(in));
  			
  			 		  	
  		  	String strLine;
  			Connection cn = CDatabase.getConnection();
			Statement st = CDatabase.getStatement(cn);
			st.execute("delete from url");				  	
		  	while ((strLine = br.readLine()) != null)   
		  	{
		  		
		  		String str = "insert into url values ("+i+",'"+Float.parseFloat(strLine)+"')";
		  		st.executeUpdate(str);
		  		i++;
		  	}
		  	
		  	st.execute("drop view url_sort");
		  	st.execute("create view url_sort as select * from url order by url_imp desc");
  			String input="";
  			
  			Connection cn1= CDatabase.getConnection();
  			Statement st1 = CDatabase.getStatement(cn1);
  			ResultSet rs = st1.executeQuery("select * from url_sort");
  			File f =new File("important url\\"+day+"_important_URLs.svm");
  			f.delete();
  			FileOutputStream fos = new FileOutputStream("important url\\"+day+"_important_URLs.svm",true);
  			
  			while(rs.next())
  			{
  				String toFile="URL ID : "+rs.getInt("sno")+" IMP : "+rs.getFloat("url_imp");
  				toFile+="\n";
  				fos.write(toFile.getBytes());
  			}
  			
		  	in.close();
		  		Date date1=new Date();
		SimpleDateFormat sdf1=new SimpleDateFormat("hh:mm:ss.S");
		String strDate1=sdf1.format(date1);
		System.out.print("\tFinished at :"+strDate1+"\n");
		}		
}