package StacksAndQueues;

import java.util.Stack;

public class Q5_ImplementQueueUsingStack {

	/**
	 * @param args
	 * Implement a MyQueue class which implements a queue using two stacks.
	 */
	public static Stack<Integer> s1 = new Stack<Integer>();
	public static Stack<Integer> s2 = new Stack<Integer>();
	public static void main(String[] args) {
		int[] array = {2,5,10,3,11,7,13,8,9,4,1,6};
		for(int i=0;i<5;i++){
			enQueue(array[i]);
		}
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());
		for(int i=0;i<4;i++){
			enQueue(array[i+5]);
		}
		System.out.println(deQueue());
		for(int i=0;i<3;i++){
			enQueue(array[i+9]);
		}
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());
	}
	public static void enQueue(int data){
		s1.push(data);
	}
	public static int deQueue(){
		if(s2.isEmpty())
			while(!s1.isEmpty()) 
				s2.push(s1.pop());
		return s2.pop();
	}
}
