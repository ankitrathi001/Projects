package Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class Q4_PermutationsOfString {

	/**
	 * @param args
	 * Write a method to compute all permutations of a string
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		//System.out.println(removeCharAtI(s, 0));
		//System.out.println(addCharAtI('d', 1, s));
		System.out.print(getPermutations(s));
	}
	public static ArrayList<String> getPermutations(String s){
		ArrayList<String> A = new ArrayList<String>();
		if(s.length()==1){
			A.add(s);
			return A;
		}
		char c = s.charAt(0);
		String st=removeCharAtI(s, 0);
		ArrayList<String> temp = getPermutations(st);
		for(int j=0;j<temp.size();j++){
			String str = temp.get(j);
			for(int k=0;k<str.length();k++){
				String string = addCharAtI(c, k, str);
				A.add(string);
			}
			A.add(str+c);
		}
		return A;
	}
	public static String removeCharAtI(String s, int i){
		String res="";
		for(int j=0;j<s.length();j++)
			if(j!=i)
				res+=s.charAt(j);
		return res;
	}
	public static String addCharAtI(char c, int i, String s){
		String res="";
		for(int j=0;j<s.length();j++){
			if(j!=i)
				res+=s.charAt(j);
			else
				res = res + c + s.charAt(j);
		}
		return res;
	}
}
