package LinkedList;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedLists {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode headA = new ListNode(0);
		ListNode headB = new ListNode(2);
		ListNode headC = new ListNode(5);
		headA.next = new ListNode(1);
		headB.next = new ListNode(3);
		headB.next.next = new ListNode(4);
		headB.next.next.next = headC;
		headA.next.next = headC;
		//System.out.println(getIntersectionNode(headA, headB).val);
		System.out.println(getIntersectionNode(null, null));
	}
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		Set<ListNode> s = new HashSet<>();
        while(headA!=null){
        	s.add(headA);
        	headA=headA.next;
        }
        while(headB!=null){
        	if(s.contains(headB))
        		return headB;
        	headB = headB.next;
        }
        return null;
    }
	public static void dispLL(ListNode head){
		while(head!=null){
			System.out.print(head.val+" -> ");
			head=head.next;
		}
	}
}
