package Strings;

import java.util.ArrayList;

public class InsertingSpaces {

	/**
	 * @param args
	 * Print all possible strings that can be made by placing spaces
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getStringWithSpaces("ABCD"));
	}
	public static ArrayList<String> getStringWithSpaces(String s){
		ArrayList<String> a = new ArrayList<>();
		if(s.length()==1){
			a.add(s);
			return a;
		}
		ArrayList<String> t = getStringWithSpaces(s.substring(1, s.length()));
		for(int i=0;i<t.size();i++){
			a.add(s.charAt(0)+t.get(i));
			a.add(s.charAt(0)+" "+t.get(i));
		}
		return a;
	}
}
