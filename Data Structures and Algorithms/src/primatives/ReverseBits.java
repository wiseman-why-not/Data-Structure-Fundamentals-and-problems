package primatives;

public class ReverseBits {
	
	/*
	 * Given an input integer input, return the integer value of input's bits reversed. 
	 * You will only be reversing the "significant portion" of the binary representation 
	 * (ignoring leading zeros).
	 * 
	 */

	// 128 - 64 - 32 - 16 - 8 - 4 - 2 - 1
	
	public static void main(String[] args) {
		int x = 11;
		
	}
	
	public static int reverseBits(int input) {
		int output = 0;
		
		while (input != 0) {
			output = output << 1;
			
			if ( (input & 1) == 1) {
				output |= 1;
			}
			
			input = input >> 1;
		}
		return output;
	}
	
	

}
