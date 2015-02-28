
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="4";
		String s3="";
		int a=0;
		while(a<1000){
			for(int i=4*(int)Math.pow(10, s1.length()-1);i<5*Math.pow(10, s1.length()-1);i++){
				s3=s1;
				s3=""+i;
				System.out.println(s3);
				for(int j=1;j<10;j++){
					System.out.println(""+j+s3);
				}
			}
			s1=4*(int)Math.pow(10, s1.length())+"";
			a=Integer.parseInt(s1);
		}
	}

}
