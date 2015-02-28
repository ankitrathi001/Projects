package Trees;

public class MaximumDepth {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		//int[] array = {2,5};
		BinaryTree bt=null;
		bt=BinaryTree.buildATree(bt, array);
		System.out.println(maxDepth(bt));
		System.out.println(minDepth(bt));
	}
	public static int maxDepth(BinaryTree root){
		if(root==null)
			return 0;
		return Math.max(maxDepth(root.left)+1, maxDepth(root.right)+1);
	}
	public static int minDepth(BinaryTree root){
		if(root==null)
			return 0;
		int l = minDepth(root.left)+1;
		int r = minDepth(root.right)+1;
		if(l==1)
			return r;
		if(r==1)
			return l;
		else return Math.min(l, r);
	}
}
