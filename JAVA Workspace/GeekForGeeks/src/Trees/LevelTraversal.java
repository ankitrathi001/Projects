package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree bt = new BinaryTree();
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
		bt=BinaryTree.buildATree(bt, array);
		//BinaryTree.inOrderTraversal(bt);
		levelOrderTraversal(bt);
	}
	public static void levelOrderTraversal(BinaryTree bt){
		Queue<BinaryTree> q = new LinkedList<>();
		if(q.isEmpty())
			q.add(bt);
		while(!q.isEmpty()){
			BinaryTree temp = q.remove();
			if(temp.left!=null)
				q.add(temp.left);
			if(temp.right!=null)
				q.add(temp.right);
			System.out.print(temp.data +" ");
		}
	}
}
