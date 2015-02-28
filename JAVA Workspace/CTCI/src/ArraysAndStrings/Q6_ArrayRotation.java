package ArraysAndStrings;

public class Q6_ArrayRotation {

	/**
	 * @param args
	 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, 
	 * write a method to rotate the image by 90 degrees. Can you do this in place?
	 */
	public static void main(String[] args) {
		int[][] a = new int[4][4];
		int k=0;
		for(int i=0;i<4;i++)
			for(int j=0;j<4;j++)
				a[i][j]=++k;
		a = rotateArray(a);
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++)
				System.out.print(a[i][j]+" ");
			System.out.println();
		}
	}
	public static int[][] rotateArray(int[][] a){
		for(int i=0;i<a.length/2;i++){
			int first = i;
			int last = a.length-1-i;
			for(int j=first;j<last;j++){
				int temp = a[first][j];
				a[first][j]=a[last-j+i][first];
				a[last-j+i][first]=a[last][last-j+i];
				a[last][last-j+i]=a[j][last];
				a[j][last]=temp;
			}
		}
		return a;
	}
}
