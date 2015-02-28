package Combinatorics;

import java.util.Scanner;

public class SherlockAndPermutations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0;i<t;i++){
			int n = sc.nextInt();
			int m = sc.nextInt();
			if(m==1)
				System.out.println(1);
			else
				System.out.println(n_kFactorial(n+m-1, m-1)/(m-1));
		}
	}
	public static int n_kFactorial(int n, int k){
		if(n==k)
			return 1;
		return (n*n_kFactorial(n-1, k));
	}
}
