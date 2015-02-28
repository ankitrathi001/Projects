package Strings;

public class AddBinaryStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(1^1^1);
		System.out.println(addBinary("11", "1"));
	}
	public static String addBinary(String a, String b) {
        String s="";
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        while(i>=0 && j>=0){
        	int c = Integer.parseInt(a.charAt(i)+"")+Integer.parseInt(b.charAt(j)+"")+carry;
        	s=(c%2)+s;
        	if(c>1)
        		carry=1;
        	else
        		carry=0;
        	i--;j--;
        }
        while(i>=0){
        	int c = Integer.parseInt(a.charAt(i)+"")+carry;
        	s=(c%2)+s;
        	if(c>1)
        		carry=1;
        	else
        		carry=0;
        	i--;
        }
        while(j>=0){
        	int c = Integer.parseInt(b.charAt(j)+"")+carry;
        	s=(c%2)+s;
        	if(c>1)
        		carry=1;
        	else
        		carry=0;
        	j--;
        }
        if(carry==1)
        	s=carry+s;
        return s;
    }
}
