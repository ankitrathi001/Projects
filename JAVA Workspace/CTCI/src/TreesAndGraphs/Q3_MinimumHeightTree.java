package TreesAndGraphs;

public class Q3_MinimumHeightTree {

	/**
	 * @param args
	 * Given a sorted (increasing order) array, write an algorithm to create a binary 
	 * tree with minimal height.
	 */
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
		Q4_LLForAllNodesAtEachDepth.displayLists(Q4_LLForAllNodesAtEachDepth.llForAllNodesAtEachDepth(createMinHeightBT(a)));
	}
	public static BinaryTree createMinHeightBT(int[] a){
		return addToTree(a, 0, a.length-1);
	}
	public static BinaryTree addToTree(int[] a, int start, int end){
		if(start>end)
			return null;
		int mid = (start+end)/2;
		BinaryTree bt = new BinaryTree(a[mid]);
		bt.left = addToTree(a, start, mid-1);
		bt.right = addToTree(a, mid+1, end);
		return bt;
	}
}
