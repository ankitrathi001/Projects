package Strings;

import java.util.ArrayList;

public class AllPossibleStringPatterns {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getAllPossibleStringPatterns("wxyz"));
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
