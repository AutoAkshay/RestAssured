package stringCodes;

public class StringProblem6 {

	public static void main(String[] args) {
		String str1 = "Akshay Anil Kalam";

		// Split the string into an array of words based on whitespace
		String[] words = str1.split(" ");

		// Count the number of words in the array
		int wordCount = words.length;

		// Print the number of words
		System.out.println("Number of words in the string: " + wordCount);

		// Calculate and print the length of each word
		for (String word : words) {
			int wordLength = word.length();
			System.out.println("Word: " + word + ", Length: " + wordLength);
		}
	}

}
