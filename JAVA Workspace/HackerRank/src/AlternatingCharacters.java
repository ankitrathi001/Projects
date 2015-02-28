import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;


public class AlternatingCharacters {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0;i<t;i++){
			String s = sc.next();
			char c = s.charAt(0);
			int count=0;
			for(int j=1;j<s.length();j++){
				if(c==s.charAt(j))
					count++;
				c=s.charAt(j);
			}
			System.out.println(count);
		}
	}
}
