import java.util.ArrayList;
import java.util.Scanner;


public class UtopianTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		ArrayList<Integer> A = new ArrayList<>();
		for(int i=0;i<t;i++)
			A.add(getHeight(sc.nextInt()));
		for(int i=0;i<A.size();i++)
			System.out.println(A.get(i));
	}
	public static int getHeight(int n){
		if(n==0)
			return 1;
		if(n%2==0)
			return 1+getHeight(n-1);
		else
			return 2*getHeight(n-1);
	}
}
