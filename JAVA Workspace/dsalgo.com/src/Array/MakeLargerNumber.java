package Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MakeLargerNumber {

	/**
	 * @param args
	 * Given a number whose digits are unique, find the next larger number 
	 * that can be formed with those digits.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> a = new ArrayList<Integer>();
		while(n!=0){
			a.add(0,n%10);
			n=n/10;
		}
		//System.out.println(a);
		System.out.println(makeLargerNumber(a));
	}
	public static ArrayList<Integer> makeLargerNumber(ArrayList<Integer> a){
		int start = 0;
		while(!isArrayListSorted(a.subList(start, a.size()))){
			start++;
		}
		//System.out.println(start);
		if(start==0)
			return a;
		int temp = a.get(start);
		int index = start;
		for(int i=start+1;i<a.size();i++){
			if(a.get(i)>(a.get(start-1)) && a.get(i)<temp){
				temp = a.get(i);
				index = i;
			}
		}
		start--;
		int x = a.get(start);
		a.set(start, temp);
		a.set(index, x);
		//System.out.println(a.subList(start+1, a.size()));
		int[] b = new int[a.size()-start-1];
		int aSize = a.size();
		for(int i=0;i<aSize-start-1;i++){
			b[i]=a.get(start+1);
			a.remove(start+1);
		}
		b = QuickSort.sort(b);
		for(int i=0;i<aSize-start-1;i++){
			a.add(b[i]);
			//System.out.print(b[i]);
		}
		return a;
	}
	public static boolean isArrayListSorted(List<Integer> a){
		for(int i=1;i<a.size();i++)
			if(a.get(i)>a.get(i-1))
				return false;
		return true;
	}
}
