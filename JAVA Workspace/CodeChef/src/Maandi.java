import java.util.Scanner;

class Maandi 
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcases=sc.nextInt();
		while(testcases!=0){
			int a = sc.nextInt();
			int count=0;
			String s = ""+a;
			//count+=superLucky(s);
			for(int i=1;i<=Math.sqrt(a);i++){
				if(a%i==0){
					s = ""+i;
					count+=superLucky(s);
					if(i!=a/i)
						count+=superLucky(""+(a/i));
				}					
			}
			System.out.println(count);
			testcases--;
		}
	}
	static int superLucky(String s){
		int count=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='4' || s.charAt(i)=='7')
				return 1;
		}
		return count;
	}
}