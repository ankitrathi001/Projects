package TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class Q4_LLForAllNodesAtEachDepth {

	/**
	 * @param args
	 * Given a binary search tree, design an algorithm which creates a linked list of all 
	 * the nodes at each depth (eg, if you have a tree with depth D, you’ll have D linked lists).
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
		ArrayList<LinkedList<BinaryTree>> res = llForAllNodesAtEachDepth(bt);
		displayLists(res);
	}
	public static ArrayList<LinkedList<BinaryTree>> llForAllNodesAtEachDepth(BinaryTree bt){
		ArrayList<LinkedList<BinaryTree>> res = new ArrayList<LinkedList<BinaryTree>>();
		return createLlForAllNodesAtEachDepth(res,bt, 0);
	}
	public static ArrayList<LinkedList<BinaryTree>> createLlForAllNodesAtEachDepth(ArrayList<LinkedList<BinaryTree>> res, BinaryTree bt, int level){
		if(bt==null)
			return null;
		if(level==res.size()){
			LinkedList<BinaryTree> list = new LinkedList<BinaryTree>();
			list.add(bt);
			res.add(list);
			createLlForAllNodesAtEachDepth(res,bt.left,level+1);
			createLlForAllNodesAtEachDepth(res,bt.right,level+1);
		}
		else{
			res.get(level).add(bt);
			createLlForAllNodesAtEachDepth(res,bt.left,level+1);
			createLlForAllNodesAtEachDepth(res,bt.right,level+1);
		}
		return res;
	}
	public static void displayLists(ArrayList<LinkedList<BinaryTree>> res){
		for(int i=0;i<res.size();i++){
			for(int j=0;j<res.get(i).size();j++){
				System.out.print(res.get(i).get(j).data+" -> ");
			}
			System.out.println();
		}
	}
}
