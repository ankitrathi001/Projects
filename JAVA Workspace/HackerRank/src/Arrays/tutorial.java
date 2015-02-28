package Arrays;

import java.util.Scanner;

public class tutorial {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int n = sc.nextInt();
		int i=0;
		for(i=0;i<n;i++)
			if(sc.nextInt()==v)
				break;
		System.out.println(i);
	}

}
