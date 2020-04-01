package atmecs.rest.falcon.testscript;

public class fibnocciSeriesUsingloop {
 public static void main(String[] args) {
	 int n=5, 
			 a=0, b=1,sum=0;
	 int i=0;
	while(i<n) {
		
		if(i<=1) {
			sum=i;
		}
		else {
			sum=a+b;
			a=b;
			b=sum;
			
					
		}
		System.out.println(sum);
		i++;
			
		
		
	}
 }
}
		 


 

