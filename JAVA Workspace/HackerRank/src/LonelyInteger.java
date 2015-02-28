
public class LonelyInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {0,0,1,2,1};
		System.out.println(lonelyinteger(a));
	}
	static int lonelyinteger(int[] a) {
		if(a.length==0)
			return 0;
	    int i=0;
	    int j=0;
	    for(i=0;i<a.length-1;i++){
	        for(j=0;j<a.length;j++){
	        	if(j!=i)
	        		if(a[i]==a[j])
	        			break;
	        }
	        if(j==a.length)
	            return a[i];
	    }
	    return a[i];
	}
}
