package LinkedList;


public class GroupReverse {

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
		l.next.next.next.next.next = new ListNode(6);
		l.next.next.next.next.next.next = new ListNode(7);
		dispLL(l);
		System.out.println();
		dispLL(reverseKGroup(l, 5));
		//System.out.println();
		//dispLL(reverseLL(l));
	}
	public static ListNode reverseKGroup(ListNode head, int k) {
        if(head==null)
        	return null;
        if(head.next==null)
        	return head;
        ListNode temp = head;
        ListNode res = new ListNode(0);
        ListNode res2 = res;
        while(temp!=null){
        	for(int i=0;i<k-1;i++){
        		if(temp==null)
        			break;
        		temp=temp.next;
        	}
        	if(temp!=null){
	        	ListNode temp2 = temp.next;
	        	temp.next=null;
	        	temp=temp2;
	        	res2.next = reverseLL(head);
	        	while(res2.next!=null)
	        		res2=res2.next;
	        	//System.out.println();
	        	head=temp;
        	}
        	res2.next = head;
        }
		return res.next;
    }
	public static ListNode reverseLL(ListNode head){
		if(head==null)
			return null;
		if(head.next==null)
			return head;
		ListNode temp = head;
		while(temp.next.next!=null){
			temp=temp.next;
		}
		ListNode temp2 = temp.next;
		temp.next = null;
		temp2.next = reverseLL(head);
		return temp2;
	}
	public static void dispLL(ListNode head){
		while(head!=null){
			System.out.print(head.val+" -> ");
			head=head.next;
		}
	}
}
