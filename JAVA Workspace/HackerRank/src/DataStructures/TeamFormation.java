package DataStructures;

import java.util.Arrays;
import java.util.Scanner;

public class TeamFormation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] a = {7, 4, 5, 2, 3, -4, -3, -5};
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int k=0;k<t;k++){
			int n = sc.nextInt();
			int[] a = new int[n];
			for(int i=0;i<n;i++)
				a[i]=sc.nextInt();
			Arrays.sort(a);
			for(int i=0;i<n;i++)
				System.out.print(a[i]+" ");
			System.out.println();
			int j=1;
			int min=Integer.MAX_VALUE;
			
		}
	}

}
