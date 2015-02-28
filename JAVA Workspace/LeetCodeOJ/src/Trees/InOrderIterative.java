package Trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class InOrderIterative {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(2);
		System.out.println(inOrderTraversal(root));
	}
	public static List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> l = new LinkedList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode p = root;
        while(!s.empty() || p != null){
            if(p != null){
                s.push(p);
                p = p.left;
            }else{
                TreeNode t = s.pop();
                l.add(t.val);
                p = t.right;
            }
        }
        return l;
    }

}
