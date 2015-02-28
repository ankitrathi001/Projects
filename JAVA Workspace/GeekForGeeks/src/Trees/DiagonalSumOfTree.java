package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class DiagonalSumOfTree {

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
		 * 2+5+3+9
		 * 4+10+11+7+1
		 * 6+8
		 * */
		BinaryTree bt=null;
		bt=BinaryTree.buildATree(bt, array);
		diagonalSum(bt);
	}
	public static void diagonalSum(BinaryTree bt){
		Queue<BinaryTree> q = new LinkedList<>();
		if(q.isEmpty())
			q.add(bt);
		while(!q.isEmpty()){
			int sum=0;
			Queue<BinaryTree> tempq = new LinkedList<>();
			BinaryTree temp = new BinaryTree();
			while(!q.isEmpty()){
				temp = q.remove();
				while(temp!=null){
					sum+=temp.data;
					if(temp.right!=null)
						tempq.add(temp.right);
					temp=temp.left;
				}
				
			}
			q=tempq;
			System.out.println(sum);
		}
	}
}
