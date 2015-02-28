package TreesAndGraphs;

public class Q1_CheckIfTreeIsBalanced {

	/**
	 * @param args
	 * Implement a function to check if a tree is balanced. 
	 * For the purposes of this question, a balanced tree is defined to be a tree such that 
	 * no two leaf nodes differ in distance from the root by more than one.
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
		System.out.print(checkBalanced(bt));
	}
	public static boolean checkBalanced(BinaryTree bt){
		System.out.println("Min Height: "+minHeight(bt)+" Max Height: "+maxHeight(bt));
		return (maxHeight(bt) - minHeight(bt) <= 1);
	}
	public static int minHeight(BinaryTree bt){
		if(bt==null)
			return 0;
		return 1+Math.min(minHeight(bt.left), minHeight(bt.right));
	}
	public static int maxHeight(BinaryTree bt){
		if(bt==null)
			return 0;
		return 1+Math.max(maxHeight(bt.left), maxHeight(bt.right));
	}
}
