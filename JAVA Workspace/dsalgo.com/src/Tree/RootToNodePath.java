package Tree;

public class RootToNodePath {

	/**
	 * @param args
	 * Given a binary tree and one of its nodes, find the path from root to 
	 * the given node
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
		System.out.println(rootToNodePath(bt, 10));
	}
	public static boolean rootToNodePath(BinaryTree bt, int n){
		if(bt==null)
			return false;
		if(bt.data==n || rootToNodePath(bt.left, n) || rootToNodePath(bt.right, n)){
			System.out.print(bt.data+"<--");
			return true;
		}
		return false;
	}
}
