package Arrays;

import java.util.LinkedList;
import java.util.List;

public class PascalsTriangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(generate(8));
	}
	public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> l = new LinkedList<>();
        for(int i=0;i<numRows;i++){
        	List<Integer> a = new LinkedList<>();
        	if(i==0)
        		a.add(1);
        	else{
        		a.add(1);
        		List<Integer> b = l.get(i-1);
        		for(int j=1;j<b.size();j++)
        			a.add(b.get(j)+b.get(j-1));
        		a.add(1);
        	}
        	l.add(a);
        }
        return l;
    }
}
