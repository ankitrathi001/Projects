package Arrays;

public class MinInSortedRotatedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[] = {4,5,6,7,0,1,2};
		System.out.println(findMin(num));
	}
	public static int findMin(int[] num) {
        if(num.length==1)
        	return num[0];
		for(int i=1;i<num.length;i++){
			if(num[i]<num[i-1])
				return num[i];
		}
		return num[0];
    }
}
