package LinkedLists;

import java.util.Scanner;

public class Q2_NthToLastElement {

	/**
	 * @param args
	 * Implement an algorithm to find the nth to last element of a singly linked list.
	 */
	public static void main(String[] args) {
		int[] array = {6,1,3,5,7,13,13,9,5,14,15};
		SinglyLinkedList SLL = new SinglyLinkedList(8);
		for(int i=0;i<array.length;i++){
			SinglyLinkedList.addANode(SLL, array[i], i+1);
		}
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		SinglyLinkedList.displayLL(SLL);
		System.out.println(nthToLastElement(SLL,n));
	}
	public static int nthToLastElement(SinglyLinkedList SLL, int n){
		SinglyLinkedList top = SLL;
		SinglyLinkedList bottom = SLL;
		for(int i=0;i<n-1;i++){
			if(top.next!=null)
				top = top.next;
			else
				return -1;
		}
		while(top.next!=null){
			top = top.next;
			bottom = bottom.next;
		}
		return bottom.data;
	}
}
