package DynamicProgramming;

public class TwoNumbersSumUpToK {

	/**
	 * @param args
	 * Given a sorted integer array and an integer k, find two numbers which 
	 * sum upto k.
	 */
	public static void main(String[] args) {
		int[] a = {1,3,5,6,7,9,11,15,16,19,21};
		twoNumbersSumUpToK(a, 0, a.length-1, 20);
	}
	public static void twoNumbersSumUpToK(int[] a, int i, int j, int k){
		if(i>j)
			return;
		if((a[i]+a[j])>k)
			j--;
		else if((a[i]+a[j])<k)
			i++;
		else {System.out.println(a[i]+"+"+a[j]+" = "+k);
		i++;j--;
		}
		twoNumbersSumUpToK(a, i, j, k);
	}
}
