package ICIMS;

import java.util.Arrays;

public class FindMinimalDuplicate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] a = {1,3,2,1};
		//int[] b = {4,2,5,3,2};
		int[] a = {1,4,2,1};
		int[] b = {3,5,3};
		Arrays.sort(a);
		Arrays.sort(b);
		int i=0;int j=0;
		while(i<a.length && j<b.length){
			if(a[i]==b[j])
				break;
			if(a[i]<b[j])
				i++;
			else if(a[i]>b[j])
				j++;
		}
		if(i==a.length || j==b.length)
			System.out.println(-1);
		else
			System.out.println(a[i]);
	}
	
}
