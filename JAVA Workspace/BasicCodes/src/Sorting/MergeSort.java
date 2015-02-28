package Sorting;

public class MergeSort {

	public static void main(String[] args) {
		int[] array = {2,5,1,3,11,7,8,9,4,10,6};
		int[] sortedArray = sort(array);
		for(int i=0;i<sortedArray.length;i++)
			System.out.print(sortedArray[i] + " ");
	}
	public static int[] sort(int[] array){
		int n = array.length;
		if(n<2) return array;
		int mid = n/2;
		int[] left = new int[mid];
		int[] right = new int[n-mid];
		for(int i=0;i<mid;i++)
			left[i]=array[i];
		for(int i=mid, j=0;i<n;i++,j++)
			right[j]=array[i];
		
		left = sort(left);
		right = sort(right);
		array = merge(left, right, array);
		
		return array;
	}
	
	public static int[] merge(int[] left, int[] right, int[] array){
		int nl = left.length;
		int nr = right.length;
		int i=0, j=0, k=0;
		while(i<nl && j<nr){
			if(left[i] < right[j]){
				array[k] = left[i];
				i++;
			}
			else{
				array[k] = right[j];
				j++;
			}
			k++;
		}
		while(i<nl){
			array[k]=left[i];
			i++;k++;
		}
		while(j<nr){
			array[k]=right[j];
			j++;k++;
		}
		return array;
	}
}
