package atmecs.rest.falcon.testscript;

import org.openqa.selenium.support.ui.Select;

public class BinaryNumber {

	public static void main(String[] args) {
		int [] my= {1,1,0,0,1,1,1,0,0,1,0};
	
		int count=0;
		for(int i=0;i<my.length;i++) {
			if(my[i]==0) {
				
				count++;
			}
			}
	for (int i=0;i<my.length;i++) {
if(i<count) {
	
	my[i]=0;
}
else {
	my[i]=1;
}
System.out.println(my[i]);
	}
	
		}
	
	
	
		
}


