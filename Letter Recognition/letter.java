import java.io.*;

class letter
{
public static void main(String args[])
{
	int col;
	int[] count;
	count = new int[26];
  	float[] prob;
	prob = new float[26];
  	double[] entropy;
	entropy = new double[26];
  	
	String id="";
	int i;
  	int id_value=0;
  	Writer output=null;
  	FileOutputStream fos = null;
	String alphabets="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  	
  	try
  	{
    	FileInputStream fstream = new FileInputStream("training.data");
		DataInputStream in = new DataInputStream(fstream);
  		BufferedReader br = new BufferedReader(new InputStreamReader(in));
  		String strLine;
		String str;
		int line=0;
		while ((strLine = br.readLine()) != null)   
  		{
			count[(int)strLine.charAt(0)-65]++;
			line++;
		}
		for(i=0;i<26;i++)
		{
			prob[i]=(float)count[i]/line;
			entropy[i]=(-1)*prob[i]*(Math.log(prob[i])/Math.log(2));							//Entropy Calculation : Entropy of dataset
			str=(char)(i+65)+" : Count = "+count[i]+" Probability = "+prob[i]+" Entropy = "+entropy[i]+"\n";
			try
			{
				fos = new FileOutputStream("Dataset_Entropy.data",true);
				byte[] matter = str.getBytes();
				fos.write(matter);
			}
			catch (IOException e)	
			{
				e.printStackTrace();
			}
		}
		in.close();
    }
    catch (Exception e)
	{
		e.printStackTrace();
	}
  }
  
}