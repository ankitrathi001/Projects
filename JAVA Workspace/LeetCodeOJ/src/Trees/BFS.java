package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

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
		bfs(head);
	}
	public static void bfs(TreeNode head){
		if(head==null)
			return;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(head);
		while(!q.isEmpty()){
			TreeNode x = q.remove();
			System.out.print(x.val+" ");
			if(x.left!=null)
				q.add(x.left);
			if(x.right!=null)
				q.add(x.right);
		}
	}
}
