import java.io.*;
import java.sql.*;
import java.util.Date;
import java.text.*;

class imporantce_matrix
{
	String day;
	int totalURL;
	imporantce_matrix(String day, int totalURL) throws Exception
	{
		this.totalURL=totalURL;
		this.day=day;
		System.out.print("Making the Importance Matrix...");
		fcn();
	}
	public void fcn() throws Exception 
	{
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss.S");
		String strDate=sdf.format(date);
		System.out.println("Started at : "+strDate);
		FileInputStream fstream = new FileInputStream("matrix\\"+day+"_matrix.svm");
		DataInputStream in = new DataInputStream(fstream);
	  	BufferedReader br = new BufferedReader(new InputStreamReader(in));
	  	FileOutputStream fos=null;  	
  	  	File f = new File("importance matrix\\"+day+"_importance_matrix.svm");
  		f.delete();
  	
  		fos = new FileOutputStream("importance matrix\\"+day+"_importance_matrix.svm",true);
			
		FileOutputStream fos1=null;  	
  	  	File f1 = new File("importance value\\"+day+"_importance_value.svm");
  		f1.delete();
  	
  		fos1 = new FileOutputStream("importance value\\"+day+"_importance_value.svm",true);
			
	  	String strline = "";
	  	while((strline = br.readLine())!=null)	
	  	{
	  		float ans=0;
	  		String save="";
	  		int col=0;
	  			
	  		FileInputStream fstream1 = new FileInputStream("top features\\"+day+"_information_sort.svm");
			DataInputStream in1 = new DataInputStream(fstream1);
	  		BufferedReader br1 = new BufferedReader(new InputStreamReader(in1));  		
	  			
	  		String strline1=br1.readLine();
	  		int a=0;
	  		float b=0;
	  		int i=0;
	  		int j;
	  		String tempa="";
	  		String tempb="";
	  		for(j=0;j<strline1.length();j++)
	  		{
	  			tempa="";
	 			tempb="";
	  				
	 			while(strline1.charAt(j)!=32)
	  			{
	  				tempa+=strline1.charAt(j);
	  				j++;
	  			}
	  			j++;
	  			a=Integer.parseInt(tempa);
	  			while(j<strline1.length())
	  			{
	  				tempb+=strline1.charAt(j);
	  				j++;
	  			}
	  			b=Float.parseFloat(tempb);
	  			if(a==0)
	  				a++;
	  		}
	  		for(i=0;i<strline.length();i++)
	  		{
	  			if(strline.charAt(i)==32)
	  			{
	  				col++;
	  						
	  				if(col==a)
	  				{
	  					String temp = "";
	  					i++;
	  					while(strline.charAt(i)!=32)
	  					{
	  						temp+=strline.charAt(i);
	  						i++;
	  					}
	  					i--;
	  					float temp0=b*Float.parseFloat(temp);
	  					ans+=temp0;
	  					String t0=""+temp0+" ";
	  					fos.write(t0.getBytes());
	  					strline1=br1.readLine();
	  					
	  					if(strline1==null)
	 						break;
	  					for(j=0;j<strline1.length();j++)
	  					{
		  					tempa="";
	  						tempb="";
	  			
	  						while(strline1.charAt(j)!=32)
	  						{
	  							tempa+=strline1.charAt(j);
	  							j++;
	  						}
	  						j++;
	  						a=Integer.parseInt(tempa);
				  			while(j<strline1.length())
	  						{
	  							tempb+=strline1.charAt(j);
	  							j++;
	  						}
	  						b=Float.parseFloat(tempb);
	  					}
	  				}
	  			}
	  				
	  		}
	  		fos.write("\n".getBytes());
	  		fos1.write((""+ans+"\n").getBytes());
	  	}	
	  	in.close();	
	  	urltodatabase utb=new urltodatabase(day,totalURL);
	}
}