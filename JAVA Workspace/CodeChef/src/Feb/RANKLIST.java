package Feb;

import java.util.Scanner;

public class RANKLIST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0;i<t;i++){
			int n = sc.nextInt();
			int s = sc.nextInt();
			if(s==(n*(n+1)/2))
				System.out.println(0);
			else if(n==s)
				System.out.println(n-1);
			else
				System.out.println((n*(n+1)/2)-s);
		}
	}
}
