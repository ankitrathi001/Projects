import java.util.ArrayList;
import java.util.Scanner;


public class FlippingBits {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long t = sc.nextInt();
		ArrayList<Long> A = new ArrayList<>();
		for(int i=0;i<t;i++){
			long n = sc.nextLong();
			A.add(n^4294967295l);
		}
		for(int i=0;i<A.size();i++)
			System.out.println(A.get(i));
	}

}
