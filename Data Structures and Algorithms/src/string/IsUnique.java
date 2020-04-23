package string;

import java.util.HashSet;
import java.util.Set;

public class IsUnique {
	
	/*
	 * Question: Implement an algorithm to determine if a string has all unique characters
	 * 		What if you cannot use additional data structures.	
	 */

	public static void main(String[] args) {
		String str = "It was a dark inside the wolf and three little piggys wondered down the wolfs alley";
		String str1 = "abcdefghijklmnopqrstuvwxyz";
		String str2 = "abcdefghijkl";
		 
		System.out.println(checkUniqData(str));
		System.out.println(checkUniqData(str1));
		System.out.println(checkUniqData(str2));
	}

	public static boolean checkUniq(String str) {
		// if the string is longer than ascii chart, than there has to be a repeat.
		if (str.length() > 128) {
			return false;
		}
		// create an array of booleans that can hold each ascii character
		boolean[] values = new boolean[128];
		
		for (int i = 0; i < str.length(); i++) {
			int index = str.charAt(i);
			// if it already has true in the position.
			if(values[index]) {
				return false;
			} else {
				values[index] = true;
			}
		}
		return true;
	}
	
	public static boolean checkUniqData(String str) {
		// if the string is longer than ascii chart, than there has to be a repeat.
		if (str.length() > 128) {
			return false;
		}
		// using Hash Set because set creates a list with unique values
		Set<Character> hs = new HashSet<>();
		for (int i = 0; i < str.length(); i++) {
			// return false if the hash set wont add the char
			if (!hs.add(str.charAt(i))) {
				return false;
			}
		}
		
		return true;

	}
}
