import java.util.Scanner;


public class GameOfThrones1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner myScan = new Scanner(System.in);
        String inputString = myScan.nextLine();
       
        String ans=null;
        // Assign ans a value of YES or NO, depending on whether or not inputString satisfies the required condition
        int count=0;
        int[] a = new int[26];
        for(int i=0;i<inputString.length();i++)
        	a[inputString.charAt(i)-97]++;
        for(int i=0;i<26;i++)
        	if(a[i]%2==1)
        		count++;
        if(count>1)
        	ans="NO";
        else if(count==0)
        	ans="YES";
        else if(count==1 && inputString.length()%2==1)
        	ans="YES";
        else
        	ans="NO";
        System.out.println(ans);
        myScan.close();
	}

}
