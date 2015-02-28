package ArraysAndStrings;

import java.util.Scanner;

public class Q3_RemoveDuplicates {

	/**
	 * @param args
	 * Design an algorithm and write code to remove the duplicate characters in a string 
	 * without using any additional buffer.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.println(removeDuplicateCharacters(s));
		System.out.println(removeDuplicateCharactersUsingASCII(s));
	}
	public static String removeDuplicateCharacters(String s){
		if(s.length()==0)
			return null;
		StringBuffer res=new StringBuffer();
		res.append(s.charAt(0));
		for(int i=0;i<s.length();i++){
			int j=0;
			for(j=0;j<res.length();j++)
				if(s.charAt(i)==res.charAt(j))
					break;
			if(res.length()==j)
				res.append(s.charAt(i));
			
		}
		return res.toString();
	}
	
	public static String removeDuplicateCharactersUsingASCII(String s){
		if(s.length()==0)
			return null;
		StringBuffer res=new StringBuffer();
		int[] a = new int[256];
		for(int i=0;i<s.length();i++){
			if(a[s.charAt(i)]++==0){
				res.append(s.charAt(i));
			}
		}	
		return res.toString();
	}
}
