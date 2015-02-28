package Sorting;

public class BubbleSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {2,5,1,3,11,7,8,9,13,4,10,6};
		int[] sortedArray = sort(array);
		for(int i=0;i<sortedArray.length;i++)
			System.out.print(sortedArray[i] + " ");
	}
	public static int[] sort(int[] array){
		System.out.print("Bubble sort: ");
		boolean flag = true;
		while(flag){
			flag = false;
			for(int i =1;i<array.length;i++){
				if(array[i]<array[i-1]){
					flag = true;
					int temp = array[i-1];
					array[i-1] = array[i];
					array[i] = temp;
				}
			}
		}
		return array;
	}

}
