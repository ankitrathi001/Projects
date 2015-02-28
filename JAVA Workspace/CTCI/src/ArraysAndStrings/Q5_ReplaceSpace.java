package ArraysAndStrings;

import java.util.Scanner;

public class Q5_ReplaceSpace {

	/**
	 * @param args
	 * Write a method to replace all spaces in a string with ‘%20’.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] s1 = sc.nextLine().toCharArray();
		char toBeReplaced=' ';
		String rep = "%20";
		char[] s2 = replaceString(s1, toBeReplaced, rep);
		for(int i=0;i<s2.length;i++)
			System.out.print(s2[i]);
	}
	public static char[] replaceString(char[] s1, char toBeReplaced, String rep){
		int count=0;
		for(int i=0;i<s1.length;i++){
			if(s1[i]==toBeReplaced)
				count++;
		}
		char[] s2 = new char[s1.length+(count*2)];
		int j=0;
		for(int i=0;i<s1.length;i++){
			if(s1[i]==toBeReplaced){
				s2[j++]='%';
				s2[j++]='2';
				s2[j++]='0';
			}
			else
				s2[j++]=s1[i];
		}
		return s2;
	}
}
