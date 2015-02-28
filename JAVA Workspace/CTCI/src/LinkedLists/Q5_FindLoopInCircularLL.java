package LinkedLists;

public class Q5_FindLoopInCircularLL {

	/**
	 * @param args
	 * Given a circular linked list, implement an algorithm which returns node 
	 * at the beginning of the loop.
	 */
	public static void main(String[] args) {
		SinglyLinkedList SLL = new SinglyLinkedList(0);
		SinglyLinkedList node = SLL;
		int[] array = {2,5,1,3,11,7,13,8,9,4,10,6};
		for(int i=0;i<array.length;i++){
			SinglyLinkedList temp = new SinglyLinkedList(array[i]);
			node.next = temp;
			node = node.next;
		}
		SinglyLinkedList node2 = SLL;
		for(int i=0;i<5;i++)
			node2 = node2.next;
		node.next = node2;
		//SinglyLinkedList.displayLL(SLL);
		System.out.println(findStartOfLoop(SLL));
	}
	public static int findStartOfLoop(SinglyLinkedList SLL){
		SinglyLinkedList node1 = SLL.next;
		SinglyLinkedList node2 = SLL.next.next;
		while(node1!=node2 && node1.next!=null && node2.next!=null){
			node1 = node1.next;
			node2 = node2.next.next;
		}
		if(node1.next==null || node2.next==null)
			return 0;
		node1 = SLL;
		while(node1!=node2){
			node1 = node1.next;
			node2 = node2.next;
		}
		return node1.data;
	}
}
