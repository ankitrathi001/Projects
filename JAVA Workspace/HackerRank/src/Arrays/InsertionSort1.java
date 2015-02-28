package Arrays;

import java.util.Scanner;

public class InsertionSort1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		int x = a[n-1];
		int i;
		for(i=n-2;i>=0;i--){
			if(a[i]>x){
				a[i+1]=a[i];
				printArray(a);
			}
			else{
				break;
			}
		}
		a[i+1]=x;
		printArray(a);
	}
	public static void printArray(int[] a){
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}
}
