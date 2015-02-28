package Strings;

import java.util.Scanner;

public class CommonChild {

	/**
	 * @param args
	 * https://hr-testcases.s3.amazonaws.com/660/input04.txt?AWSAccessKeyId=AKIAINGOTNJCTGAUP7NA&Expires=1422835713&Signature=cZ8Afr7SCcpNir%2BZ8eb%2FuTzY3%2BM%3D&response-content-type=text%2Fplain
	 * https://hr-testcases.s3.amazonaws.com/660/output04.txt?AWSAccessKeyId=AKIAINGOTNJCTGAUP7NA&Expires=1422835726&Signature=iriHtryzIV2%2Fvb4%2F1vfn2xkCAW8%3D&response-content-type=text%2Fplain
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		String s = commonChild(s1, s2);
		System.out.println(s);
		if(s==null)
			System.out.println(0);
		else
			System.out.println(s.length());
	}
	public static String commonChild(String s1, String s2){
		int n = s1.length();
		String[][] s = new String[n+1][n+1];
		String res ="";
		for(int i=0;i<n+1;i++){
			for (int j=0; j<n+1; j++){
	            if (i == 0 || j == 0)
	                s[i][j] = ""; 
	            else if (s1.charAt(i-1) == s2.charAt(j-1))
	            {
	                s[i][j] = s[i-1][j-1] + s1.charAt(i-1);
	                if(res.length()<=s[i][j].length()){
	                	res=s[i][j];
	                }
	            }
	            else s[i][j] = res;
	        }
		}
		return res;
	}
}
