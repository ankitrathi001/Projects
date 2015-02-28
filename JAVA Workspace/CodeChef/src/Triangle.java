/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Triangle{
	public static void main (String[] args) throws java.lang.Exception{
		Scanner sc = new Scanner(System.in);
		int testcases=sc.nextInt();
		double min=100000000;
		double max=0;
		int mini=0;
		int maxi=0;
		
		int i=1;
		while(testcases!=0){
			double area=0;
			
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int x3 = sc.nextInt();
			int y3 = sc.nextInt();
			
			double a=(y2-y1)*(y2-y1)+(x2-x1)*(x2-x1);
			double b=(y3-y2)*(y3-y2)+(x3-x2)*(x3-x2);
			double c=(y3-y1)*(y3-y1)+(x3-x1)*(x3-x1);
			
			area=(Math.sqrt((4*a*b)-((a+b-c)*(a+b-c))))/4;
			//System.out.println(area);
			if(area>=max)
			{
				max=area;
				maxi=i;
			}
			if(area<=min)
			{
				min=area;
				mini=i;
			}
			testcases--;
			i++;
		}
		System.out.println(mini+" "+maxi);
	}
}