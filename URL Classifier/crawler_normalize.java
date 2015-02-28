import java.io.*;
import java.sql.*;
import java.util.Date;
import java.text.*;

public class crawler_normalize
{	 
	String day;
	int totalURL;
	crawler_normalize(String day,int totalURL) throws Exception
	{	
		this.totalURL=totalURL;
		this.day=day;
		System.out.println("Normalizing the DataSet...");
		fnc();
	}  	
	public  void fnc() throws Exception
	{
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss.S");
		String strDate=sdf.format(date);
		System.out.println("Started at : "+strDate);
		int col;
		
		col=0;
		
  		int id_value=0;
  		Writer output=null;
  		FileOutputStream fos = null;
  		int IM_num=0;
  		int k=0;
	    FileInputStream fstream = new FileInputStream("data\\"+day+".svm");
		DataInputStream in = new DataInputStream(fstream);
	  	BufferedReader br = new BufferedReader(new InputStreamReader(in));	
 	 	String strLine;
  		String strLine1;
  
 	 	while ((strLine = br.readLine()) != null)   
  		{
  			FileInputStream fstream1 = new FileInputStream("counts\\"+day+"_count.svm");
			DataInputStream in1 = new DataInputStream(fstream1);
  			BufferedReader br1 = new BufferedReader(new InputStreamReader(in1));
  			File f = new File("normalize\\"+day+"_normalize.svm");
  			f.delete();
  	
  			fos = new FileOutputStream("normalize\\"+day+"_normalize.svm",true);	
  			String IM_text="";
   		 	int  i=0;
   	 		int start=1;
    		strLine=strLine+" "; 	
    		String classes =  strLine.charAt(0)+""+strLine.charAt(1)+" ";
			fos.write(classes.getBytes());
    	
  		  	for(i=0;i<strLine.length()-1;i++)
    		{
    			if(strLine.charAt(i)==32)
    			{
    				int j=i+1;
    				IM_text="";
    				while(strLine.charAt(j)!=':' && j<strLine.length()-1)
    				{
    					IM_text=IM_text+strLine.charAt(j)+"";
    					j++;
    				}
    				IM_num = Integer.parseInt(IM_text);		
    				for(k=start;k<IM_num;k++)
    				{
    				 	strLine1 = br1.readLine();
    					if(Integer.parseInt(strLine1)>0)
    					{
    						String temp=""+k+":0 ";
    						byte[] matter1 = temp.getBytes();
    					 	fos.write(matter1);
    					}
    					 	
    				}
    			 	strLine1 = br1.readLine();
    			 	start=IM_num+1;
    					 	
    			 	j=i+1;
    				IM_text="";
    				while(strLine.charAt(j)!=32 && strLine.charAt(j)!='\0' && j<strLine.length())
    				{
    					IM_text=IM_text+strLine.charAt(j)+"";
    					j++;
    				}
    				IM_text=IM_text+" ";
    				byte[] matter=IM_text.getBytes();
    				if(Integer.parseInt(strLine1)>0)
    				fos.write(matter);
    			}	
    		}
    	
    		for(k=IM_num+1;k<3231962;k++)
    		{
    			strLine1 = br1.readLine();
    			if(Integer.parseInt(strLine1)>0)
    			{
    				String temp=""+k+":0 ";
    				byte[] matter1 = temp.getBytes();
    				fos.write(matter1);
    			}
    		}
    	
    		String newLine="\n";
   		 	fos.write(newLine.getBytes());
    		id_value++;
    		br1.close();
  		}
  		in.close();
  		features_initial fi = new features_initial(day,totalURL);
  		matrix mat = new matrix(day,totalURL);
	}  
}