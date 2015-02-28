package Strings;

import java.util.ArrayList;
import java.util.Scanner;

public class SquareSubSequences {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0;i<t;i++){
			int count =0;
			ArrayList<String> a = getAllPossibleStringPatterns(sc.next());
			for(int j=0;j<a.size();j++){
				if(a.get(j).length()%2==0){
					if(checkSquareString(a.get(j)))
						count++;
				}
			}
			System.out.println(count);
		}
	}
	public static boolean checkSquareString(String s){
		int mid=s.length()/2;
		int x = mid;
		for(int i=0;i<x;i++,mid++){
			if(s.charAt(i)!=s.charAt(mid))
				return false;
		}
		return true;
	}
	public static ArrayList<String> getAllPossibleStringPatterns(String s){
		if(s==null)
			return null;
		ArrayList<String> a = new ArrayList<>();
		if(s.length()==1){
			a.add(s);
		}
		else{
			char c = s.charAt(0);
			String str = s.substring(1,s.length());
			ArrayList<String> t = getAllPossibleStringPatterns(str);
			for(int i=0;i<t.size();i++){
				a.add(c+t.get(i));
				a.add(t.get(i));
			}
			a.add(c+"");
		}
		return a;
	}
}
