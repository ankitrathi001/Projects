package LinkedList;

public class FindCycle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		System.out.println(hasCycle(head));
	}
	public static boolean hasCycle(ListNode head) {
        if(head==null)
        	return false;
        if(head.next==null)
        	return false;
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while(fast!=slow){
        	if(fast==null || fast.next==null)
        		return false;
        	slow = slow.next;
        	fast = fast.next.next;
        }
        return true;
    }
	public static void dispLL(ListNode head){
		while(head!=null){
			System.out.print(head.val+" -> ");
			head=head.next;
		}
	}
}
