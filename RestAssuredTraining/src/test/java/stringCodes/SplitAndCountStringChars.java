package stringCodes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SplitAndCountStringChars {

	public static void main(String[] args) {
		String str1 = "abcw&iKLabcxx&yKKzyzw";

		// Split the string whenever "&" is encountered
		String[] splitStrings = str1.split("&");
		
		// Assign names to individual strings
        String name1 = splitStrings[0];
        String name2 = splitStrings[1];
        String name3 = splitStrings[2];

        // Print the output with names
        System.out.println("Split strings:");
        System.out.println("Name 1: " + name1);
        System.out.println("Name 2: " + name2);
        System.out.println("Name 3: " + name3);
		

	}

}
