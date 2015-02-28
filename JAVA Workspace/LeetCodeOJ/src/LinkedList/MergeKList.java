package LinkedList;

import java.util.LinkedList;
import java.util.List;

public class MergeKList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(3);
		l1.next = new ListNode(4);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(4);
		ListNode l4 = new ListNode(1);
		List<ListNode> lists = new LinkedList<>();
		lists.add(l1);
		lists.add(l2);
		lists.add(l3);
		lists.add(l4);
		dispLL(mergeKLists(lists));
	}
	public static ListNode mergeKLists(List<ListNode> lists) {
        if(lists==null)
        	return null;
        while(lists.size()>1){
        	ListNode l1 = lists.remove(0);
        	ListNode l2 = lists.remove(0);
        	lists.add(0, mergeTwoLists(l1, l2));
        }
        return lists.get(0);
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
