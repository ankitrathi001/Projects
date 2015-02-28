package ICIMS;

public class localExtrima {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {2, 2, 3, 4, 3, 3, 2, 2, 1, 1, 2, 5};
		//int[] A = {2, 3, 4};
		//int[] A = {2, 3, 1};
		System.out.print(countExtrima(A));
	}
	public static int countExtrima(int[] A){
		int count=0;
		int num=A[0];
		boolean minFlag=true;
		boolean maxFlag=true;
		for(int i=1;i<A.length;i++){	
			if(num!=A[i]){
				if(maxFlag==true && A[i]<num)
					count++;
				if(minFlag==true && A[i]>num)
					count++;
				if(A[i]>num){
					minFlag=false;
					maxFlag=true;
				}
				else{
					minFlag=true;
					maxFlag=false;
				}
				num=A[i];
			}
		}
		return ++count;
	}

}
