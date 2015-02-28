import java.util.Scanner;

public class Lebambo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcases=sc.nextInt();
		while(testcases!=0){
			System.out.println(counter(sc));
			testcases--;
		}
	}
	static int counter(Scanner sc)
	{
		int sticks = sc.nextInt();
		int stick1=sticks;
		int stick2=sticks;
		int[] DiffLength = new int[sticks];
		int i=0;
		int count=0;
		int count1=0;
		while(stick1!=0){
			DiffLength[i]=sc.nextInt();	
			stick1--;
			i++;
		}
		i=0;
		int min=200;
		int mini=0;
		while(stick2!=0){
			DiffLength[i]=sc.nextInt()-DiffLength[i];
			if(DiffLength[i]!=0)
				count++;
			count1+=DiffLength[i];
			if(DiffLength[i]<min){
				min=DiffLength[i];
				mini=i;
			}
			stick2--;
			i++;
		}
		if(sticks==1 && DiffLength[0]!=0)
			return -1;
		if(count==0)
			return 0;
		else{	
			int result=0;
			while(count!=0){
				if(count1<0)
					return -1;
				count=0;
				count1=0;
				int MinIntermediate=200;
				int MinIntermediatei=0;
				for(int k=0;k<sticks;k++){
					if(mini==k)
						DiffLength[k]++;
					else
						DiffLength[k]--;
					count1+=DiffLength[k];
					//System.out.print(DiffLength[k]+" ");
					if(DiffLength[k]!=0)
						count++;
					if(MinIntermediate>DiffLength[k]){
						MinIntermediate=DiffLength[k];
						MinIntermediatei=k;
					}
				}
				//System.out.print(count1+" "+MinIntermediate);
				//System.out.println();
				result++;
				mini=MinIntermediatei;
				min = MinIntermediate;
			}
			return result;
		}
	}
}
