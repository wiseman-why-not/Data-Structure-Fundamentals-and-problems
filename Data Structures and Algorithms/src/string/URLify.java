package string;

public class URLify {

	/*
	 * Question: Write a method to replace all spaces in a string with '%20'. 
	 * 		You may assume that the string has sufficient space at the end
	 * 		to hold the additional characters, and that you are given the 'true'
	 * 		length of the string. (NOTE: If implementing in Java, pleas use a character
	 * 		array so that you can perform this operation in place.
	 * 		
	 */
	
	public static void main(String[] args) {
		String str = "Mr John Smith   ";
		String content = urlify(str);
		System.out.println(content);
	}
	
	public static String urlify(String str) {
		// change string to a character array
		char[] arr = str.toCharArray();
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == ' ') {
				arr[i] = '%';
			}
			System.out.print(arr[i]);
		}
		String result = arr.toString();
		return result;
	}
	

}
