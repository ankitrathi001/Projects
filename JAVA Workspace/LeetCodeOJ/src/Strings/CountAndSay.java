package Strings;

public class CountAndSay {

	/**
	 * @param args
	 * 1, 11, 21, 1211, 111221, 312211, 13112221 ...
		1 is read off as "one 1" or 11.
		11 is read off as "two 1s" or 21.
		21 is read off as "one 2, then one 1" or 1211.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countAndSay(1));
		System.out.println(countAndSay(2));
		System.out.println(countAndSay(3));
		System.out.println(countAndSay(4));
		System.out.println(countAndSay(5));
		System.out.println(countAndSay(6));
	}
	public static String countAndSay(int n) {
        String l = "1";
        for(int i=1;i<n;i++){
        	StringBuilder sb = new StringBuilder();
        	int j = 1;
        	int count = 1;
        	char curr=l.charAt(0);
        	while(j<l.length()){
        		if(l.charAt(j)==curr)
        			count++;
        		else{
        			sb.append(count);
        			sb.append(curr);
        			count = 1;
        			curr = l.charAt(j);
        		}
        		j++;
        	}
        	sb.append(count);
        	sb.append(curr);
        	l = sb.toString();
        }
        return l;
    }
}
