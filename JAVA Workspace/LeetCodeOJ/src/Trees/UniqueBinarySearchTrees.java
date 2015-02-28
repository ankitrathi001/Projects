package Trees;

public class UniqueBinarySearchTrees {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numTrees(11));
	}
	public static int numTrees(int n){
		long res=1;
		int x = n*2;
		for(int i=0;i<n-1;i++){
			res*=x;
			x--;
		}
		System.out.println(res);
		long t = res/fact(n);
		return (int)t;
		
	}
	public static long fact(int n){
		if(n==0)
			return 1;
		return n*fact(n-1);
	}
}
