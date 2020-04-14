package hashes;

public class HashTablePOJO<X,Y> {

	private HashEntry[] data;
	private int capacity;
	private int size;
	
	
	public HashTablePOJO(int tableSize) {
		this.capacity = tableSize;
		this.data = new HashEntry[this.capacity];
		this.size = 0;
	}
	
	public int size() {
		return this.size;
	}
	
	public Y get(X key) {
		int hash = calculateHash(key);
		
		// if we dont have anything for the given key, just return null
		if(data[hash] == null) {
			return null;
		}
		// otherwise get the hash entry for the key and return its value
		else {
			return (Y) data[hash].getValue();
		}
	}
	
	public void put(X key, Y value) {
		int hash = calculateHash(key);
		
		data[hash] = new HashEntry<X, Y>(key, value);
		size++;
	}
	
	private int calculateHash(X key) {
		int hash = (key.hashCode() % this.capacity);
		
		// this is necessary to deal with collisions
		while(data[hash] != null && !data[hash].getKey().equals(key)) {
			hash = (hash + 1 ) % this.capacity;
		}
		return hash;
	}
	
	//*************************************************************
	
	private class HashEntry<X,Y> {
		private X key;
		private Y value;
		
		public HashEntry(X key, Y value) {
			super();
			this.key = key;
			this.value = value;
		}
		public X getKey() {
			return key;
		}
		public void setKey(X key) {
			this.key = key;
		}
		public Y getValue() {
			return value;
		}
		public void setValue(Y value) {
			this.value = value;
		}
		
		
	}
}
