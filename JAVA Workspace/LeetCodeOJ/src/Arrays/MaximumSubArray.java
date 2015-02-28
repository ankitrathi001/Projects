package Arrays;

public class MaximumSubArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(A));
		System.out.println(maxSubArrayWithIndex(A));
	}
	public static int maxSubArray(int[] A) {
		int newsum=A[0];
		int max=A[0];
		for(int i=1;i<A.length;i++){
			newsum=Math.max(newsum+A[i],A[i]);
			max= Math.max(max, newsum);
		}
		return max;
    }
	public static int maxSubArrayWithIndex(int[] A) {
		int newsum=A[0];
		int max=A[0];
		int startIndex=0;
		int lastIndex = 0;
		for(int i=1;i<A.length;i++){
			if(newsum+A[i]>A[i])
				newsum = newsum+A[i];
			else
			{
				newsum=A[i];
				startIndex = i;
			}
			if(max<newsum){
				max = newsum;
				lastIndex = i;
			}
		}
		System.out.println(startIndex+" "+lastIndex);
		return max;
    }
}
