package LinkedList;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
     }
 }
public class SwapNodesInPairs {

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
		//dispLL(l);
		dispLL(swapPairs(l));
	}
	public static ListNode swapPairs(ListNode head) {
		if(head==null)
			return null;
		if(head.next==null)
			return head;
		ListNode temp = head;
		while(temp!=null){
			int x =temp.val;
			if(temp.next!=null){
				temp.val = temp.next.val;
				temp.next.val = x;
				temp = temp.next.next;
			}
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
