import java.io.*;
import javax.swing.*;
import java.util.*;
import java.text.*;

class FinalCrawler
{
	String day;
	FinalCrawler(String day) throws Exception
	{
		this.day=day;
		fnc();
	}
	public void fnc() throws Exception
	{	
		
		int totalURL=2000;
		int lines=0;
		String strLine;
		File f = new File("data\\"+day+".svm");
		f.delete();
		FileOutputStream fos = new FileOutputStream("data\\"+day+".svm",true);

	    FileInputStream fstream = new FileInputStream("orignal\\"+day+".svm");
		DataInputStream in = new DataInputStream(fstream);
	  	BufferedReader br = new BufferedReader(new InputStreamReader(in));
	  		
		while ((strLine = br.readLine()) != null && lines<totalURL)   
		{
		  	fos.write(strLine.getBytes());
		  	fos.write("\n".getBytes());
		  	lines++;
		}
		counter c = new counter(day,totalURL);
	}
}