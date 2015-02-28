import java.util.TreeMap;


public class certAUCYNEM4KCP5DTTUSXV5JS {

	/**
	 * @param args
	 * https://codility.com/c/run/certAUCYNE-M4KCP5DTTUSXV5JS
	 */
	public static void main(String[] args) {
		int A[] = {6, 2, 7, 5, 6, 5, 2};
		TreeMap<Integer, Integer> t = new TreeMap<>();
		for(int i=0;i<A.length;i++){
			t.put(A[i], i);
		}
		for(int i=0;i<t.size();i++){
			System.out.print(t.keySet());
			
		}
	}

}
