package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckPermutation {

	/*
	 * Question: Given two strings, write a method to decide if 
	 * 		one is a permutation of the other.	
	 * 
	 * 		A permutation is rearrangement of the itself
	 * 		(example) permutations of ABC: ABC, ACB, BAC, BCA, CBA, CAB
	 */
	
	public static void main(String[] args) {
		System.out.println(checkPermutation("abc", "abc"));
		System.out.println(checkPermutation("abc", "acb"));
		System.out.println(checkPermutation("abc", "bac"));
		System.out.println(checkPermutation("abc", "bca"));
		System.out.println(checkPermutation("abc", "cba"));
		System.out.println(checkPermutation("abc", "cab"));
		System.out.println("=======================");
		System.out.println(checkPermutation("abc", "acd"));
		System.out.println("=======================");
		System.out.println(permutation("abc", "abc"));
		System.out.println(permutation("abc", "acb"));
		System.out.println(permutation("abc", "bac"));
		System.out.println(permutation("abc", "bca"));
		System.out.println(permutation("abc", "cba"));
		System.out.println(permutation("abc", "cab"));
		
	}
	
	// my solution
	public static boolean checkPermutation(String str1, String str2) {
		char[] charArr1 = str1.toCharArray();
		char[] charArr2 = str2.toCharArray();
		StringBuilder sb1 = new StringBuilder();
		
		for (int i = 0; i < charArr1.length; i++) {
			// a single letter in first string
			for (int j = 0; j < charArr2.length; j++) {
				// a single letter in second string
				if (charArr1[i] == charArr2[j] ) {
					// only append when there is a match
					sb1.append(charArr2[j]);
				}
			}
		}
		
		if (sb1.toString().equals(str1)) {
			return true;
		} else {
			return false;
		}
	}
	
	// book solution
	
	// #1
	public static String sort(String str) {
		char[] content = str.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}
	public static boolean permutation(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		return sort(s).equals(sort(t) );
	}
	
}
