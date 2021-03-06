package list;

/*
 * Link list - each item in a linked list is attached to the one next to it.
 * each item in the list is called a node.
 * nodes only knows about the nodes that it's connected to(left& right).
 * link list holds a value and the other is an address of the next node in the list.
 * 
 * You can insert and remove any nodes in the list in any order.
 * You can have multiple of the duplicate nodes in the list.
 * 	this is not allowed in sets.
 * 
 * List methods												Big O
 * 															 
 * add - add data(node) to the list.						O(1)
 * remove - remove data from the list.						O(1)
 * insert - inserts data in between two nodes.				O(n)
 * removeAt - removes data at a certain index.				O(n)
 * indexOf - checks to see if the data exist in the list.	O(n)
 * get - return the data(node).								O(n)
 */

public class LinkedListPOJO<X> {

	private Node first;
	private Node last;
	private int nodeCount;

	public LinkedListPOJO() {
		this.first = null;
		this.last = null;
		this.nodeCount = 0; 
	}

	public int size() {
		return nodeCount;
	}

	public X get(int position) { // Big O = O(n)
		// check to see if linked list is empty
		if (first == null) {
			throw new IllegalStateException("LinkedList is empty and there are no items to get");
		}

		Node currentNode = first;
		for (int i = 1; i < size() && currentNode != null; i++) {
			// check to see if position exist
			if (i == position) {
				return currentNode.getNodeItem();
			}
			// if not get the next node
			currentNode = currentNode.getNextNode();
		}
		// if we didnt find it then return null
		return null;

	}

	public int indexOf(X item) { // Big O = O(n)
		// check to see if linked list is empty
		if (first == null) {
			throw new IllegalStateException("LinkedList is empty and there are no items to find");
		}

		Node currentNode = first;
		for (int i = 1; i < size() && currentNode != null; i++) {
			// check for match
			if (item.equals(currentNode.getNodeItem())) {
				return i;
			}
			// if not, get the next node
			currentNode = currentNode.getNextNode();
		}
		// return -1 if nothing found.
		return -1;
	}

	public void add(X item) {
		// check to see if we are adding something for the first time
		if (first == null) {
			first = new Node(item);
			last = first;
		}
		// otherwise, we want to grab the last node and update its value
		else {
			Node newLastNode = new Node(item);
			last.setNextNode(newLastNode);
			last = newLastNode;
		}
		// update the node count.
		nodeCount++;
	}

	public void addFirst(X item) {
		// check to see if we are adding something for the first time
		if (first == null) {
			first = new Node(item);
			last = first;
		}
		// otherwise, grab the first node and update its value
		else {
			Node newFirstNode = new Node(item);
			newFirstNode.setNextNode(first);
			first = newFirstNode;
		}
		// update the node count
		nodeCount++;
	}
	
	public void addLast(X item) {
		// check to see if we are adding something for the first time
		if (first == null) {
			first = new Node(item);
			last = first;
		}
		// otherwise, grab the last node and update its value
		else {
			Node newLastNode = new Node(item);
			last.setNextNode(newLastNode);
			last = newLastNode;
		}
		// update the node count
		nodeCount++;
	}

	public void insert(X item, int position) { // Big O = O(n)
		// check to see if there are enough nodes for the position
		if (position > size()) {
			throw new IllegalStateException("inserting index larger that linked list size.");
		}
		Node currentNode = first;

		// start at 1 because we are already on the first node
		for (int i = 1; i < position && currentNode != null; i++) {
			currentNode = currentNode.getNextNode();
		}

		// severs the link chain and reconnects it with new nodes
		Node newNodeItem = new Node(item);
		Node nextNode = currentNode.getNextNode();

		currentNode.setNextNode(newNodeItem);
		newNodeItem.setNextNode(nextNode);

		// update out node count
		nodeCount++;
	}

	public X removeAt(int position) { // Big O = O(n)
		// check to see if there are enough nodes for the position
		if (first == null) {
			throw new IllegalStateException("removing index larger that linked list size.");
		}

		Node currentNode = first;
		Node prevNode = first;
		// start at 1 because we are already on the first node
		// this will get the node before we the node we want to remove
		for (int i = 1; i < position && currentNode != null; i++) {
			prevNode = currentNode;
			currentNode = currentNode.getNextNode();
		}

		// now update the pointers and throw away the old first
		X nodeItem = currentNode.getNodeItem();
		prevNode.setNextNode(currentNode.getNextNode());
		nodeCount--;
		return nodeItem;

	}
	
	public X removeLast() { // Big O = O(n)
		// check to see if there are enough nodes for the position
		if (first == null) {
			throw new IllegalStateException("removing index larger that linked list size.");
		}

		Node currentNode = first;
		Node prevNode = first;
		
		// start at 1 because we are already on the first node
		// this will get the node before we the node we want to remove
		for (int i = 1; i < size() && currentNode != null; i++) {
			prevNode = currentNode;
			currentNode = currentNode.getNextNode();
			

		}
		// update the last node
		last = prevNode;
		last.nextNode = null;
		nodeCount--;

		// now return the old last node
		X nodeItem = currentNode.getNodeItem();
		return nodeItem;

	}

	public X remove() { // Big O = O(n)
		// remove the first node off the list

		// check to see if there are any nodes in linked list
		if (first == null) {
			throw new IllegalStateException("This Linked List has no nodes to be removed.");
		}
		X nodeToReturn = first.getNodeItem();

		first = first.getNextNode();
		nodeCount--;
		return nodeToReturn;
	}


	
	// prettier toString print
	public String toString() {
		StringBuffer contents = new StringBuffer();
		Node currentNode = first;

		while (currentNode != null) {
			contents.append(currentNode.getNodeItem());
			currentNode = currentNode.getNextNode();

			if (currentNode != null) {
				contents.append(", ");
			}
		}
		return contents.toString();
	}

	private class Node {
		// fields
		private Node nextNode;
		private X nodeItem;

		public Node(X item) {
			this.nextNode = null;
			this.nodeItem = item;
		}

		public void setNextNode(Node nextNode) {
			this.nextNode = nextNode;
		}

		public Node getNextNode() {
			return nextNode;
		}

		public X getNodeItem() {
			return nodeItem;
		}
	}
}
