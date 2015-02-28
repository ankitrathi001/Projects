package Trees;

import java.util.LinkedList;
import java.util.Queue;

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;
	TreeLinkNode(int x) { val = x; }
}
public class PopulatingNextRightPointer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeLinkNode root = new TreeLinkNode(1);
		root.left = new TreeLinkNode(2);
		root.right = new TreeLinkNode(3);
		root.left.left = new TreeLinkNode(4);
		root.left.right = new TreeLinkNode(5);
		root.right.left = new TreeLinkNode(6);
		root.right.right = new TreeLinkNode(7);
		//dispLinkTree(root);
		connect(root);
		dispLinkTree(root);
	}
	public static void connect(TreeLinkNode root) {
        if(root == null)
        	return;
        Queue<TreeLinkNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
        	Queue<TreeLinkNode> temp = new LinkedList<>();
        	TreeLinkNode x = q.remove();
        	if(x.left!=null)
        		temp.add(x.left);
    		if(x.right!=null)
        		temp.add(x.right);
        	while(!q.isEmpty()){
        		TreeLinkNode y = q.remove();
        		x.next = y;
        		x = x.next;
        		if(y.left!=null)
        		temp.add(y.left);
        		if(y.right!=null)
        		temp.add(y.right);
        	}
        	q=temp;
        }
    }
	public static void dispLinkTree(TreeLinkNode root){
		while(root!=null){
			TreeLinkNode x = root;
			while(x!=null){
				System.out.print(x.val+"-->");
				x=x.next;
			}
			System.out.println("null");
			root=root.left;
		}
	}
}
