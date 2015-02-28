import java.io.*;
import java.math.*;
import java.util.Date;
import java.text.*;

class entropy_dataset
{
	String day;
	int totalURL;
	entropy_dataset(String day, int totalURL) throws Exception
	{
		this.totalURL=totalURL;
		this.day=day;
		System.out.println("Calculating Entropy of DataSet...");
		fnc();	
	}
	public void fnc() throws Exception 
	{
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss.S");
		String strDate=sdf.format(date);
		System.out.println("Started at : "+strDate);
		FileInputStream fstream = new FileInputStream("matrix\\"+day+"_matrix.svm");
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		File f = new File("entropy dataset\\"+day+"_entropy_dataset.svm");
		f.delete();
		FileOutputStream fos = new FileOutputStream("entropy dataset\\"+day+"_entropy_dataset.svm",true);
			  	
		String strLine;
  		int pos=0 , neg =0, lines = 0;
  
  		while ((strLine = br.readLine()) != null)   
  		{
  			if(strLine.charAt(0)=='+')
  			{
  				pos++;
  			}
  			else if(strLine.charAt(0)=='-')
  			{
  				neg++;
  			}
  			lines++;	
  		}
  				
  		float p_pos = (float) pos/lines;
  		float p_neg = (float) neg/lines;
  		double entropy_pos = -1*p_pos*Math.log(p_pos)/Math.log(2);
  		double entropy_neg = -1*p_neg*Math.log(p_neg)/Math.log(2);
  		//System.out.println(entropy_pos);
  		System.out.println("Entropy of Dataset : "+(entropy_neg+entropy_pos));
  				
  		String temp = entropy_pos+"\n"+entropy_neg+"\n"+(entropy_neg+entropy_pos);
  		fos.write(temp.getBytes());  
  		in.close();	
  		informationGain ig = new informationGain(day,totalURL);
	}	
}