import java.util.Scanner;


public class MaximizingXOR {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int max=0;
		int L = sc.nextInt();
		int R = sc.nextInt();
		for(int i=L;i<=R;i++)
			for(int j=i;j<=R;j++)
				if(max<(i^j))
					max=i^j;
		System.out.println(max);
	}

}
