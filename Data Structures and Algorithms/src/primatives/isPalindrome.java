package primatives;

public class isPalindrome {
	/*
	 * A palindrome is a sequence that reads the same forwards an backwards.
	 * Give an integer as input, write a function that test if it is a palindrome
	 * 
	 * Note: A negative number cannot be a plaindrome due the negative sign
	 * CONSTRAINTS: You may NOT cast the number to a string.
	 * 
	 */
	public static void main(String[] args) {

	}
	
	public static boolean checkPalindrome(int x) { // x = 12321
		// check to see if number is negative
		if (x < 0) {
			return false;
		}
		
		// creating a mask. first we need to know the log base 10 because it will give us close the the amount of number digits we have in our number
		// we take log10 because we want to know how many times we want to multiply 10 by to get the length of this number. this helpful to know how many digits
		// because we will use this to generate a mask later to chop of items.
		double log = Math.log10(x); // log10(12321) = 4.09. also the amount of times we need to raise 10 by to get to our number. 
		// we want to take the floor of that number because its the closest number to that integer that is less our exact log number. we add 1 to get the amount of digits
		int totalDigits = (int)(Math.floor(log)) + 1; // (Math.floor(4.09)) = 4; 4+1 = 5.00 cast it to an int. this will get us the total amount of digits in our number.
		int mask = (int) Math.pow(10, totalDigits - 1); // we raise 10 to the 4th power because that will give us 10,000
		
		// loop through half of the amount of digits to check each side, ignoring the third digit because it will end up on an even number.
		for (int i = 0; i < (totalDigits/2); i++) {
			int furthestLeftDigit = x/mask; // 12,321 / 10,000 = 1.2321 truncating it to an furthest left int which is 1
			int furthestRightDigit = x % 10; // 12,321 % 10 = remainder of the last digit on the right which is 1
			
			if (furthestLeftDigit != furthestRightDigit) { // if the two numbers are not equal, then return false
				return false;
			}
			// now take remove the two numbers on the end starting with the left then right and then taking off 2 decimal places for our mask for the next iteration
			x = x % mask; // 12,321 % 10,000 = remainder of 2,321
			x = x / 10; // 2,321 / 10 = 231.1 the int gets cut off
			mask = mask / 100; // 10,000 / 100 = 100
		}
		// if it passes through the loop then it is a palindrome and return true.
		return true;
	}

}
