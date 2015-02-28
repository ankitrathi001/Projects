package LinkedLists;
	
public class Q1_RemoveDuplicates {

	/**
	 * @param args
	 * Write code to remove duplicates from an unsorted linked list.
	 * How would you solve this problem if a temporary buffer is not allowed?
	 */
	public static void main(String[] args) {
		int[] array = {8,8,1,3,5,7,13,13,9,5,15,15};
		SinglyLinkedList SLL = new SinglyLinkedList(8);
		for(int i=0;i<array.length;i++){
			SinglyLinkedList.addANode(SLL, array[i], i+1);
		}
		SLL = removeDuplicates(SLL);
		SinglyLinkedList.displayLL(SLL);
	}
	public static SinglyLinkedList removeDuplicates(SinglyLinkedList SLL){
		if(SLL == null)
			return null;
		SinglyLinkedList previous = SLL;
		SinglyLinkedList current = previous.next;
		while(current!=null){
			SinglyLinkedList runner = SLL;
			while(runner!=current){
				if(runner.data==current.data){
					SinglyLinkedList temp = current.next;
					previous.next=temp;
					current=temp;
					break;
				}
				runner=runner.next;
			}
			if (runner == current) {
				previous = current;
				current = current.next;
			}
		}
		return SLL;
	}
}
