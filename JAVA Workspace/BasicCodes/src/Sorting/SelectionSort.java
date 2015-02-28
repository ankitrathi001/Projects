package Sorting;

public class SelectionSort {

	public static void main(String[] args) {
		int[] array = {2,5,1,3,11,7,8,9,4,10,6};
		int[] sortedArray = sort(array);
		for(int i=0;i<sortedArray.length;i++)
			System.out.print(sortedArray[i] + " ");
	}
	public static int[] sort(int[] array){
		int min = 0;
		for(int i =0;i<array.length;i++){
			for(int j=i;j<array.length;j++){
				if(array[j]<array[min]){
					min = j;
				}
			}
			int temp = array[i];
			array[i] = array[min];
			array[min] = temp;
		}
		return array;
	}

}
