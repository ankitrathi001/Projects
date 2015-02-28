import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;


public class AnagramsInSetOfWords {
	/**
	 * @param args
	 */
	@Override
	public int hashCode(){
		return 1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = {"cat", "dog", "tac", "god", "act", "gdo"};
		findAnagramsSet(s);
	}
	public static int[] primeNum = {1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
	public static void findAnagramsSet(String[] s){
		Map<Integer, Integer> m = new HashMap<>();
		ArrayList<List<String>> arrL = new ArrayList<>();
		for(int i=0;i<s.length;i++){
			int a = calculateKey(s[i]);
			if(m.containsKey(a)){
				for(int j=0;j<arrL.size();j++){
					if(arrL.get(j).get(0).equals(""+a))
						arrL.get(j).add(s[i]);
				}
			}
			else{
				m.put(a, i);
				List<String> l = new ArrayList<>();
				l.add(a+"");
				l.add(s[i]);
				arrL.add(l);
			}
		}
		System.out.println(arrL);
	}
	public static int calculateKey(String s){
		int a = 0;
		for(int i=0;i<s.length();i++){
			a+=primeNum[s.charAt(i)-97];
		}
		return a;
	}
}
