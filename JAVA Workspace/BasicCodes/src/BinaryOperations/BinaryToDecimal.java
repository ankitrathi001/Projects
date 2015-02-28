package BinaryOperations;

public class BinaryToDecimal {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String binary = "110";
		System.out.println(BinToDec(binary));
	}
	
	public static int BinToDec(String binary){
		int decimal=0;
		for(int i=0;i<binary.length();i++){
			decimal = 2*decimal + Integer.parseInt("" + binary.charAt(i));
		}
		return decimal;
	}
}
