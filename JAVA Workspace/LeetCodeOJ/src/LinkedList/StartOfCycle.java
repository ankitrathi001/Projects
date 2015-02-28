package LinkedList;

public class StartOfCycle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	public static ListNode detectCycle(ListNode head) {
        if(head==null)
        	return null;
        if(head.next==null)
        	return null;
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while(fast!=slow){
        	if(fast==null || fast.next==null)
        		return null;
        	slow = slow.next;
        	fast = fast.next.next;
        }
        slow = head;
        while(slow!=fast){
			slow = slow.next;
			fast = fast.next;
		}
        return slow;
    }
}
