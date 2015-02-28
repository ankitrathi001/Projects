package Feb;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class CHEFEQ {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0;i<t;i++){
			int n = sc.nextInt();
			Map<Integer, Integer> m = new HashMap<>();
			for(int j=0;j<n;j++){
				int x = sc.nextInt();
				if(m.containsKey(x)){
					int temp = m.get(x);
					m.put(x, ++temp);
				}
				else
					m.put(x, 1);
			}
			int max=0;
			Iterator iterator = m.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry mapEntry = (Map.Entry) iterator.next();
				if((int)mapEntry.getValue()>max)
					max=(int)mapEntry.getValue();
			}
			System.out.println(n-max);
		}
	}

}
