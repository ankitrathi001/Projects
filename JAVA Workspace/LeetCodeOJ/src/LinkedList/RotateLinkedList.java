package LinkedList;

public class RotateLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l = new ListNode(1);
		l.next = new ListNode(2);
		l.next.next = new ListNode(3);
		//l.next.next.next = new ListNode(4);
		//l.next.next.next.next = new ListNode(5);
		dispLL(rotateRight(l, 4));
	}
	public static ListNode rotateRight(ListNode head, int n) {
		if(head==null)
			return null;
		if(n==0)
			return head;
		ListNode temp = head;
		int i = 0;
		n=n%getListSize(head);
		while(i<=n){
			if(temp == null)
				temp = head;
			temp = temp.next;
			i++;
		}
		ListNode temp2 = head;
		while(temp!=null){
			temp=temp.next;
			temp2=temp2.next;
		}
		ListNode temp3 = temp2.next;
		temp2.next=null;
		ListNode temp4 = temp3;
		if(temp4==null)
			return head;
		while(temp4.next!=null)
			temp4=temp4.next;
		temp4.next = head;
        return temp3;
    }
	public static int getListSize(ListNode head){
		int i =0;
		while(head!=null){
			i++;
			head=head.next;
		}
		return i;
	}
	public static void dispLL(ListNode head){
		while(head!=null){
			System.out.print(head.val+" -> ");
			head=head.next;
		}
	}
}
