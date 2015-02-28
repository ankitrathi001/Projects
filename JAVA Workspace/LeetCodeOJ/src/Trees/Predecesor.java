package Trees;

public class Predecesor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNodeWithParent head = new TreeNodeWithParent(7);
		head.left = new TreeNodeWithParent(4);
		head.right = new TreeNodeWithParent(10);
		head.left.left = new TreeNodeWithParent(2);
		head.left.left.left = new TreeNodeWithParent(1);
		head.left.left.right = new TreeNodeWithParent(3);
		head.left.right = new TreeNodeWithParent(5);
		head.right.right = new TreeNodeWithParent(11);
		head.right.left = new TreeNodeWithParent(8);
		head.left.left.left.parent = head.left.left;
		head.left.left.right.parent = head.left.left;
		head.left.left.parent = head.left;
		head.left.right.parent = head.left;
		head.left.parent = head;
		head.right.parent = head;
		head.right.left.parent = head.right;
		head.right.right.parent = head.right;
		/*
		 * 			7
		 * 		   / \
		 * 		  /   \
		 *       4     10
		 *      / \    / \
		 *	   2   5  8   11
		 *	  1 3  
		 * 
		 */
		TreeNodeWithParent a = head.right.left;
		System.out.print(predecesor(head, a).val);
	}
	public static TreeNodeWithParent predecesor(TreeNodeWithParent head, TreeNodeWithParent a){
		if(head==null || a==null)
			return null;
		if(a.left!=null){
			TreeNodeWithParent t = a.left;
			while(t.right!=null)
				t = t.right;
			return t;
		}
		TreeNodeWithParent x = a;
		TreeNodeWithParent y = a.parent;
		while (y!=null && x==y.left){
            x = y;
            y = y.parent;
        }
		return y;
	}
}
