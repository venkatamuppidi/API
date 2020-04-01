package atmecs.rest.falcon.testscript;

public class DuplicateNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] myarray= {1,2,3,1,3,1,4,4,5,3,5,6,4,6,7,8,8,9,0,8};
		for (int i=0;i<myarray.length;i++) {
			
				for(int j=i+1;j<myarray.length;j++){
					
					if((myarray[i]==myarray[j])) {
						System.out.println("duplicate number"+myarray[j]);
					}
					
				}
		}
		
		
		
		
	}

}
