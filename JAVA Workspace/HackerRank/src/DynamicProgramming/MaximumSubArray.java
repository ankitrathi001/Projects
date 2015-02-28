package DynamicProgramming;

import java.util.Scanner;

public class MaximumSubArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0;i<t;i++){
			int n = sc.nextInt();
			int[] a = new int[n];
			for(int j=0;j<n;j++){
				a[j]=sc.nextInt();
			}
			System.out.println(getLargestContinuousSubarraySum(a)+" "+getLargestNonContinuousSubarraySum(a));
		}
	}
	public static int getLargestNonContinuousSubarraySum(int[] a){
		int sum=0;
		boolean flag=false;
		for(int i=0;i<a.length;i++){
			if(a[i]>0){
				sum+=a[i];
				flag=true;
			}
		}
		if(flag==true)
			return sum;
		else
			return a[0];
	}
	public static int getLargestContinuousSubarraySum(int[] a){
		int max_sum =a[0];
		int current_sum = a[0];
		for(int i=1;i<a.length;i++){
			current_sum = Math.max(a[i], current_sum + a[i]);
			max_sum = Math.max(max_sum, current_sum);
		}
		return max_sum;
	}
}
