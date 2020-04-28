package mergeSort;

import javax.xml.soap.Node;

public class MergeSort {

	/*
	 *  Implement MergeSort
	 *  
	 *  we are dealing with linked list.
	 *  the input will be a node.
	 */
	
	/*
	 * if you are asked the permutation problem in an interview
	 * what is time complexity.
	 * we have a tree; the top level can make n children; the next level can make n-1 children, 
	 * next level can make n-2 children, and so on until base case of 1. 
	 * if you sum of the occurance you get a constant of n factorial .
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// top level method/function
	public Node sort(Node head) {
		// base case (obvious case)
		// if  node is a single linked list or is the node is empty
		if (head.getNextSibling() == null || head == null) {
			return head;
		}
		
		
		/*
		 * we need to cut the linked list in half. because merge works by chopping it in half recurse, chop it in half recurse.
		 * then our base case comes up. then we put the chopped halves back together.
		 * 
		 * talk about the abstract layers to show you understand the concepts because the interviewer will know but may not know the specifics or the special cases.
		 */
		
		// new text layer
		// we need to cut the linked list in half. we will call this method mid. get the middle node and cut the linked list physically. we will patch it linked list back together.
		// we want to sort the left half and the right half
		
		// head represents the left half
		// midpoint represents right half
		// recursive case
		Node mid = getMiddleAndSplit(head); // sub routine(sub method)
		Node leftHalf = sort(head);
		Node rightHalf = sort(mid);
		// this recursion will drill down until the base case returns. then we will have resolved halves (values). once we have resolved values, then we can operate on them.
		// then we will merge the two halves of sorted values making a sorted array.
		
		// then return the left half and right half.
		// sew them back together.
		return merge(leftHalf, rightHalf); // sub routine(sub method)
		
	}

	private Node merge(Node leftHalf, Node rightHalf) {
		// TODO Auto-generated method stub
		return null;
	}

	private Node getMiddleAndSplit(Node head) {
		// TODO Auto-generated method stub
		return null;
	}

}
