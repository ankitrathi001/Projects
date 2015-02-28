package Arrays;

public class SingleNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1};
		System.out.println(singleNumber(A));
	}
	public static int singleNumber(int[] A) {
        int num = 0;
		for(int i=0;i<A.length;i++)
			num^=A[i];
		return num;
    }
}
