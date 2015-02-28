package Strings;

import java.util.ArrayList;

public class PermutationsOfString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getPermutations("abcd"));
	}
	public static ArrayList<String> getPermutations(String s){
		if(s==null)
			return null;
		ArrayList<String> a = new ArrayList<>();
		if(s.length()==1)
			a.add(s);
		else{
			char c = s.charAt(0);
			String str="";
			for(int j=0;j<s.length();j++)
				if(j!=0)
					str+=s.charAt(j);
			ArrayList<String> t = getPermutations(str);
			for(int j=0;j<t.size();j++){
				String string = t.get(j);
				String temp="";
				for(int k=0;k<string.length();k++){
					temp="";
					for(int l=0;l<string.length();l++){
						if(l==k)
							temp+=c;
						temp+=string.charAt(l);
					}
					a.add(temp);
				}
				a.add(string+c);
			}
		}
		return a;
	}
}
