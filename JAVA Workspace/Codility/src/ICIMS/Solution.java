package ICIMS;

import java.util.Arrays;

class Solution {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] A = {2, 2, 3, 4, 3, 3, 2, 2, 1, 1, 2, 6};
		int[] A = {10, 0, 8, 2, -1, 12, 11, 3};
		//int[] A = {2, 3, 4};
		//int[] A = {2, 3, 1};
		System.out.println(solution(1073741823));
		//System.out.println(9736>>11);
	}
    public static int solution(int N) {
    	int largest = 0;
        int shift = 0;
        int temp = N;
        for (int i = 1; i <= 30; ++i) {
            int index = (temp & 1);
            temp = ((temp >> 1) | (index << 29));
            if (temp >= largest) {
                largest = temp;
                shift = i;
            }
        }
        return shift;
    }
}
