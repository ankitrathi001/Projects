package Arrays;

public class RemoveDuplicateFromSorted {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,1};
		System.out.print(removeDuplicates(A));
	}
	public static int removeDuplicates(int[] A) {
		if (A.length == 0) return 0;
		if (A.length == 1) return 1;
	    int i = 0;
	    for (int j=0; j<A.length; j++) {
	        if (A[i] != A[j]) i++;
	        A[i] = A[j];
	    }
	    //System.out.println(A[0]+" "+A[1]+" "+A[2]);
	    return i+1;
    }
}
