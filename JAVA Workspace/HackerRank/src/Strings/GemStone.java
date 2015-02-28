package Strings;

import java.util.Scanner;

public class GemStone {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[26];
		for(int i=0;i<n;i++){
			String s = sc.next();
			for(int j=0;j<s.length();j++){
				if((a[s.charAt(j)-'a'])==i)
					a[s.charAt(j)-'a']++;
			}
		}
		int count=0;
		for(int i=0;i<26;i++){
			if(a[i]==n)
				count++;
		}
		System.out.println(count);
	}

}
