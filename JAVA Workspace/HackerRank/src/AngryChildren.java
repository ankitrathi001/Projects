import java.util.Arrays;
import java.util.Scanner;


public class AngryChildren {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] packets = new int[N];
		int unfairness=Integer.MAX_VALUE;
		for(int i=0;i<N;i++)
			packets[i]=sc.nextInt();
		Arrays.sort(packets);
		for(int i=0;i<=N-K;i++)
			if(unfairness>packets[K-1+i]-packets[i])
				unfairness = packets[K-1+i]-packets[i];
		System.out.println(unfairness);
	}

}
