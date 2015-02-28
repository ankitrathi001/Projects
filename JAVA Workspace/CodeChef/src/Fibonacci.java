import java.util.Scanner;

class Fibonacci {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcases=sc.nextInt();
		while(testcases!=0){
			int C = sc.nextInt();
			int P = sc.nextInt();
			while(C/P!=0){
				C=C%P;
			}
			if(C>1836311903)
				System.out.println(-1);
			else
			{
				int FN = C%P;
				//System.out.println(FN);
				String fib = getFibonacciNum(P);
				String[] fibs = fib.split("\\s+");
				int[] fibn = new int[fibs.length];
				int j=0;
				int flag=0;
				for(int i=0;i<fibs.length;i++){
					fibn[i]=Integer.parseInt(fibs[i]);
					if(fibn[i]>C)
					{
						j=i-1;
						flag=i;
						break;
					}
				}
				if(flag==0)
					j=fibs.length-1;
				//System.out.println(C-fibn[j]+"Hi");
				//System.out.println(fibn[fibn.length-2]);	
				int i=0;
				int result = 0;
				while(fibn[i]<=(C-fibn[j])){
					if(fibn[i]==(C-fibn[j]))
						result = 1;
					i++;
				}
				int x=fibn[j];
				int y=fibn[j+1];
				int fn=0;
				if(C==0)
					System.out.println(0);
				else if(result==1)
				{
					while((fn-C)%P!=0 && fn!=1836311903){
						fn=x+y;
						//System.out.println("'"+fn+"'");
						x=y;
						y=fn;
						j++;
					}
					System.out.println(j+1);
				}
				else
					System.out.println(-1);
				testcases--;
			}
		}
	}
	static String getFibonacciNum(int a){
		int x=0;
		int y=1;
		int fn=0;
		String s = "";
		s+=fn;
		while(fn<a && fn!=1836311903){
			fn=x+y;
			System.out.println(fn+";");
			s+=" "+fn;
			y=x;
			x=fn;
		}
		return s;
	}
}