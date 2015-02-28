package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class ZigZagTraversal {

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
		zigZagTraversal(llForAllNodesAtEachDepth(bt));
		zigZagDisplay(bt);
	}
	public static void zigZagDisplay(BinaryTree bt){
		Stack<BinaryTree> s = new Stack<>();
		if(s.isEmpty())
			s.push(bt);
		boolean flag = true;
		while(!s.isEmpty()){
			Stack<BinaryTree> temp = new Stack<>();
			while(!s.isEmpty()){
				BinaryTree b = s.pop();
				System.out.print(b.data+" ");
				if(flag){
					if(b.left!=null)
						temp.push(b.left);
					if(b.right!=null)
						temp.push(b.right);
				}
				else{
					if(b.right!=null)
						temp.push(b.right);
					if(b.left!=null)
						temp.push(b.left);
				}
			}
			s=temp;
			flag=!flag;
		}
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
	public static void zigZagTraversal(ArrayList<LinkedList<BinaryTree>> res){
		boolean flag=true;
		for(int i=0;i<res.size();i++){
			LinkedList<BinaryTree> temp = res.get(i);
			if(flag){
				for(int j=0;j<temp.size();j++){
					System.out.print(temp.get(j).data+" -> ");
				}
				flag=false;
			}
			else{
				for(int j=temp.size()-1;j>=0;j--){
					System.out.print(temp.get(j).data+" -> ");
				}
				flag=true;
			}
			System.out.println();
		}
	}
}
