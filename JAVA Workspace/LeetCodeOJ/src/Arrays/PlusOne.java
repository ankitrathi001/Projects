package Arrays;


public class PlusOne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] a = {9,8,7,6,5,4,3,2,1,0};
		int[] a = {9,9,9,9,9,9,9};
		int[] b = plusOne(a);
		for(int i=0;i<b.length;i++)
			System.out.print(b[i]);
	}
	public static int[] plusOne(int[] digits) {
		int carry=1;
		for(int i =digits.length-1;i>=0;i--){
			int x = digits[i]+carry;
			digits[i] = x%10;
			carry = x/10;
		}
		if(carry==1)
		{
			int[] a = new int[digits.length+1];
			a[0] = 1;
			return a;
		}
		return digits;
    }
}
