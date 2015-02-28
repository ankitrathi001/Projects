package Strings;

import java.util.Scanner;
import java.util.Stack;

public class MorganAndAString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0;i<t;i++){
			String s1 = sc.next();
			String s2 = sc.next();
			int j=0;int k=0;
			while(j<s1.length() && k<s2.length()){
				if(s1.charAt(j)>s2.charAt(k)){
					System.out.print(s2.charAt(k));
					k++;
				}
				else{
					System.out.print(s1.charAt(j));
					j++;
				}
			}
			while(j<s1.length()){
				System.out.print(s1.charAt(j));
				j++;
			}
			while(k<s2.length()){
				System.out.print(s2.charAt(k));
				k++;
			}
			System.out.println();
		}
	}

}
