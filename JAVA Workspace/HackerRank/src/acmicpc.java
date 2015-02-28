import java.util.Scanner;


public class acmicpc {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
			int N = sc.nextInt();
			int M = sc.nextInt();
			int count=0;
			int max=0;
			String[] a = new String[N];
			for(int i=0;i<N;i++)
				a[i]=sc.next();
			for(int i=0;i<N-1;i++){
				for(int j=i+1;j<N;j++){
					int x=M-get0Count(a[i],a[j]);
					if(x==max)
						count++;
					if(x>max){
						count=1;
						max=x;
					}
				}
			}
			System.out.println(max+"\n"+count);
		}
		public static int get0Count(String s1, String s2){
			int res=0;
			for(int i=0;i<s1.length();i++)
				if((Integer.parseInt(""+s1.charAt(i)) | Integer.parseInt(""+s2.charAt(i)))==0)
					res++;
			return res;
		}
}
