package atmecs.rest.falcon.testscript;

import org.springframework.data.domain.Example;

public class ReversetheWord {
	
	 /*public  void reversetheword() {
			String strng="MY love may country";
		String[] words=strng.split(" ");
		String reversed =" ";
		for(int i =0;i<words.length;i++) {
			String word=words[i];
			String wordreversed =" ";
		System.out.println(word);
		}
			
	}*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		String strng="MY love may country";
		String reversed=" ";
		String words[]=strng.split(" ");
		
		for(int i =0;i<words.length;i++) {
			String word=words[i];
			System.out.println("stp1"+word);
			String wordreversed =" ";
		//System.out.print(words[i] +" ");
		
		for(int j=word.length()-1;j>=0;j--) {
			
			wordreversed=wordreversed+word.charAt(j);
			
			
		}
		
		reversed=reversed+wordreversed+" ";
		}
		System.out.println(reversed);
			
	}
		

	}


