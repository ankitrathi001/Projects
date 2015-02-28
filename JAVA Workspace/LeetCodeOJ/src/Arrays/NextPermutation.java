package Arrays;

import java.util.Arrays;

public class NextPermutation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {3,2,1};
		nextPermutation(num);
	}
	public static void nextPermutation(int[] num) {
        if(checkDesc(num))
        	Arrays.sort(num);
        else{
        	
        }
        for(int i=0;i<num.length;i++){
        	System.out.print(num[i]);
        }
    }
	public static boolean checkDesc(int[] num){
		for(int i=1;i<num.length;i++){
			if(num[i]>num[i-1])
				return false;
		}
		return true;
	}
}
