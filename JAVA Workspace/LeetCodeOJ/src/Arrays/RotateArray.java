package Arrays;

public class RotateArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4,5,6,7,8};
		for(int i=0;i<nums.length;i++)
        	System.out.print(nums[i]+" ");
		System.out.println();
		rotate(nums, 3);
		for(int i=0;i<nums.length;i++)
        	System.out.print(nums[i]+" ");
	}
	public static void rotate(int[] nums, int k) {
        int len = nums.length;
        int j=0;
        int c=0;
        int i = 0;
        int m = k;
        for(i=len-k;i<len;i++,j++,k++){
        	int a = nums[j];
        	nums[j] = nums[i];
        	int b = nums[k];
        	c = nums[k];
        	nums[k] = a;
        	nums[i] = c;
        }
        for(int l=0;l<nums.length;l++)
        	System.out.print(nums[l]+" ");
		System.out.println();
		
        for(i=len-m;i<len && k<len;i++,j++,k++){
        	int a = nums[i];
        	nums[i] = nums[k];
        	nums[k] = a;
        }
    }
}
