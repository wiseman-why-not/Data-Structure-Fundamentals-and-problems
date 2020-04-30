package array;

public class Rotating2DMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = new int[3][3];
		arr[0][0] = 10;
		arr[0][1] = 12;
		arr[0][2] = 14;
		
		arr[1][0] = 20;
		arr[1][1] = 22;
		arr[1][2] = 24;
		
		arr[2][0] = 30;
		arr[2][1] = 32;
		arr[2][2] = 34;
		
		print2DArray(arr); 
		System.out.println("========================");
		rotate2DArray(arr);
		print2DArray(arr);
		
	}

	public static int[][] rotate2DArray(int[][] matrix) {

		//
		int lastIndex = matrix.length - 1;
		System.out.println("lastIndex is :" + lastIndex);

		for (int layer = 0; layer < (matrix.length / 2); layer++) {
			for (int i = layer; i < lastIndex - layer; i++) {

				int top = matrix[layer][i]; 							// [0,0][0,1][0,2][0,3] 
				int right = matrix[i][lastIndex - layer]; 				// [1,0][1,1][1,2][1,3]
				int bottom = matrix[lastIndex - layer][lastIndex - i]; 	// [2,0][2,1][2,2][2,3]
				int left = matrix[lastIndex - i][layer]; 				// [3,0][3,1][3,2][3,3]
				
				matrix[layer][i] = left;
				matrix[i][lastIndex - layer] = top;
				matrix[lastIndex - layer][lastIndex - i] = right;
				matrix[lastIndex - i][layer] = bottom;
			}
		}
		
		return matrix;

	}
	
	public static void print2DArray(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + "|");
				if (j == 2) {
					System.out.println();
				}
			}
		}
	}
}
