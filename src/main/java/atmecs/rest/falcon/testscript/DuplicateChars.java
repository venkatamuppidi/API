package atmecs.rest.falcon.testscript;

public class DuplicateChars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			/*String strng= "";
			char[]  ch=strng.toCharArray();
			for(int i=0;i<strng.length();i++) {
				
				
					for(int j =i+1;j<strng.length();j++) {
						if(ch[i]==ch[j]) {
							
							System.out.println("Duplicate value "+ch[j]);
							
						}
						
					}
				
						}
		
		
		
		
	}*/
	
	String strng="abcdefghsdfsg";
	char[] duplicate=strng.toCharArray();
	for(int i=0;i<strng.length();i++) {
		for(int j=i+1;j<strng.length();j++) {
			if(duplicate[i]==duplicate[j]) {
				System.out.println("Duplicate value "+duplicate[j]);
			}
		}
	}
		
	}
			
}
