package DynamicProgramming;

import java.util.Scanner;

public class LongestPalindrome {

	/**
	 * @param args
	 * Given a string find the longest possible substring which is a palindrome.
	 */
	public static String res="";
	public static int size=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		longestPalindrome(s);
		System.out.println(res);
	}
	
	public static void longestPalindrome(String s){
		//System.out.println(s);
		if(s.length()==0)
			return;
			
		if(s.charAt(0)!=s.charAt(s.length()-1)){
			longestPalindrome(s.substring(1, s.length()));
			longestPalindrome(s.substring(0, s.length()-1));
		}
		else if(checkPalindrome(s)){
			//System.out.println(s);
			if(s.length()>size){
				size=s.length();
				res=s;
			}
		}
		else{
			longestPalindrome(s.substring(0, s.length()-1));
			longestPalindrome(s.substring(1, s.length()));
		}
	}
	public static boolean checkPalindrome(String s){
		//System.out.println(s);
		int i=0;int j=s.length()-1;
		while(i<=j){
			if(s.charAt(i)!=s.charAt(j))
				return false;
			i++;j--;
		}
		return true;
	}
}
