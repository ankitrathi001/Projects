package LinkedLists;

import java.util.Scanner;

public class Q3_DeleteANodeFromCenter {

	/**
	 * @param args
	 * Implement an algorithm to delete a node in the middle of a single linked list, 
	 * given only access to that node.
	 */
	public static void main(String[] args) {
		int[] array = {6,1,3,5,7,13,13,9,5,14,15};
		SinglyLinkedList SLL = new SinglyLinkedList(8);
		for(int i=0;i<array.length;i++){
			SinglyLinkedList.addANode(SLL, array[i], i+1);
		}
		Scanner sc = new Scanner(System.in);
		SinglyLinkedList node = SLL;
		int n = sc.nextInt();
		for(int i=0;i<n-1;i++){
			node = node.next;
		}
		SinglyLinkedList.displayLL(SLL);
		if(deleteANodeFromCenterGivenANode(SLL, node))
			SinglyLinkedList.displayLL(SLL);
	}
	public static boolean deleteANodeFromCenterGivenANode(SinglyLinkedList SLL, SinglyLinkedList node){
		if(node==null || node.next==null)
			return false;
		node.data = node.next.data;
		node.next = node.next.next;
		return true;
	}
}
