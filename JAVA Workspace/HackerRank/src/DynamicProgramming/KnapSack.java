package DynamicProgramming;

import java.util.ArrayList;
import java.util.Scanner;


public class KnapSack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0;i<t;i++){
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] a = new int[n];
			for(int j=0;j<n;j++)
				a[j] = sc.nextInt();
			System.out.println(knapSackDuplicateAllowed(a, k));
		}
	}
	public static int knapSackDuplicateAllowed(int[] a, int k){
		
		ArrayList<Integer> A = new ArrayList<>();
		for(int i=0;i<a.length;i++){
			if(k%a[i]==0)
				return k;
			int x = k/a[i];
			for(int j=0;j<x;j++)
				A.add(a[i]);
		}
		System.out.println(A);
		return knapSack(A,k,0);
	}
	public static int knapSack(ArrayList<Integer> A, int k, int sum){
		if(A.size()==0)
			return 0;
		int x = A.get(0);
		A.remove(0);
		return 0;
	}
}
