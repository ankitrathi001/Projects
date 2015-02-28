package Sorting;

public class HeapSort {

	public static void main(String[] args) {
		int[] array = {2,5,1,3,11,7,13,8,9,4,10,6};
		int[] sortedArray = sort(array);
		for(int i=0;i<sortedArray.length;i++)
			System.out.print(sortedArray[i] + " ");
		System.out.println();
		sortedArray = sortDesc(array);
		for(int i=0;i<sortedArray.length;i++)
			System.out.print(sortedArray[i] + " ");
	}
	public static int[] sort(int[] array){
		System.out.print("In Heap Sort: ");
		int n = array.length;
		while(n>1){
			array = maxHeapify(array, n);
			int temp = array[0];
			array[0]=array[n-1];
			array[n-1] = temp;
			n--;
		}
		return array;
	}
	public static int[] sortDesc(int[] array){
		System.out.print("In Heap Sort: ");
		int n = array.length;
		while(n>1){
			array = minHeapify(array, n);
			int temp = array[0];
			array[0]=array[n-1];
			array[n-1] = temp;
			n--;
		}
		return array;
	}
	public static int[] maxHeapify(int[] array, int n){
		int i = n-1;
		while((i-2)/2 >= 0){
			if(array[i]>array[(i-1)/2]){
				int temp = array[i];
				array[i] = array[(i-1)/2];
				array[(i-1)/2] = temp;
			}
			if(array[i]>array[(i-2)/2]){
				int temp = array[i];
				array[i] = array[(i-2)/2];
				array[(i-2)/2] = temp;
			}
			i--;
		}
		return array;
	}
	public static int[] minHeapify(int[] array, int n){
		int i = n-1;
		while((i-2)/2 >= 0){
			if(array[i]<array[(i-1)/2]){
				int temp = array[i];
				array[i] = array[(i-1)/2];
				array[(i-1)/2] = temp;
			}
			if(array[i]<array[(i-2)/2]){
				int temp = array[i];
				array[i] = array[(i-2)/2];
				array[(i-2)/2] = temp;
			}
			i--;
		}
		return array;
	}
}
