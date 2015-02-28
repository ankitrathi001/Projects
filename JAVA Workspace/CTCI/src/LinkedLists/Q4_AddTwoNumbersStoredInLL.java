package LinkedLists;

import java.util.Scanner;

public class Q4_AddTwoNumbersStoredInLL {

	/**
	 * @param args
	 * You have two numbers represented by a linked list, where each node contains a single digit. 
	 * The digits are stored in reverse order, such that the 1’s digit is at the head of the list. 
	 * Write a function that adds the two numbers and returns the sum as a linked list.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		SinglyLinkedList aSLL = new SinglyLinkedList(0);
		SinglyLinkedList bSLL = new SinglyLinkedList(0);
		for(int i=0;i<a.length();i++)
			SinglyLinkedList.addANode(aSLL, (int)a.charAt(i)-48, 0);
		for(int i=0;i<b.length();i++)
			SinglyLinkedList.addANode(bSLL, (int)b.charAt(i)-48, 0);
		SinglyLinkedList.displayLL(aSLL);
		SinglyLinkedList.displayLL(bSLL);
		SinglyLinkedList sumSLL = addTwoLinkedLists(aSLL.next,bSLL.next);
		SinglyLinkedList.displayLL(sumSLL);
	}
	public static SinglyLinkedList addTwoLinkedLists(SinglyLinkedList aSLL, SinglyLinkedList bSLL){
		SinglyLinkedList sumSLL = new SinglyLinkedList(0);
		int carry = 0;
		int i=1;
		while(aSLL!=null && bSLL!=null){
			int n = aSLL.data+bSLL.data+carry;
			carry = n/10;
			n=n%10;
			SinglyLinkedList.addANode(sumSLL, n, i++);
			aSLL = aSLL.next;
			bSLL = bSLL.next;
		}
		while(aSLL!=null){
			int n = aSLL.data+carry;
			carry = n/10;
			n=n%10;
			SinglyLinkedList.addANode(sumSLL, n, i++);
			aSLL = aSLL.next;
		}
		while(bSLL!=null){
			int n = bSLL.data+carry;
			carry = n/10;
			n=n%10;
			SinglyLinkedList.addANode(sumSLL, n, i++);
			bSLL = bSLL.next;
		}
		return sumSLL;
	}
}
