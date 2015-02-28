package Trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversalIterative {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(2);
		System.out.println(preorderTraversal(root));
	}
	public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> l = new LinkedList<>();
        Stack<TreeNode> s = new Stack<>();
        if(root==null)
        	return l;
        s.add(root);
        while(!s.empty()){
            TreeNode p = s.pop();
        	l.add(p.val);
        	if(p.right!=null)
            s.push(p.right);
        	if(p.left!=null)
            s.push(p.left);
        }
        return l;
    }
}
