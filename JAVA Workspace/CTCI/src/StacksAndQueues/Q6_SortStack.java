package StacksAndQueues;

import java.util.Stack;

public class Q6_SortStack {

	/**
	 * @param args
	 * Write a program to sort a stack in ascending order. 
	 * You should not make any assumptions about how the stack is implemented. 
	 * The following are the only functions that should be used to 
	 * write this program: push | pop | peek | isEmpty.
	 */
	public static void main(String[] args) {
		int[] array = {2,5,10,3,11,7,13,8,9,4,1,6};
		Stack<Integer> s1 = new Stack<Integer>();
		//int[] array = {2,4,1,6};
		for(int i=0;i<array.length;i++){
			s1.push(array[i]);
		}
		//displayStack(s1);
		displayStack(sortStack(s1));
	}
	public static Stack<Integer> sortStack(Stack<Integer> s1){
		Stack<Integer> s2 = new Stack<Integer>();
		while(!s1.isEmpty()){
			int temp = s1.pop();
			while(!s2.isEmpty() && s2.peek()<temp){
				s1.push(s2.pop());
			}
			s2.push(temp);
		}
		return s2;
	}
	public static void displayStack(Stack<Integer> s){
		while(!s.isEmpty())
			System.out.print(s.pop()+"->");
		System.out.println("end");
	}
}
