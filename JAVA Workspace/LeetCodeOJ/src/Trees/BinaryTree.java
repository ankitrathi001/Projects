package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

	int data;
	BinaryTree left=null;
	BinaryTree right=null;
	
	public BinaryTree(){}
	public BinaryTree(int data){ this.data = data;}
	
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
		BinaryTree bt=null;
		bt=buildATree(bt, array);
		inOrderTraversal(bt);
		System.out.println();
		System.out.println(findCommonAncestor(bt, 9, 4).data);
		System.out.println(searchData(bt, 11));
		System.out.println(searchData(bt, 13));
		tracePath(bt, 8);
	}
	public static BinaryTree buildATree(BinaryTree bt, int[] data){
		Queue<BinaryTree> q = new LinkedList<BinaryTree>();
		int i=1;
		if(data.length>0){
			bt = new BinaryTree(data[0]);
			q.add(bt);
			while(!q.isEmpty() && i<data.length){
				BinaryTree temp = q.remove();
				if(i<data.length){
					temp.left=new BinaryTree(data[i]);
					q.add(temp.left);
					i++;
				}
				if(i<data.length){
					temp.right=new BinaryTree(data[i]);
					q.add(temp.right);
					i++;
				}
			}
		}
		return bt;
	}
	public static BinaryTree findCommonAncestor(BinaryTree bt, int a, int b){
		if(bt==null)
			return null;
		if(bt.data==a || bt.data==b){
			return bt;
		}
		BinaryTree l = findCommonAncestor(bt.left,a,b);
		BinaryTree r = findCommonAncestor(bt.right,a,b);
		
		if(l!=null && r!=null)
			return bt;
		if(l!=null)
			return l;
		else if(r!=null)
			return r;
		else return null;
	}
	public static boolean tracePath(BinaryTree bt, int data){
		if(bt==null)
			return false;
		if(bt.data == data){
			System.out.print(bt.data+"--");
			return true;
		}
		if(tracePath(bt.left, data)){
			System.out.print(bt.data+"--");
			return true;
		}
		else if(tracePath(bt.right, data)){
			System.out.print(bt.data+"--");
			return true;
		}
		else return false;
	}
	public static boolean searchData(BinaryTree bt, int data){
		if(bt==null)
			return false;
		if(bt.data == data)
			return true;
		if(searchData(bt.left, data))
			return true;
		else if(searchData(bt.right, data))
			return true;
		else return false;
	}
	public static void inOrderTraversal(BinaryTree bt){
		if(bt==null)
			return;
		inOrderTraversal(bt.left);
		System.out.print(bt.data+" ");
		inOrderTraversal(bt.right);
	}
	public static void preOrderTraversal(BinaryTree bt){
		if(bt==null)
			return;
		System.out.print(bt.data+" ");
		preOrderTraversal(bt.left);
		preOrderTraversal(bt.right);
	}
	public static void postOrderTraversal(BinaryTree bt){
		if(bt==null)
			return;
		postOrderTraversal(bt.left);
		postOrderTraversal(bt.right);
		System.out.print(bt.data+" ");
	}
}
