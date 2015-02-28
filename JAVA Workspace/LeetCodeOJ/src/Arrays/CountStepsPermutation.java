package Arrays;

public class CountStepsPermutation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(climbStairs(5));
	}
	public static int climbStairs(int n) {
        if(n==0 || n==1)
        	return 1;
        int a = 1;
        int b = 1;
        for(int i=0;i<n-1;i++){
        	int c = a;
        	a = a+b;
        	b = c;
        }
        return a;
    }
}
