package DynamicProgramming;

public class Fibonacci {
	static int[] result;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 8;
		result = new int[n];
		result[0]=1;
		result[1]=1;
		System.out.println(fibonacci(n));
	}
	public static int fibonacci(int n){
		if(result[n-1]>0)
			return result[n-1];
		result[n-1] = fibonacci(n-1)+fibonacci(n-2);
		return result[n-1];
	}
}
