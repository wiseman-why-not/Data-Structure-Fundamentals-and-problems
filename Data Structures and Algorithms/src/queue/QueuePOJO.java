package queue;

public class QueuePOJO<X> {

/*	A Queue is an ordered line or sequence.
	Queue characteristics: 											   Big O?
		FIFO rule - First In, First Out.
		
		enQueue - insert, or enQueue data on the Queue.					O(1)
		deQueue - delete, remove, or deQueue data off the Queue.		O(1)
		Search - Search data in the Queue.								O(n)
		Access - Access data within the Queue.							O(n)
		
		
*/
	
	private X[] data;
	
	// Array pointer location for the data array. beginning and the end of the queue lies on the data array 
	private int front;
	private int end;
	
	public QueuePOJO() {
		this(1000);
	}
	
	public QueuePOJO(int size) {
		// since array start at zero, the number for an empty queue is -1
		this.front = -1;
		this.end = -1;
		data = (X[]) new Object[size];
	}
	
	public int size() {
		// if the queue is empty return 0.
		if (front == -1 && end == -1) {
			return 0;
		} else {
			return end - front + 1;
		}
	}
	
	public void enQueue(X item) {
		// check to see if the Queue is full
		if ((end + 1) % data.length == front) {
			throw new IllegalStateException("Queue is full");
		}
		else if (size() == 0) {
			this.front++;
			this.end++;
			data[end] = item;
		} else {
			this.end++;
			data[end] = item;
		}
	}
	
	public X deQueue() {
		X item = null;
		
		// check to see if there are anything items in Queue
		if (size() == 0) {
			throw new IllegalStateException("Queue is empty");
			
		} 
		// check to see if its the last item in Queue, if so, reset pointers
		else if(front == end) {
			item = data[front];
			data[front] = null;
			front = -1;
			end = -1;
		}
		else {
			item = data[front];
			data[front] = null;
			front++;
		}
		return item;
	}
	
	public boolean contains(X item) {
		boolean result = false;
		
		// if the Queue is empty, return false
		if (size() == 0) {
			return result;
		}
		for (X xItem : data) {
			if (xItem.equals(item) ) {
				result = true;
				break;
			}
		} 
		return result;
	}
	
	public X access(int position) {
		// check to see if Queue is empty or position given is not within the size of the Queue
		if (size() == 0 || position > size() ) {
			throw new IllegalArgumentException("No items in the Queue or position greater than size of Queue.");
		}
		
		int trueIndex = 0;
		for(int i = front; i < end; i++) {
			if(trueIndex == position) {
				return data[i];
			}
			trueIndex++;
		}
		
		// if we didnt find the item, throw exception
		throw new IllegalArgumentException("could not get queue item at position: " + position);
	}
}
