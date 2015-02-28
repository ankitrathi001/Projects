import java.io.*;
import java.sql.*;
import java.util.Date;
import java.text.*;

class features_initial
{
	String day;
	int totalURL;
	features_initial(String day, int totalURL) throws Exception
	{
		this.totalURL=totalURL;
		this.day=day;
		System.out.println("Taking Feature Numbers out...");
		fnc();
	}
 	public void fnc() throws Exception
 	{
 		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss.S");
		String strDate=sdf.format(date);
		System.out.println("Started at : "+strDate);
  		int col;
  		
  		int id_value=0;
  		Writer output=null;
 
    	FileInputStream fstream = new FileInputStream("normalize\\"+day+"_normalize.svm");
		DataInputStream in = new DataInputStream(fstream);
  		BufferedReader br = new BufferedReader(new InputStreamReader(in));
  		File f = new File("features\\"+day+"_features.svm");
  		f.delete();
  		FileOutputStream fos = new FileOutputStream("features\\"+day+"_features.svm",true);
  			
  		String strLine;
  		String strLine1;
  
	  	if((strLine = br.readLine()) != null)   
  		{		 		
  			String IM_text="";
   		 	int  i=0;
   		 	int start=1;
    		strLine=strLine+" ";
    		for(i=0;i<strLine.length()-1;i++)
    		{		
   		 		if(strLine.charAt(i)==32 )
    			{
    				int j=i+1;
    				IM_text="";
    				while(strLine.charAt(j)!=':' && j<strLine.length()-1)
    				{
    					IM_text=IM_text+strLine.charAt(j)+"";
    					j++;
    				}
    				fos.write((IM_text+" ").getBytes());
    			}	
    		}
    		String newLine="\n";
    		fos.write(newLine.getBytes());
    		id_value++;	
  		}
  		in.close();
   	 }
}