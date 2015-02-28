package Trees;

public class CommonAncestorInBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode head = new TreeNode(7);
		head.left = new TreeNode(4);
		head.right = new TreeNode(10);
		head.left.left = new TreeNode(2);
		head.left.left.left = new TreeNode(1);
		head.left.left.right = new TreeNode(3);
		head.left.right = new TreeNode(5);
		head.right.right = new TreeNode(11);
		head.right.left = new TreeNode(8);
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
		TreeNode a = head.left.right;
		TreeNode b = head.left.left.left;
		System.out.println(commonAncestorInBST(head, a, b).val);
	}
	public static TreeNode commonAncestorInBST(TreeNode head, TreeNode a, TreeNode b){
		if(head==null)
			return null;
		if(a.val==head.val || b.val==head.val)
			return head;
		TreeNode min = null;
		TreeNode max = null;
		if(a.val<b.val){
			min = a;
			max = b;
		}
		else{
			max = a;
			min = b;
		}
		if(min.val<head.val && max.val>head.val)
			return head;
		else if(min.val<head.val && max.val<head.val)
			return commonAncestorInBST(head.left, a, b);
		else
			return commonAncestorInBST(head.right, a, b);
	}
}
