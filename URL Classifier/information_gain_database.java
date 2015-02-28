import java.io.*;
import java.sql.*;
import java.util.Date;
import java.text.*;

class information_gain_database
{
	String day;
	int totalURL;
	information_gain_database(String day, int totalURL) throws Exception
	{
		this.totalURL=totalURL;
		this.day=day;
		System.out.println("Putting IG values in database and sorting...");
		fnc();
	}
	public void fnc() throws Exception 
	{
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss.S");
		String strDate=sdf.format(date);
		System.out.println("Started at : "+strDate);
		int retrieve=200;
		int i=0;
		FileInputStream fstream = new FileInputStream("information gain\\"+day+"_information_gain.svm");
		DataInputStream in = new DataInputStream(fstream);
  		BufferedReader br = new BufferedReader(new InputStreamReader(in));
  		String strLine;
  		FileOutputStream fos=null;  	
  		File f = new File("top features\\"+day+"_information_sort.svm");
  		f.delete();
  	
  		fos = new FileOutputStream("top features\\"+day+"_information_sort.svm",true);
		
		Connection cn = CDatabase.getConnection();
		Statement st = CDatabase.getStatement(cn);
			
		Connection cn1 = CDatabase.getConnection();
		Statement st1 = CDatabase.getStatement(cn1);
			
		Connection cn3 = CDatabase.getConnection();
		Statement st3 = CDatabase.getStatement(cn3);
			
		st.execute("delete from info_gain");
		st.execute("delete from topfeature");
		  	
		while ((strLine = br.readLine()) != null)   
		{	
			String str = "insert into info_gain values ("+i+",'"+Float.parseFloat(strLine)+"')";
		  	st.executeUpdate(str);
		  	i++;
		}
		String strGet= "select * from info_gain order by gain desc";
		ResultSet rs = st1.executeQuery(strGet);
		  	
		int num = 0;
		while(rs.next()&& num<retrieve)
		{
			String str_temp = "insert into topfeature values("+rs.getInt("sno")+","+rs.getFloat("gain")+")";
			st3.executeUpdate(str_temp);
			num++;
		}
		rs.close();
		strGet= "select * from topfeature order by sno";
		ResultSet rs1 = st1.executeQuery(strGet);
		while(rs1.next())
	  	{
	  		String out1 = rs1.getInt("sno")+" "+rs1.getFloat("gain")+"\n";
	 		fos.write(out1.getBytes());
	  	}
	  	in.close();
	  	imporantce_matrix im = new imporantce_matrix(day,totalURL);
	}	
}