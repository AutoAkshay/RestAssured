package stringCodes;

import java.util.HashMap;
import java.util.Map;

public class StringProblem7 {

	public static void main(String[] args) {
		
		String s = "Butter  ,Buffer   ,  Butter";

        // Split the string into an array of words based on commas and whitespace
        String[] words = s.split("\\s*,\\s*");

        // Create a HashMap to store words and their counts
        Map<String, Integer> map = new HashMap<>();

        // Iterate over each word to count its occurrences and store it in the HashMap
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
            
        }
        System.out.println(map.keySet());
        // Print the words and their counts stored in the HashMap
//        for (Map.Entry entry : map.entrySet()) {
//            System.out.println(entry.getKey());
//        }
	}

}
