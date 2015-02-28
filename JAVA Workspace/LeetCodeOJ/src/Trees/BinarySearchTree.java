package Trees;

public class BinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {2,5,1,3,11,7,8,9,4,10,6};
		BinaryTree bt=null;
		for(int i=0;i<array.length;i++){
			bt = AddAChild(bt, array[i]);
		}
		inOrderTraversal(bt);
		System.out.println();
		preOrderTraversal(bt);
		System.out.println();
		postOrderTraversal(bt);
		System.out.println();
		System.out.println(search(bt,6));
		System.out.println(search(bt,17));
		bt = delete(bt, 5);
		inOrderTraversal(bt);
		System.out.println();
		preOrderTraversal(bt);
		System.out.println();
		postOrderTraversal(bt);
		System.out.println();
	}
	public static BinaryTree AddAChild(BinaryTree bt, int data){
		BinaryTree temp=bt;
		if(bt==null){
			return new BinaryTree(data);
		}
		else
		{		
			while(true){
				if(data<temp.data){
					if(temp.left==null){
						temp.left = new BinaryTree(data);
						break;
					}
					temp=temp.left;
				}
				else
				{
					if(temp.right==null){
						temp.right = new BinaryTree(data);
						break;
					}
					temp=temp.right;
				}
			}
		}
		return bt;
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
	public static boolean search(BinaryTree bt, int data){
		if(bt==null)
			return false;
		if(bt.data == data)
			return true;
		else
		{
			if(data < bt.data)
				return search(bt.left, data);
			else
				return search(bt.right, data);
		}
	}
	
	public static BinaryTree delete(BinaryTree bt, int data){
		BinaryTree temp = bt;
		if(temp.data==data)
			return delete2(temp);
		while(true){
			if(data<temp.data){
				if(temp.left==null)
					break;
				if(temp.left.data==data){
					temp.left=delete2(temp.left);
					break;
				}
				else
					temp=temp.left;
			}
			else{
				if(temp.right==null)
					break;
				if(temp.right.data==data){
					temp.right=delete2(temp.right);
					break;
				}
				else
					temp=temp.right;
			}
		}
		return bt;
	}
	
	public static BinaryTree delete2(BinaryTree bt){
		BinaryTree temp = bt;
		if(bt.left==null)
			return bt.right;
		else if(bt.right==null)
			return bt.left;
		else{
			temp = bt.right;
			if(temp.left==null){
				bt.data=temp.data;
				bt.right=temp.right;
				return bt;
			}
			else{
				while(temp.left.left!=null){
					temp=temp.left;
				}
				bt.data=temp.left.data;
				temp.left=temp.left.right;
				return bt;
			}
		}
	}
}
