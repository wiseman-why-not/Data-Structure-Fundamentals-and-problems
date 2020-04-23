package string;

import java.util.ArrayList;
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
		
	}
	
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

}
