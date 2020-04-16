package list;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoSortedList {

	/*
	 * Merge two sorted linked lists and return it as a new list. 
	 * The new list should be made by splicing together the nodes of the first two lists.
	 */
	public static void main(String[] args) {
		List<Integer> ar1 = new ArrayList<>();
		List<Integer> ar2 = new ArrayList<>();
		List<Integer> ar3 = new ArrayList<>();
		
		
		ar1.add(1);
		ar1.add(3);
		ar1.add(5);
		
		ar2.add(2);
		ar2.add(4);
		ar2.add(6);
		

		
		for (int i = 0; i < ar1.size(); i++) {

			ar3.add(ar1.get(i));
			ar3.add(ar2.get(i));
		}
		
		for (Integer num : ar3) {
			System.out.print(num + " ");
		}
		
	}

}
