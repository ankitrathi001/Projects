package LinkedList;

public class FindMiddleNode {

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
		System.out.println(midNode(l).val);
	}
	public static ListNode midNode(ListNode head){
		if(head==null)
			return null;
		if(head.next==null)
			return head;
		ListNode head2 = head;
		while(head2!=null){
			if(head2.next!=null){
				head2=head2.next.next;
				if(head2!=null)
					head=head.next;
			}
			else
				head2=head2.next;
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
