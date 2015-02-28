package Trees;

public class BFSRecursive {

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
		recursiveBFS(head);
	}
	public static void recursiveBFS(TreeNode head){
		return;
		//Not Possible
	}
}
