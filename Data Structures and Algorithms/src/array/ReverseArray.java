package array;

public class ReverseArray {
	/*
	Reverse and array of integers without knowing the size of the array.
	 */
	public static void main(String[] args) {
		int[] array1 = new int[] {1,2,3,4};
		
		int[] revArray1 = reverseArray(array1);
		for (int i : revArray1) {
			System.out.print(i + " ");
		}
	}
		
	
	static int[] reverseArray(int[] a) {
        int[] revArray = new int[a.length];
        int count = 0;
        for (int i = a.length; i > 0; i--){
            revArray[count] = a[(i-1)];
            count++;
        }
        return revArray;
    }

}
