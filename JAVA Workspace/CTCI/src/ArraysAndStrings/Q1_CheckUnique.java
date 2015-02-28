package ArraysAndStrings;

import java.util.Scanner;

public class Q1_CheckUnique {

	/**
	 * @param args
	 * Implement an algorithm to determine if a string has all unique characters. 
	 * What if you can not use additional data structures?
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.println(checkUnique(s));
	}
	public static boolean checkUnique(String s){
		int[] ascii = new int[256];
		for(int i=0;i<s.length();i++)
			if(ascii[s.charAt(i)]++>0)
				return false;
		return true;
	}

}
