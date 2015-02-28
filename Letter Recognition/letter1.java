import java.io.*;

class letter1
{
public static void main(String args[])
{
	int col;
	int[][][] count;
	count = new int[26][16][16];
	float[] entropy;
	entropy = new float[16];
  	float[] prob;
	prob = new float[16];
	int[] classcount;
	classcount = new int[26];
	String id="";
	int i;
  	int id_value=0;
  	Writer output=null;
  	FileOutputStream fos = null;
	FileOutputStream fos1 = null;
	String alphabets="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  	
  	try
  	{
    	FileInputStream fstream = new FileInputStream("training.data");
		DataInputStream in = new DataInputStream(fstream);
  		BufferedReader br = new BufferedReader(new InputStreamReader(in));
  		String strLine;
		String str,num;
		int line=0;
		int k,j=0;
		
		while ((strLine = br.readLine()) != null)   
		{
			j=0;
			for(i=2;i<strLine.length()-2;i++)
    		{		
				num="";
				while(strLine.charAt(i)!=44)
				{
					num=num+(char)strLine.charAt(i);
					i++;
				}
				count[(int)strLine.charAt(0)-65][j][(Integer.parseInt(num))]++;
				j++;
			}
			classcount[(int)strLine.charAt(0)-65]++;
			line++;
		}
		for(i=0;i<26;i++)
		{
			for(j=0;j<16;j++)
			{
				for(k=0;k<16;k++)
				{
					
					str=(char)(i+65)+" "+j+" "+k+" : "+count[i][j][k]+"\n";
					fos = new FileOutputStream("Dataset_Entropy1.data",true);
					byte[] matter = str.getBytes();
					fos.write(matter);
				}	
			}
			String str1=""+classcount[i]+"\n";
			byte[] matter1 = str1.getBytes();
			fos1 = new FileOutputStream("Dataset_Entropy2.data",true);
			fos1.write(matter1);
				
		}
		float temp1=0;
		float temp2=0;
		
		for(i=0;i<1;i++)
		{
			for(j=0;j<26;j++)
			{
				temp1=0;
				temp2=0;
				for(k=0;k<16;k++)
				{
					temp1=((float)count[j][i][k]/classcount[j]);
					if(temp1!=0)
					temp2+=(-1)*(temp1)*(Math.log(temp1)/Math.log(2));
				}
			//	System.out.println(temp2);
				entropy[i]+=((float)classcount[j]/line)*(temp2);
			}
			System.out.println("fjghkdjfg"+entropy[i]);
		}
		
		/*		for(i=0;i<26;i++)
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
*/
		

		in.close();
    }
    catch(Exception e)
	{
		e.printStackTrace();
	}
  }
}