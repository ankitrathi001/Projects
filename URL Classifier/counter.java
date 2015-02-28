import java.io.*;
import java.util.Date;
import java.text.*;

class counter
{
	String day;
	int totalURL;
	counter(String day, int totalURL) throws Exception
	{
		this.totalURL=totalURL;
		this.day=day;
		System.out.println("In Counter...");
		fnc();
	}
	public void fnc() throws Exception
	{	
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss.S");
		String strDate=sdf.format(date);
		System.out.println("Started at : "+strDate);
		int num;
		int j;
		int count[];
		count = new int [3232000];
		String sample="";
		
		String strLine;
		File f = new File("counts\\"+day+"_count.svm");
		f.delete();
	 	FileOutputStream fos = new FileOutputStream("counts\\"+day+"_count.svm",true);

	   	FileInputStream fstream = new FileInputStream("data\\"+day+".svm");
		DataInputStream in = new DataInputStream(fstream);
	  	BufferedReader br = new BufferedReader(new InputStreamReader(in));
	  		
		while ((strLine = br.readLine()) != null)   
		{
		  	int i;
		  	for(i=0;i<strLine.length();i++)
		    {
		    	if (strLine.charAt(i)==32)
		    	{
		    		j= i+1;
		    		sample ="";
		    		while(strLine.charAt(j)!=':')
		    		{
		    			sample=sample+strLine.charAt(j);
		    			j++;
		    		}				
		    		count[Integer.parseInt(sample)]++;
		    	}
		    }
		    		
		}
		for(num=1;num<3232000;num++)
		{
			String field = ""+num;
	    	String counter = ""+count[num];
	    	fos.write(counter.getBytes());
	    	fos.write("\n".getBytes());
		}
		br.close();
	    in.close();
	  	fstream.close();
	  	crawler_normalize cn = new crawler_normalize(day,totalURL);
		Date date1=new Date();
		SimpleDateFormat sdf1=new SimpleDateFormat("hh:mm:ss.S");
		String strDate1=sdf1.format(date1);
		System.out.print("\tFinished at :"+strDate1+"\n");
	} 	
	
}