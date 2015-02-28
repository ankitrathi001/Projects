package ArraysAndStrings;

import java.util.Scanner;

public class Q8_CheckRotationInAString {

	/**
	 * @param args
	 * Assume you have a method isSubstring which checks if one word is a substring of another. 
	 * Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only 
	 * one call to isSubstring (i.e., “waterbottle” is a rotation of “erbottlewat”).
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		System.out.println(checkRotation(s1, s2));
	}
	public static boolean checkRotation(String s1, String s2){
		if((s1+s1).contains(s2))
			return true;
		else
			return false;
	}
}
