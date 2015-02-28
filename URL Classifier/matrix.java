import java.io.*;
import java.sql.*;
import java.util.Date;
import java.text.*;

class matrix
{
	String day;
	int totalURL;
	matrix(String day, int totalURL) throws Exception
	{
		this.totalURL=totalURL;
		this.day=day;
		System.out.println("Creating Matrix from the Normalized Data...");
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
	
    	FileInputStream fstream = new FileInputStream("normalize\\"+day+"_normalize.svm");
		DataInputStream in = new DataInputStream(fstream);
  		BufferedReader br = new BufferedReader(new InputStreamReader(in));
  		File f = new File("matrix\\"+day+"_matrix.svm");
 		f.delete();
  		FileOutputStream fos = new FileOutputStream("matrix\\"+day+"_matrix.svm",true);
  		 	
  		String strLine;
  		String strLine1;
  		int space=0;
 	 	while ((strLine = br.readLine()) != null)   
  		{		 
  					
  			String IM_text="";
    		int  i=0;
    		int start=1;
    		strLine=strLine+" ";
    		space=0;
    	
    		String classes =  strLine.charAt(0)+""+strLine.charAt(1)+" ";
			fos.write(classes.getBytes());
			
   		 	for(i=0;i<strLine.length()-1;i++)
   		 	{
   		 		if(strLine.charAt(i)==':' )
    			{
    				int j=i+1;
    				IM_text="";
    				space++;
    				while(strLine.charAt(j)!=32&& j<strLine.length()-1)
    				{
    					IM_text=IM_text+strLine.charAt(j)+"";
    					j++;
    				}
    				fos.write((IM_text+" ").getBytes());
    			}
    		}	
    		String newLine="\n";   	
	    	fos.write(";".getBytes());
   		 	fos.write(newLine.getBytes());
   		 	id_value++;
   	 		
  		}
  		System.out.println("Total Features : after removing those that are not present in any URL : "+ space);	
  		in.close();
  		mTOa ma = new mTOa(day,space,totalURL);
   	 }
}