package StacksAndQueues;
import java.util.*;

public class Q2_FindingMin {

	/**
	 * @param args
	 * How would you design a stack which, in addition to push and pop, also has a function min 
	 * which returns the minimum element? Push, pop and min should all operate in O(1) time.
	 */
	public static Stack<Integer> minStack = new Stack<Integer>();
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		int[] array = {2,5,10,3,11,7,13,8,9,4,1,6};
		int min = Integer.MAX_VALUE;
		for(int i=0;i<array.length;i++){
			s.push(array[i]);
			if(min>array[i])
				min = array[i];
			minStack.push(min);
		}
		System.out.println("Min: "+minStack());
		System.out.println("Pop: "+popStack(s));
		System.out.println("Pop: "+popStack(s));
		System.out.println("Min: "+minStack());
		System.out.println("Pop: "+popStack(s));
		System.out.println("Min: "+minStack());
		System.out.println("Min: "+minStack());
	}
	public static int popStack(Stack<Integer> s){
		minStack.pop();
		return s.pop();
	}
	public static int minStack(){
		return minStack.peek();
	}
}
