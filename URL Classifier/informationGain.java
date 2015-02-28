import java.io.*;
import java.math.*;
import java.util.Date;
import java.text.*;

class informationGain
{
	String day;
	int totalURL;
	informationGain(String day, int totalURL) throws Exception
	{
		this.totalURL=totalURL;
		this.day=day;
		System.out.println("Calculating the Information Gain Values...");
		fnc();
	}
	public void fnc() throws Exception 
	{
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss.S");
		String strDate=sdf.format(date);
		System.out.println("Started at : "+strDate);
		int totalLines=totalURL;
		int[] a,b ;
		int i,j,k;
		a = new int[totalLines];
		b = new int[totalLines];
			
		FileInputStream fstream = new FileInputStream("feature count\\"+day+"_feature_count.svm");
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		  	
		FileInputStream fstream1 = new FileInputStream("entropy dataset\\"+day+"_entropy_dataset.svm");
		DataInputStream in1 = new DataInputStream(fstream1);
		BufferedReader br1 = new BufferedReader(new InputStreamReader(in1));
		  	
		br1.readLine();
		br1.readLine();
		String te = br1.readLine();
		float entropy_data = Float.parseFloat(te);
		  	
		String strLine="";
		  	
		File f = new File("information gain\\"+day+"_information_gain.svm");
  		f.delete();
  		FileOutputStream fos = new FileOutputStream("information gain\\"+day+"_information_gain.svm",true);
		  	
		i=j=k=0;
		float inter = 0;
		while ((strLine = br.readLine()) != null)   
		{
			if(strLine.charAt(0)!='*')
		  	{
		  		i=j=k=0;
		  		for(i=0;i<strLine.length();i++)
		  		{
		  			String temp ="";
		  			while(strLine.charAt(i)!=':'&& i<strLine.length())
		  			{
						temp = temp+strLine.charAt(i);
						i++;		  					
		  			}
		  			a[j]=Integer.parseInt(temp);
		  			temp="";
		  				
		  			i++;
		  				
		  			while(i<strLine.length())
		  			{
						temp = temp+strLine.charAt(i);
						i++;		  					
		  			}
		  			b[j]=Integer.parseInt(temp);
		  			
		  			float temp1 =  a[j]+b[j];
		  			float temp2 = (float)a[j]/temp1;
		  			float temp3 = (float)b[j]/temp1;
		  			float  temp4 =(float)temp2*(float)((float)Math.log(temp2)/Math.log(2));
		  			float  temp5 =(float)temp3*(float)((float)Math.log(temp3)/Math.log(2));
		  			float asd=0;
		  				
		  			if(a[j]==0)
		  			{
		  				asd=temp5;
		  			}
		  			else if(b[j]==0)
		  			{
		  				asd = temp4;
		  			}
		  			else
		  			{
		  				asd = temp4+temp5;
		  			}
		  			inter+= (((float )temp1/totalLines)*(asd));
		  			j++;
		  		}		
		  	}
		  	else
		  	{
		  		fos.write( (""+((entropy_data)-(-1*inter))+" \n").getBytes() );
		  		inter = 0;
		  	}
		  		
		}
		in.close();
		information_gain_database igd = new information_gain_database(day,totalURL);
	}
}