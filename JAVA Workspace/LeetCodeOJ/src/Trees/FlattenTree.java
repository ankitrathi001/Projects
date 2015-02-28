package Trees;

import java.util.Stack;

public class FlattenTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode t = new TreeNode(1);
		t.left = new TreeNode(2);
		t.left.left = new TreeNode(3);
		t.left.right = new TreeNode(4);
		t.right = new TreeNode(5);
		t.right.right = new TreeNode(6);
		flatten(t);
		while(t!=null){
			System.out.println(t.val);
			t=t.right;
		}
	}
	public static void flatten(TreeNode root) {
        if(root==null)
        	return;
        Stack<TreeNode> s = new Stack<>();
        while(root!=null){
        	if(root.right!=null)
        		s.push(root.right);
        	if(root.left!=null){
        		root.right = root.left;
        		root.left=null;
        	}
        	else
        	{
        		if(!s.isEmpty())
        			root.right = s.pop();
        	}
        	root=root.right;
        }
    }
}
