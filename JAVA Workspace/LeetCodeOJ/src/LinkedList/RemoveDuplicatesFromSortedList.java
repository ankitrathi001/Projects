package LinkedList;

public class RemoveDuplicatesFromSortedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l = new ListNode(1);
		l.next = new ListNode(1);
		l.next.next = new ListNode(2);
		l.next.next.next = new ListNode(3);
		l.next.next.next.next = new ListNode(3);
		//l.next.next.next.next.next = new ListNode(6);
		//l.next.next.next.next.next.next = new ListNode(7);
		dispLL(deleteDuplicates(l));
	}
	public static ListNode deleteDuplicates(ListNode head) {
        if(head==null)
        	return null;
        ListNode temp = head;
        while(temp.next!=null){
        	if(temp.val==temp.next.val)
        		temp.next=temp.next.next;
        	else
        		temp=temp.next;
        }
        return head;
    }
	public static void dispLL(ListNode head){
		while(head!=null){
			System.out.print(head.val+" -> ");
			head=head.next;
		}
	}
}
