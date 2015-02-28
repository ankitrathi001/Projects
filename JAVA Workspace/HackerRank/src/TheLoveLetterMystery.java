import java.util.Scanner;


public class TheLoveLetterMystery {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0;i<t;i++){
			int count=0;
			String s = sc.next();
			int j=0;int k=s.length()-1;
			while(j<k){
				count+=(Math.abs(s.charAt(j)-s.charAt(k)));
				j++;k--;
			}
			System.out.println(count);
		}
	}

}
