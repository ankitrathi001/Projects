package LinkedList;

public class SortLL {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l = new ListNode(2);
		l.next = new ListNode(5);
		l.next.next = new ListNode(1);
		l.next.next.next = new ListNode(3);
		l.next.next.next.next = new ListNode(4);
		dispLL(sortList(l));
	}
	public static ListNode sortList(ListNode head){
		if(head==null)
			return null;
		if(head.next==null)
			return head;
		ListNode mid = midNode(head);
		ListNode left = mid.next;
		mid.next=null;
		ListNode right = head;
		left = sortList(left);
		right = sortList(right);
		return merge(left, right);
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
	public static ListNode merge(ListNode left, ListNode right){
		ListNode head = new ListNode(0);
		ListNode temp = head;
		while(left!=null && right!=null){
			if(left.val<right.val){
				head.next = new ListNode(left.val);
				head=head.next;
				left=left.next;
			}
			else{
				head.next = new ListNode(right.val);
				head=head.next;
				right=right.next;
			}
		}
		while(left!=null){
			head.next = new ListNode(left.val);
			head=head.next;
			left=left.next;
		}
		while(right!=null){
			head.next = new ListNode(right.val);
			head=head.next;
			right=right.next;
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
