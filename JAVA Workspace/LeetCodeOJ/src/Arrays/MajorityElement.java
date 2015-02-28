package Arrays;

import java.util.Arrays;

public class MajorityElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {2,1};
		System.out.println(majorityElement(A));
	}
	public static int majorityElement(int[] num) {
		Arrays.sort(num);
		if(num.length==1)
			return num[0];
		int x = num[0];
		int count = 1;
		for(int i=1;i<num.length;i++){
			if(num[i]==x){
				count++;
			}
			else{
				if(count>=num.length/2)
					return x;
				x = num[i];
				count = 1;
			}
		}
		return x;
    }
}
