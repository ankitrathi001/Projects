package Strings;

import java.util.Scanner;

public class PalindromeIndex {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0;i<n;i++)
			System.out.println(getPalindromeIndex(sc.next()));
	}
	public static int getPalindromeIndex(String s){
		int x,y;
		for(x=0, y=s.length()-1;x<y;x++,y--){
			if(s.charAt(x)!=s.charAt(y)){
				if(checkPalindrom(s.substring(x,y)))
					return y;
				else
					return x++;
			}
		}
		return -1;
	}
	public static boolean checkPalindrom(String s){
		int x,y;
		for(x=0, y=s.length()-1;x<y;x++,y--){
			if(s.charAt(x)!=s.charAt(y)){
				return false;
			}
		}
		return true;
	}
}
