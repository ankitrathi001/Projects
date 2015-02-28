package Trees;

import java.util.LinkedList;
import java.util.List;

public class ReturnUniqueBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<BinaryTree> l = generateTrees(0);
		/*for(int i=0;i<l.size();i++){
			BinaryTree bt = l.get(i);
			BinaryTree.inOrderTraversal(bt);
			System.out.println();
		}
		*/
		System.out.println(l.size());
	}
	public static List<BinaryTree> generateTrees(int n) {
        List<BinaryTree> l = new LinkedList<>();
        if(n==0)
        	return l;
        if(n==1)
        	l.add(new BinaryTree(1));
        else{
        	l = generateTreesNSize(n, n);
        }
        return l;
    }
	public static List<BinaryTree> generateTreesNSize(int n, int size){
		List<BinaryTree> l = new LinkedList<>();
		if(size<=0)
        	return null;
        if(size==1)
        	l.add(new BinaryTree(n));
        else{
        	for(int i=n-size+1;i<=n;i++){
        		List<BinaryTree> z = new LinkedList<>();
        		List<BinaryTree> x = generateTreesNSize(n, n-i);
        		if(x!=null){
	        		for(int j=0;j<x.size();j++){
	        			BinaryTree temp = new BinaryTree(i);
	        			temp.right = x.get(j);
	        			z.add(temp);
	        		}
        		}
        		List<BinaryTree> y = generateTreesNSize(i-1, i-n+size-1);
        		if(y!=null){
        			if(z.size()!=0){
		        		for(int j=0;j<z.size();j++){
		        			for(int k=0;k<y.size();k++){
		        				BinaryTree temp = z.get(j);
		        				temp.left = y.get(k);
		        				l.add(temp);
		        			}
		        		}
        			}
        			else{
        				for(int k=0;k<y.size();k++){
	        				BinaryTree temp = new BinaryTree(i);
	        				temp.left = y.get(k);
	        				l.add(temp);
	        			}
        			}
        		}
        		else{
        			for(int j=0;j<z.size();j++)
        				l.add(z.get(j));
        		}
        	}
        }
		return l;
	}
}
