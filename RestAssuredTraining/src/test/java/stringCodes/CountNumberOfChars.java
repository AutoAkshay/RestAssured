package stringCodes;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfChars {

	public static void main(String[] args) {

		String str = "mdklHDKlsdmmHFHKDsml";
		// Convert the string to lower case
		String str1 = str.toLowerCase();

		// Create a HashMap to store character frequencies
		Map<Character, Integer> charCount = new HashMap<>();

		// Iterate over the lower case string
		for (char c : str1.toCharArray()) {
			// Update the count for each character
			charCount.put(c, charCount.getOrDefault(c, 0) + 1);
		}

		// Print character frequencies
		System.out.println("Repeated characters::");
		for (Map.Entry entry : charCount.entrySet()) {
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}

	}

}
