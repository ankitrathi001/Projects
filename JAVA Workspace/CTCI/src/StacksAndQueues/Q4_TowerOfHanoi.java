package StacksAndQueues;

import java.util.Scanner;
import java.util.Stack;

public class Q4_TowerOfHanoi {

	/**
	 * @param args
	 * Tower of Hanoi
	 */
	public static Stack<Integer> orignal = new Stack<Integer>();
	public static Stack<Integer> intermediate = new Stack<Integer>();
	public static Stack<Integer> target = new Stack<Integer>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=n;i>0;i--)
			orignal.push(i);
		towerOfHanoi(orignal, target, intermediate, n);
		displayStack(target);
	}
	public static void displayStack(Stack<Integer> s){
		while(!s.isEmpty())
			System.out.println(s.pop());
	}
	public static void towerOfHanoi(Stack<Integer> orignal, Stack<Integer> target, Stack<Integer> intermediate, int n){
		if(n==0)
			return;
		towerOfHanoi(orignal, intermediate, target, n-1);
		target.push(orignal.pop());
		towerOfHanoi(intermediate,target,orignal,n-1);
	}
}
