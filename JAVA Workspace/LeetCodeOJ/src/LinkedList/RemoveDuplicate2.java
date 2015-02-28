package LinkedList;

public class RemoveDuplicate2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l = new ListNode(1);
		l.next = new ListNode(2);
		l.next.next = new ListNode(3);
		l.next.next.next = new ListNode(3);
		l.next.next.next.next = new ListNode(4);
		l.next.next.next.next.next = new ListNode(4);
		l.next.next.next.next.next.next = new ListNode(6);
		dispLL(l);
		System.out.println();
		dispLL(deleteDuplicates(l));
	}
	public static ListNode deleteDuplicates(ListNode head) {
		if(head==null)
			return null;
		ListNode temp = head;
		ListNode temp2 = new ListNode(0);
		ListNode temp3 = temp2;
		int x;
		while(temp.next!=null){
			if(temp.val==temp.next.val){
				x = temp.val;
				//System.out.println(x);
				while(temp!=null && temp.val==x){
					temp=temp.next;
				}
				if(temp==null)
					break;
			}
			else{
				temp2.next=temp;
				temp=temp.next;
				temp2=temp2.next;
				temp2.next=null;
			}
		}
		temp2.next=temp;
		return temp3.next;
    }
	public static void dispLL(ListNode head){
		while(head!=null){
			System.out.print(head.val+" -> ");
			head=head.next;
		}
	}
}
