package Combinatorics;

import java.util.Scanner;

public class ConnectingTowns {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int product=1;
            int n = sc.nextInt();
            for(int j=0;j<n-1;j++)
                product=(product*sc.nextInt())%1234567;
            System.out.println(product);
        }
	}

}
