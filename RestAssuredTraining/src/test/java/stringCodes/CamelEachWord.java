
package stringCodes;

import java.util.HashMap;
import java.util.Map;

public class CamelEachWord {
	public static void main(String[] args) {

		String string = "My Name Is Akshay";
		
		String[] str=string.split(" ");
		
		for(String eachString:str) {
//			System.out.println(eachString);
			char[] newChar=eachString.toLowerCase().toCharArray();
			System.out.print(eachString.toLowerCase().charAt(0)+eachString.toUpperCase().substring(1,eachString.length()));
	
//			System.out.print(" ");
			
//			for(int i=newChar.length-1;i>=0;--i) {
//				System.out.print(newChar[i]);
//			}
//			
			System.out.print(" ");
		}

	}

}
