package Array;

import java.util.Scanner;

public class NextLargerPalindrome {

	/**
	 * @param args
	 * Given an integer find the immediate larger integer that that which is a 
	 * palindrome, example 1234212 -> 1234321, 345676 -> 346643.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		System.out.print(nextLargerPalindrome(n));
	}
	public static String nextLargerPalindrome(String n){
		String a="";
		String b="";
		String aR="";
		if(n.length()%2==0){
			a = n.substring(0,(n.length()/2));
			b = n.substring((n.length()/2),n.length());
		}
		else{
			a = n.substring(0,(n.length()/2)+1);
			b = n.substring(((n.length()/2)+1),n.length());
		}
		for(int i=n.length()/2-1;i>=0;i--)
			aR += n.charAt(i);
		if(Integer.parseInt(aR)>Integer.parseInt(b))
			return (a+aR);
		else
		{
			String temp = (Integer.parseInt(a)+1)+"";
			int size;
			if(n.length()%2==0)
				size=temp.length()-1;
			else
				size=temp.length()-2;
			for(int i=size;i>=0;i--)
				temp+=temp.charAt(i);
			return temp;
		}
	}
}
