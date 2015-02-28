
public class Q3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int z=1;
		for(int i=2;i<=Math.sqrt(z);i++){
			for(int j=2;j<=Math.sqrt(z);j++){
				if(aPowb(i, j, z)==0){
					
					System.out.println(1+" "+i+" "+j);
					return;
				}
			}
		}
		System.out.println(0);
	}
	public static int aPowb(int base, int exponent, int modulus)
	{
	    int result = 1;
	    while (exponent > 0)
	    {
	        if (exponent % 2 == 1)
	            result = (result * base) % modulus;
	        exponent = exponent >> 1;
	        base = (base * base) % modulus;
	    }
	    return result;
	}
}
