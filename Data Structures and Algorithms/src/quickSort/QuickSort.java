package quickSort;

public class QuickSort {
	
	/*
	 * 			Quick Sort
	 * 	Best case O(n * log n)
	 * 	Worst case O(nˆ2) O(n squared)
	 * 
	 * 	This sorting algorithm uses the idea of divide and conquer.
	 * 
	 * 	It finds the element called the PIVOT, which divides the array into two halves
	 * 	in such a way that elements in the left half are smaller than the pivot;
	 * 	and the elements in the right half are greater than the pivot.
	 * 
	 * 	We follow three steps recursively:
	 * 	1. Find the pivot that divides the array into two halves.
	 * 	2. Quick sort the left half.
	 * 	3. Quick sort the right half.
	 * 
	 * 
	 * 	Pivot: the value within the partitioning space that I want to find a position for.
	 * 
	 * 	bad pivots are either the largest or smallest item in the array
	 * 	
	 */

	
	public static void quickSort(int[] arr, int left, int right) {
		int index = partition(arr, left, right);
		
		if (left < index -1) { // Sort left half
			quickSort(arr, left, index -1);
		}
		
		if (index < right ) { // Sort right half
			quickSort(arr, index, right);
		}
	}

	// partition is to divide into parts.
	// the job of the partition method is to find a position for the pivot.
	// once we found the position for the pivot, we return that index of that position
	// so that split subroutine knows where to chop the array. 
	private static int partition(int[] arr, int left, int right) {
		// Pivot: the value within the partitioning space that I want to find a position for.
		int pivot = arr[left + (right - left) / 2]; // Pick pivot point
		
		while (left <= right) {
			// Find element on the left that should be on the right
			while (arr[left] < pivot) {
				left++;
			}
			
			// Find element on the right that should be on the left
			while (arr[right] > pivot) {
				right--;
			}
			
			// swap elements, and move left and right indices
			if (left <= right) {
				swap(arr, left, right); // swaps elements
				left++;
				right--;
			}
		}
		return left;
	}

	private static void swap(int[] arr, int left, int right) {
		int tempNum = arr[left];
		arr[left] = arr[right];
		arr[right] = tempNum;
		
	}

}
