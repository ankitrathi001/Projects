package Sorting;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {2,5,1,3,11,7,8,9,4,10,6};
		int[] sortedArray = sort(array);
		for(int i=0;i<sortedArray.length;i++)
			System.out.print(sortedArray[i] + " ");
	}
	
	public static int[] sort(int[] array){
		for(int i=1;i<array.length;i++){
			int temp = array[i];
			for(int j=i-1;j>=0 && temp < array[j];j--){
				array[j+1] = array[j];
				array[j] = temp;
			}
		}
		return array;
	}
}
