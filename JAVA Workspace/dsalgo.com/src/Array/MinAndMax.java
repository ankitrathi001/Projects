package Array;

public class MinAndMax {

	/**
	 * @param args
	 * Given an array of integers, find the maximum and minimum of the array.
	 */
	public static void main(String[] args) {
		int[] a = {4,3,7,1,4,8,3,8,0,4,2,9,3,5,6,2};
		a = QuickSort.sort(a);
		System.out.println("Min: "+a[0]);
		System.out.println("Max: "+a[a.length-1]);
	}
}
