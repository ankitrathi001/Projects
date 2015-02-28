package Strings;

public class ExcelColumnNameToNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(titleToNumber("ZO"));
	}
	public static int titleToNumber(String s) {
        int x = 0;
		for(int i=0;i<s.length();i++)
			x = x*26+(s.charAt(i)-64); 
		return x;
    }
}
