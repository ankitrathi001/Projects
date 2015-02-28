import java.io.*;
import java.util.Date;
import java.text.*;

class mTOa
{
	String day;
	int space;
	int totalURL;
	mTOa(String day, int space, int totalURL) throws Exception
	{
		this.totalURL=totalURL;
		this.space=space;
		this.day=day;
		System.out.println("Finding Distinct Value of the features and getting their count...");
		fnc();
	}
	public void fnc() throws Exception 
	{
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss.S");
		String strDate=sdf.format(date);
		System.out.println("Started at : "+strDate);
		int rows=totalURL+1;
		int cols=space+1;
		int row=0;
		int col=0;
		int k=0;
		float[][] a ;
		a=new float[rows][cols];
		int neg=1;
		int pos=1;	
		
		FileInputStream fstream = new FileInputStream("matrix\\"+day+"_matrix.svm");
		DataInputStream in = new DataInputStream(fstream);
	  	BufferedReader br = new BufferedReader(new InputStreamReader(in));
	  	String strLine;
	  	int i=0,j=0;
	  	
	  	while ((strLine = br.readLine()) != null)   
  		{
  			col=0;
  			a[row][col]=Float.parseFloat((strLine.charAt(0)+""+strLine.charAt(1)));
  			col++;
  			
  			for(i=2;i<strLine.length();i++)
  			{
  				String temp="";
  				if(strLine.charAt(i)==32)
  				{
  					j=i+1;
  					while(strLine.charAt(j)!=32 && j < strLine.length()-1)
  					{	
  						temp = temp + strLine.charAt(j);
  						j++;
  					}
  					if(temp.length()>0)
  					{
  						if(Float.parseFloat(temp)>0)
						a[row][col]=Float.parseFloat(temp);
						col++;
  					}	
  				}
  			}
  			row++;	
  		}
  		File f =  new File("feature count\\"+day+"_feature_count.svm");
  		f.delete();
  		FileOutputStream fos = new FileOutputStream("feature count\\"+day+"_feature_count.svm",true);
  		
  		for(j=1;j<col;j++)
  		{
  			for(i=0;i<row;i++)
  			{
  				pos=0;
  				neg=0;
  				if(a[i][j]!=-1)
  				{
  					if(a[i][0]>0)
  						pos++;
  					else
  						neg++;
  							
  					for(k=i+1;k<rows;k++)
  					{
  						if(a[i][j]== a[k][j] && a[i][j]!=-1)
  						{
  							if(a[k][0]<0)
  							{
  								neg++;
  							}
  							else
  							{
  								pos++;
  							}
  							a[k][j]=-1;
  						}		
  					}
  					fos.write((""+pos+":"+neg+"\n").getBytes());
  				}
  				
  			}
  			fos.write("***************************************************************\n".getBytes());	
  		}
  		in.close();
  		entropy_dataset ed = new entropy_dataset(day,totalURL);
	}
	
}