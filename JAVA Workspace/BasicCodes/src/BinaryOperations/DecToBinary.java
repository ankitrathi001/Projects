package BinaryOperations;

public class DecToBinary {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int decimal = 55;
		System.out.println(DecToBinary.DecimalToBinary(decimal));
	}
	public static String DecimalToBinary(int decimal){
		String binary="";
		while(decimal!=0){
			binary = (decimal%2) + binary;
			decimal/=2;
		}
		return binary;
	}

}
