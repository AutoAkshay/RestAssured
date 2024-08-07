package stringCodes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountSimilarCharByComparison {
	public static void main(String[] args) {

		String str1 = "abcwi";
		String str2 = "xyz";
		String str3 = "abcxyzw";

		// Convert strings to sets
		Set<Character> set1 = new HashSet<>();
		Set<Character> set2 = new HashSet<>();
		Set<Character> set3 = new HashSet<>();

		for (char c : str1.toCharArray()) {
			set1.add(c);
		}
		for (char c : str2.toCharArray()) {
			set2.add(c);
		}
		for (char c : str3.toCharArray()) {
			set3.add(c);
		}

		// Find the intersection of set1, set2, and set3
		set1.retainAll(set3);
		set2.retainAll(set3);
		
		// Print the similar characters found
		System.out.println("Similar characters in str1 and str2 that are also present in str3:");
		System.out.println(set1);
		System.out.println(set2);
		
		
	}
}
