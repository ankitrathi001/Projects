package Trees;

public class CheckBalanced {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode t = new TreeNode(1);
		t.left = new TreeNode(2);
		t.left.left = new TreeNode(3);
		t.left.left.left = new TreeNode(4);
		t.right = new TreeNode(5);
		t.right.right = new TreeNode(6);
	}
	public static boolean isBalanced(TreeNode root){
		if(root==null)
			return false;
		if(getHeight(root)==-1)
			return false;
		return true;
	}
	public static int getHeight(TreeNode root){
		if(root==null)
			return 0;
		int left = getHeight(root.left);
		int right = getHeight(root.right);
		if (left == -1 || right == -1)
			return -1;
		if (Math.abs(left - right) > 1)
			return -1;
		return Math.max(left, right) + 1;
 
	}
}
