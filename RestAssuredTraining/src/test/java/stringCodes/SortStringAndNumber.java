package stringCodes;

import java.util.Arrays;

public class SortStringAndNumber {

	public static void main(String[] args) {
		String str = "lklsahkskahhhhhhdgalk";
		
		Integer[] integers= {23,55,11,8,3,99};
		

		// Convert the string to a character array
		char[] charArray = str.toCharArray();
		
		Arrays.sort(integers);

		// Sort the character array
		Arrays.sort(charArray);
		Arrays.toString(integers);
		
		// Construct the sorted string
		String sortedString = new String(charArray);

		// Print the sorted string
		System.out.println("Sorted string: " + sortedString);
		System.out.println("Sorted string: " + Arrays.toString(integers));		
	}

}
