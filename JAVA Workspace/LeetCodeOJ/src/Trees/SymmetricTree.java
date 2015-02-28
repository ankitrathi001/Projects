package Trees;


public class SymmetricTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] array = {1,2,2,3,4,4,3};
		/*
		 * 					1
		 * 				   / \
		 *                /   \
		 *               /     \
		 *              2       2
		 *             / \     / \
		 *            /   \   /   \
		 *           3     4 4     3
		 * 
		 * */
		//int[] array = {1,2};
		BinaryTree bt=new BinaryTree();
		bt.data=1;
		bt.left = new BinaryTree(2);
		bt.right = new BinaryTree(2);
		bt.left.right = new BinaryTree(3);
		bt.right.right = new BinaryTree(3);
		//bt=BinaryTree.buildATree(bt, array);
		System.out.print(isSymmetric(bt));
		BinaryTree.inOrderTraversal(bt);
	}
	public static boolean isSymmetric(BinaryTree root){
		if(root==null)
			return true;
		return isSymmetricLR(root.left,root.right);
	}
	public static boolean isSymmetricLR(BinaryTree left, BinaryTree right){
		if(left == null && right == null)
			return true;
		if(left!=null && right!=null)
			return (left.data == right.data) &&
					(isSymmetricLR(left.left, right.right)) &&
					(isSymmetricLR(left.right, right.left));
		return false;
	}
}
