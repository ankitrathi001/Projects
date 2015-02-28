package ArraysAndStrings;

import java.util.ArrayList;

public class PermutationOfArray {

	/**
	 * @param args
	 * Anshul
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> a = new ArrayList<>();
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		System.out.print(permuteArray(a).size());
	}
	public static ArrayList<ArrayList<Integer>> permuteArray(ArrayList<Integer> a){
		ArrayList<ArrayList<Integer>> arrL = new ArrayList<>();
		if(a.size()==1)
		{
			ArrayList<Integer> t = new ArrayList<>();
			t.add(a.get(0));
			arrL.add(t);
			return arrL;
		}
		int x = a.get(0);
		ArrayList<Integer> t = new ArrayList<>();
		for(int i=1;i<a.size();i++)
			t.add(a.get(i));
		ArrayList<ArrayList<Integer>> temp = permuteArray(t);
		for(int i=0;i<temp.size();i++){
			ArrayList<Integer> y = temp.get(i);
			for(int j=0;j<y.size();j++){
				ArrayList<Integer> z = new ArrayList<>();
				for(int k=0;k<y.size();k++){
					if(j==k)
						z.add(x);
					z.add(y.get(k));
				}
				arrL.add(z);
			}
			y.add(x);
			arrL.add(y);
		}
		return arrL;
	}
}
