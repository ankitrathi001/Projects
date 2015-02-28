import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;


public class Q1_ZeroOneMultiple {

	/**
	 * @param args
	 */
	public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(zeroOne(n));
    }
    public static String zeroOne(int n){
		if(n==1 || n==0)
			return ""+n;
		int i=2;
		while(true){
			String s=getBinary(i);
			if(checkDivisibility(s, n))
				return s;
			i++;
		}
	}
	
	public static String getBinary(int n){
		String res="";
		while(n>0){
			res=n%2+res;
			n=n/2;
		}
		return res;
	}
	public static boolean checkDivisibility(String s, int n){
		String res="0";
		for(int i=0;i<s.length();i++){
			int temp=(Integer.parseInt(res)*10)+Integer.parseInt(s.charAt(i)+"");
			res=temp%n+"";
		}
		if(res.equals("0"))
			return true;
		return false;
	}
}
