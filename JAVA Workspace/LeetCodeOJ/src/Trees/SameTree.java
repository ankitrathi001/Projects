package Trees;

public class SameTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array1 = {2,5,1,3,11,7,8,9,4,10,6};
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
		BinaryTree bt1=null;
		bt1=BinaryTree.buildATree(bt1, array1);
		int[] array2 = {2,5,1,3,11,7,8,9,4,10,6};
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
		BinaryTree bt2=null;
		bt2=BinaryTree.buildATree(bt2, array2);
		System.out.println(isSameTree(bt1, bt2));
	}
	public static boolean isSameTree(BinaryTree p, BinaryTree q){
		if((p==null && q!=null) || (p!=null && q==null))
			return false;
		else if(p==null && q==null)
			return true;
		else{
			if((p.data == q.data) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right))
				return true;
			else
				return false;
		}
	}
}
