package LinkedList;

public class AddTwoNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(5);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		dispLL(addTwoNumbers(l1, l2));
		//dispLL(addTwoNumbers(null, null));
	}
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode res = new ListNode(0);
        ListNode res2 = res;
        while(l1!=null && l2!=null){
        	int s = l1.val+l2.val+carry;
        	carry = s/10;
        	res.next = new ListNode(s%10);
        	l1 = l1.next;
        	l2 = l2.next;
        	res = res.next;
        }
        while(l1!=null){
        	int s = l1.val+carry;
        	carry = s/10;
        	res.next = new ListNode(s%10);
        	l1 = l1.next;
        	res = res.next;
        }
        while(l2!=null){
        	int s = l2.val+carry;
        	carry = s/10;
        	res.next = new ListNode(s%10);
        	l2 = l2.next;
        	res = res.next;
        }
        if(carry!=0)
        	res.next = new ListNode(carry);
        return res2.next;
    }
	public static void dispLL(ListNode head){
		while(head!=null){
			System.out.print(head.val+" -> ");
			head=head.next;
		}
	}
}
