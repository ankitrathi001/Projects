package LinkedLists;

public class SinglyLinkedList {
	int data;
	SinglyLinkedList next=null;
	public SinglyLinkedList(int data) {this.data=data;}
	
	public static void main(String[] args) {
		int[] array = {2,5,1,3,11,7,13,8,9,4,10,6};
		//int[] array = {2};
		SinglyLinkedList SLL = new SinglyLinkedList(0);
		for(int i=0;i<array.length;i++){
			addANode(SLL, array[i], i+1);
		}
		addANode(SLL, 5, 1);
		addANode(SLL, 7, 3);
		displayLL(SLL);
		deleteANodeAtI(SLL, 2);
		displayLL(SLL);
		//deleteANodeWithData(SLL, 7);
		deleteNodesWithData(SLL, 5);
		displayLL(SLL);
		reverseDisplayLL(SLL);
	}
	//Will add a new node at the end if the position is greater than the size of LL.
	//Will add a new node at the beginning if the position is less than the size of LL.
	public static SinglyLinkedList addANode(SinglyLinkedList SLL, int data, int pos){
		for(int i=1;SLL.next!=null && i<pos;i++)
			SLL=SLL.next;
		SinglyLinkedList node = new SinglyLinkedList(data);
		node.next = SLL.next;
		SLL.next = node;
		return SLL;
	}
	public static SinglyLinkedList deleteANodeAtI(SinglyLinkedList SLL, int pos){
		//pos starts from 1
		for(int i=1;SLL.next!=null && i<pos;i++)
			SLL = SLL.next;
		if(SLL.next!=null)
			SLL.next = SLL.next.next;
		return SLL;
	}
	public static SinglyLinkedList deleteANodeWithData(SinglyLinkedList SLL, int data){
		while(SLL.next!=null && SLL.next.data!=data){
			SLL = SLL.next;
		}
		if(SLL.next!=null)
			SLL.next = SLL.next.next;
		return SLL;
	}
	public static SinglyLinkedList deleteNodesWithData(SinglyLinkedList SLL, int data){
		while(SLL.next!=null){
			if(SLL.next.data==data)
				SLL.next = SLL.next.next;
			SLL = SLL.next;
		}
		return SLL;
	}
	public static void displayLL(SinglyLinkedList SLL){
		while(SLL!=null){
			System.out.print(SLL.data+" -> ");
			SLL = SLL.next;
		}
		System.out.println("null");
	}
	public static void reverseDisplayLL(SinglyLinkedList SLL){
		if(SLL==null)
			System.out.print("null");
		else{
			reverseDisplayLL(SLL.next);
			System.out.print(" <- " + SLL.data);
		}
	}
	public static int sizeOfLL(SinglyLinkedList SLL){
		int count = 0;
		while(SLL.next!=null){
			count++;
			SLL = SLL.next;
		}
		return count;
	}
}
