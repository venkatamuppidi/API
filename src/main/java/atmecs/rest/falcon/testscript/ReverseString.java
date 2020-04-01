package atmecs.rest.falcon.testscript;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String Strng="Venkata Muppidi";
		String reverse="";
		
		System.out.println("postion of the char is :+"+Strng.indexOf('M'));
		for (int i=Strng.length()-1;i>=0;i--) {
			reverse=reverse+Strng.charAt(i);
		}
System.out.println("revers"+reverse);
	}

}
