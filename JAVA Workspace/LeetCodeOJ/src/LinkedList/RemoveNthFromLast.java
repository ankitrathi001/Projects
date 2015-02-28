package LinkedList;

public class RemoveNthFromLast {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l = new ListNode(1);
		l.next = new ListNode(2);
		l.next.next = new ListNode(3);
		l.next.next.next = new ListNode(4);
		l.next.next.next.next = new ListNode(5);
		//l.next.next.next.next.next = new ListNode(6);
		//l.next.next.next.next.next.next = new ListNode(7);
		dispLL(removeNthFromEnd(l, 5));
	}
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if(head==null)
			return null;
		if(n==0)
			return head;
		ListNode temp = head;
		ListNode temp2 = head;
		for(int i=0;i<n;i++){
			if(temp==null)
				return head;
			temp=temp.next;
		}
		if(temp==null)
			return head.next;
		while(temp.next!=null){
			temp = temp.next;
			temp2=temp2.next;
		}
		temp2.next = temp2.next.next;
		return head;
    }
	public static void dispLL(ListNode head){
		while(head!=null){
			System.out.print(head.val+" -> ");
			head=head.next;
		}
	}
}
