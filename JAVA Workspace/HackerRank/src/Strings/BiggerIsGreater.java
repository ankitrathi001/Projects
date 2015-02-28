package Strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BiggerIsGreater {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0;i<n;i++){
			String s = sc.next();
			int start=0;
			while(!isStringSorted(s.substring(start,s.length()))){
				start++;
			}
			if(start==0)
				System.out.println("no answer");
			else if(start==s.length()-1){
				String res="";
				for(int j=0;j<s.length()-2;j++)
					res+=s.charAt(j);
				res+=s.charAt(s.length()-1);
				res+=s.charAt(s.length()-2);
				System.out.println(res);
			}
			else{
				char temp = s.charAt(start+1);
				int index = start+1;
				for(int j=start+2;j<s.length();j++){
					char x = s.charAt(j);
					if(x<temp && x>s.charAt(start-1)){
						temp = x;
						index=j;
					}
				}
				start--;
				char y = s.charAt(start);
				String res="";
				for(int j=0;j<=start;j++){
					if(j==start)
						res+=temp;
					else
						res+=s.charAt(j);
				}
				for(int j=s.length()-1;j>start;j--){
					if(j==index)
						res+=y;
					else
						res+=s.charAt(j);
				}
				System.out.println(res);
			}
		}
	}
	public static boolean isStringSorted(String s){
		for(int i=1;i<s.length();i++)
			if(s.charAt(i)>s.charAt(i-1))
				return false;
		return true;
	}
}
