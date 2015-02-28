package TreesAndGraphs;

public class Q6_CommonAncestor {

	/**
	 * @param args
	 * Design an algorithm and write code to find the first common ancestor of two nodes 
	 * in a binary tree. Avoid storing additional nodes in a data structure. 
	 * NOTE: This is not necessarily a binary search tree.
	 */
	public static void main(String[] args) {
		int[] array = {2,5,1,3,11,7,8,9,4,10,6};
		/*
		 * 					2
		 * 				   / \
		 *                /   \
		 *               /     \
		 *              5       1
		 *             / \     / \
		 *            /   \   /   \
		 *           3    11 7     8
		 *          / \   / \
		 *         9   4 10  6 
		 * 
		 * */
		BinaryTree bt=null;
		bt=BinaryTree.buildATree(bt, array);
		System.out.println(commonAncestor(bt, 9, 4).data);
	}
	public static BinaryTree commonAncestor(BinaryTree bt, int a, int b){
		if(bt==null)
			return null;
		if(bt.data==a || bt.data==b)
			return bt;
		BinaryTree left = commonAncestor(bt.left, a, b);
		BinaryTree right = commonAncestor(bt.right, a, b);
		if(left!=null && right!=null)
			return bt;
		else if(left!=null)
			return left;
		else if(right!=null)
			return right;
		else return null;
	}
}
