package Array;

public class QuickSort {

	public static void main(String[] args) {
		int[] array = {2,5,1,3,11,7,13,8,9,4,10,6};
		int[] sortedArray = sort(array);
		for(int i=0;i<sortedArray.length;i++)
			System.out.print(sortedArray[i] + " ");
	}
	public static int[] sort(int[] array){
		//System.out.print("In Quick Sort: ");
		quickSort(array, 0, array.length-1);
		return array;
	}
	public static int[] quickSort(int[] array, int s, int e){
		if(s>=e)
			return array;
		int p = partition(array,s,e);
		quickSort(array, s, p-1);
		quickSort(array, p+1, e);
		return array;
	}
	public static int partition(int[] array, int s, int e){
		int i=0;
		int pivot = array[e];
		for(int j=0;j<e;j++){
			if(array[j]<=pivot)
			{
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
			}
		}
		int temp = array[i];
		array[i] = array[e];
		array[e] = temp;
		return i;
	}
}
