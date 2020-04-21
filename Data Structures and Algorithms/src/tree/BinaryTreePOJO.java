package tree;

public class BinaryTreePOJO<X extends Comparable<X>> {
	
	private Node root;
	private int size;


	public BinaryTreePOJO() {
		this.root = null;
	}
	
	public int size() {
		return size;
	}
	
	public void add(X item) {
		Node node = new Node(item);
		
		// if this is the first item in the tree, set it as the root
		if (root == null) {
			this.root = node;
			System.out.println("Set root: " + node.getItem());
			size++;
		}
		// otherwise we need to insert the item into the tree using the binary tree insert algorithm
		else {
			insert(this.root, node);
		}
	}
	
	private void insert(Node parent, Node child) {
		// if the child is less than the parent, it goes on the left
		if (child.getItem().compareTo(parent.getItem() ) < 0 ) {
			// if the left node is null, we've found our spot
			if(parent.getLeft() == null) {
				parent.setLeft(child);
				child.setParent(parent);
				this.size++;
			}
			// otherwise we need to call insert again and test for left or right (recursion)
			else {
				insert(parent.getLeft(), child);
			}
		} 
		// if the child is  greater than the parent, it goes on the right
		else if (child.getItem().compareTo(parent.getItem() ) > 0) {
			// if the right node is null, we've found our spot
			if (parent.getRight() == null ) {
				parent.setRight(child);
				child.setParent(parent);
				this.size++;
			}
			// otherwise, we need to call insert again and test for left or right (recursion)
			else {
				insert(parent.getRight(), child);
			}
		}
		// if the parent and child happened to be equal, we don't do anything
		// data in a binary tree is assumed to be unique and the value already
		// exists in the tree
		else {
			throw new IllegalArgumentException("data already exists in the tree.");
		}
		
	}

	private class Node {
		private Node left;
		private Node right;
		private Node parent;
		private X item;

	public Node(X item) {
		this.item = item;
		this.left = null;
		this.right = null;
		this.parent = null;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public X getItem() {
		return item;
	}

	public void setItem(X item) {
		this.item = item;
	}
	
	
	}
	
}
