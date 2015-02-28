package Arrays;

public class SearchInsertPosition {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,3,5,6};
		int[] b = {1,3,5,6};
		int[] c = {1,3,5,6};
		int[] d = {1,3,5,6};
		int[] e = {1,3};
		System.out.println(searchInsert(a, 5));
		System.out.println(searchInsert(b, 2));
		System.out.println(searchInsert(c, 7));
		System.out.println(searchInsert(d, 0));
		System.out.println(searchInsert(e, 3));
	}
	public static int searchInsert(int[] A, int target) {
        int i = 0;
        if(target<=A[0])
        	return 0;
        if(target>A[A.length-1])
        	return A.length;
        for(int j=1;j<A.length;j++){
        	if(target>A[j-1] && target<A[j])
        		return j;
        	if(target == A[j])
        		return j;
        }
        return i;
    }
}
