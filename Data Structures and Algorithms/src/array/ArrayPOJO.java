package array;

public class ArrayPOJO {

	private int[] items;
	private int count;
	
	public ArrayPOJO(int length) {
		items = new int[length];
	}
	
	public void print() {
		for (int i = 0; i < count; i++) {
			System.out.println(items[i]);
		}
	}
	
	public void insert(int item) {
		// check to see if we need to expand the array
		if (items.length == count) {
			int[] newArray = new int[count * 2];
			// copy the old array to a new one
			for (int i = 0; i < count; i++) {
				newArray[i] = items[i];
			}
			items = newArray;
		}
		items[count++] = item;
	}
	
	public int indexOf(int item) { // run time complexity: O(n)
		// if we find the item, return the index
		// if not, return -1
		for (int i = 0; i < count; i++) {
			if (items[i] == item) {
				return i;
			}
		}
		return -1;
	}
	
	public void removeAt(int index) {
		// validate the input
		if ( index < 0 || index >= count) {
			throw new IndexOutOfBoundsException("index does not fit the size of the array.");
		}
		// shit items to the left to fill the missing item.
		for (int i = index; i < count; i++) {
			items[i] = items[i + 1];
		}
		count--;
	}
}
