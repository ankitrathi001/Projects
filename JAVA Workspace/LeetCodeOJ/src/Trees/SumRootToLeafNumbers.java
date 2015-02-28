package Trees;

public class SumRootToLeafNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//BinaryTree bt = new BinaryTree(4);
		//bt.left = new BinaryTree(9);
		//bt.right = new BinaryTree(0);
		//bt.left.right = new BinaryTree(1);
		BinaryTree bt = new BinaryTree(1);
		bt.left = new BinaryTree(2);
		bt.right = new BinaryTree(3);
		System.out.print(sumNumbers(bt));
	}
	public static int sumNumbers(BinaryTree root) {
		return sumPaths(root,0);
    }
	public static int sumPaths(BinaryTree root, int sum) {
		if(root==null)
			return 0;
		if(root.left==null && root.right==null)
			return sum*10+root.data;
		sum = sum*10+root.data;
		int sum1=0;int sum2=0;
		if(root.left!=null)
			sum1 = sumPaths(root.left, sum);
		if(root.right!=null)
			sum2 = sumPaths(root.right, sum);
		return sum1+sum2;
	}
}
