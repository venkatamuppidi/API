package atmecs.rest.falcon.testscript;

public class Factorial {
	
	static int factorial (int n) {
		if (n==1) 
		
		return 1;
		else
			
		return(n*factorial(n-1));
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("factorial "+factorial(10));

	}

}
