package Feb;

import java.util.Scanner;

public class CHEFCH {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0;i<t;i++){
			int count1=0;
			int count2=0;
			String s = sc.next();
			for(int j=0;j<s.length();j++){
				if(j%2==0){
					if(s.charAt(j)=='+')
						count1++;
					else
						count2++;
				}
				else{
					if(s.charAt(j)=='-')
						count1++;
					else
						count2++;
				}
			}
			System.out.println(Math.min(count1, count2));
		}
	}

}
