package LinkedList;

public class Partition {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l = new ListNode(1);
		l.next = new ListNode(4);
		l.next.next = new ListNode(3);
		l.next.next.next = new ListNode(2);
		l.next.next.next.next = new ListNode(5);
		l.next.next.next.next.next = new ListNode(2);
		dispLL(partition(l, 2));
	}
	public static ListNode partition(ListNode head, int x) {
        if(head==null)
        	return null;
        ListNode head1 = new ListNode(0);
        ListNode head2 = new ListNode(0);
        ListNode head3 = head2;
        ListNode head4 = head1;
        while(head!=null){
        	if(head.val<x){
        		head1.next = head;
        		head1 = head1.next;
        	}
        	else{
        		head2.next = head;
        		head2 = head2.next;
        	}
        	head = head.next;
        }
        head2.next = null;
        head1.next = head3.next;
		return head4.next;
    }
	public static void dispLL(ListNode head){
		while(head!=null){
			System.out.print(head.val+" -> ");
			head=head.next;
		}
	}
}
