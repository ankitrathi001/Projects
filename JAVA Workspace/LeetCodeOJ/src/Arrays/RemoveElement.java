package Arrays;

public class RemoveElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,2,3};
		System.out.print(removeElement(A, 1));
	}
	public static int removeElement(int[] A, int elem) {
		int l = A.length;
	    for (int i=0; i<l; i++) {
	        if (A[i] == elem) {
	            A[i--] = A[l-- -1];
	        }
	    }
	    System.out.println(A[0]+" "+A[1]+" "+A[2]);
	    return l;
    }
}
