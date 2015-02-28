package LinkedList;

public class ReverseMToN {

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
		l.next.next.next.next.next = new ListNode(6);
		l.next.next.next.next.next.next = new ListNode(7);
		dispLL(reverseBetween(l, 2, 4));
	}
	public static ListNode reverseBetween(ListNode head, int m, int n) {
		if(head==null)
			return null;
		if(m>n)
			return head;
        ListNode temp = head;
        for(int i=0;i<m-2;i++){
        	temp = temp.next;
        	if(temp==null)
        		return head;
        }
        ListNode head1 = temp.next;
        ListNode temp2 = head1;
        for(int i=0;i<n-m;i++){
        	if(temp2==null)
        		return head;
        	temp2 = temp2.next;
        }
        ListNode tail = temp2.next;
        temp2.next=null;
        temp.next = reverseLL(head1);
        while(temp.next!=null)
        	temp=temp.next;
        temp.next = tail;
        return head;
    }
	public static ListNode reverseLL(ListNode head){
		if(head==null)
			return null;
		if(head.next==null)
			return head;
		ListNode temp = head;
		while(temp.next.next!=null){
			temp=temp.next;
		}
		ListNode temp2 = temp.next;
		temp.next = null;
		temp2.next = reverseLL(head);
		return temp2;
	}
	public static void dispLL(ListNode head){
		while(head!=null){
			System.out.print(head.val+" -> ");
			head=head.next;
		}
	}
}
