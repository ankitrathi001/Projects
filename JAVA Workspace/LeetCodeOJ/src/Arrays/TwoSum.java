package Arrays;

import java.util.HashMap;

public class TwoSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {11,15,7,2};
		int[] a = twoSum(numbers, 9);
		System.out.println(a[0] + " " +a[1]);
	}
	public static int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> h = new HashMap<>();
        for(int i=0;i<numbers.length;i++)
        	h.put(numbers[i], i+1);
        for(int i=0;i<numbers.length;i++){
        	int x = target-numbers[i];
        	if(h.containsKey(x) && h.get(x)!=i+1)
        		return new int[]{i+1,h.get(x)};
        }
        return null;
    }
}
