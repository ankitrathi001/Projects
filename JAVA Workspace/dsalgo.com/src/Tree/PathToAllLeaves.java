package Tree;

import java.util.ArrayList;
import java.util.List;

public class PathToAllLeaves {

	/**
	 * @param args
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
		BinaryTree root = bt;
		ArrayList<List<BinaryTree>> A = new ArrayList<List<BinaryTree>>();
		rootToLeavesPath(bt,root,A);
		System.out.println(A);
	}
	public static ArrayList<List<BinaryTree>> rootToLeavesPath(BinaryTree bt, BinaryTree root, ArrayList<List<BinaryTree>> A){
		if(root==null)
			return null;
		if(root.left==null && root.right==null){
			rootToNodePath(bt, root);
			System.out.println("start");
		}
		rootToLeavesPath(bt, root.left, A);
		rootToLeavesPath(bt, root.right, A);
		return A;
	}
	public static boolean rootToNodePath(BinaryTree bt, BinaryTree node){
		if(bt==null)
			return false;
		if(bt==node || rootToNodePath(bt.left, node) || rootToNodePath(bt.right, node)){
			System.out.print(bt.data+"<--");
			return true;
		}
		return false;
	}
}
