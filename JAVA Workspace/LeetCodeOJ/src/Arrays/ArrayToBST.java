package Arrays;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class ArrayToBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1,2,3,4,5,6,7,8,9,10,11};
		System.out.print(levelOrder(sortedArrayToBST(num)));
	}
	public static TreeNode sortedArrayToBST(int[] num) {
		return arrayToBST(num, 0, num.length);
    }
	public static TreeNode arrayToBST(int[] num, int i, int j){
		int mid = (i+j)/2;
		if(mid>j-1)
			return null;
		TreeNode head = new TreeNode(num[mid]);
		head.left = arrayToBST(num, i, mid);
		head.right = arrayToBST(num, mid+1, j);
		return head;
		
	}
	public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> l = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(q.isEmpty())
        	q.add(root);
        while(!q.isEmpty()){
        	List<Integer> temp = new LinkedList<>();
        	Queue<TreeNode> y = new LinkedList<>();
        	while(!q.isEmpty()){
        		TreeNode x = q.remove();
        		temp.add(x.val);
        		if(x.left!=null)
        			y.add(x.left);
        		if(x.right!=null)
        			y.add(x.right);
        	}
        	l.add(temp);
        	q=y;
        }
        return l;
    }
}
