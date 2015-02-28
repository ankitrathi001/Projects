package LinkedList;

public class Merge {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(1);
		l1.next = new ListNode(5);
		l1.next.next = new ListNode(8);
		l1.next.next.next = new ListNode(9);
		l1.next.next.next.next = new ListNode(10);
		l2.next = new ListNode(5);
		l2.next.next = new ListNode(6);
		l2.next.next.next = new ListNode(7);
		l2.next.next.next.next = new ListNode(8);
		dispLL(mergeTwoLists(l1, l2));
		//dispLL(mergeTwoLists(null,null));
	}
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode temp = head;
		while(l1!=null && l2!=null){
			if(l1.val<l2.val){
				head.next = new ListNode(l1.val);
				head=head.next;
				l1=l1.next;
			}
			else{
				head.next = new ListNode(l2.val);
				head=head.next;
				l2=l2.next;
			}
		}
		while(l1!=null){
			head.next = new ListNode(l1.val);
			head=head.next;
			l1=l1.next;
		}
		while(l2!=null){
			head.next = new ListNode(l2.val);
			head=head.next;
			l2=l2.next;
		}
		return temp.next;
    }
	public static void dispLL(ListNode head){
		while(head!=null){
			System.out.print(head.val+" -> ");
			head=head.next;
		}
	}
}
