package ArraysAndStrings;

import java.util.Scanner;

public class Q4_Anagram {

	/**
	 * @param args
	 * Write a method to decide if two strings are anagrams or not.
	 */
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		System.out.println(checkAnagram(s1, s2));
	}
	public static boolean checkAnagram(String s1, String s2){
		if(s1.length()!=s2.length())
			return false;
		int count1=0,count2=0;
		int[] a = new int[256];
		for(int i=0;i<s1.length();i++){
			if(a[s1.charAt(i)]++==0)
				count1++;
		}
		for(int i=0;i<s2.length();i++){
			if(a[s2.charAt(i)]==0)
				return false;
			if(--a[s2.charAt(i)]==0)
				count2++;
		}
		if(count1==count2)
			return true;
		else
			return false;
	}
}
