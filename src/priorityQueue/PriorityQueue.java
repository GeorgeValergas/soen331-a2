package priorityQueue;

/*
 * [√] Valid queue Objects SHOULD HAVE a capacity of at least 3
 * [√] Implementation: Binary Max Heap (Implemented using an Array)
 * [√] Each Node consists of an integer key and String value
 * ]
 */
public class PriorityQueue {

	// Array of Entries making up priority queue
	private PqEntry[] priorityQueue;
	private int size = 0;

	// INTERFACE
	public int size() {
		return size;
	}

	public boolean isEmpty() {
		if (priorityQueue.length == 0) {
			return true;
		}
		return false;
	}

	public void insert(int key, String element) {
		// 1- create entry
		PqEntry entry = new PqEntry(key, element);
		// 2- add entry to priorityQueue as bottom rightmost node
		// (Array.push(element) doesn't exist c: )
		priorityQueue[size] = entry;
		// ADD ASSERTION HERE- PqEntry Object should have been added to array
		// 3- maintain heap order (private method)
		upheap(this.size);
		// 4- increment size
		this.size++;
	}

	public PqEntry remove() {
		// 1- Cache element at index 0
		PqEntry max = priorityQueue[0];
		// 2- Move last element to index 0
		priorityQueue[0] = priorityQueue[size];
		// 3- maintain heap order (private method)
		downHeap();
		// 4- Return cached element
		return max;

	};

	 public PqEntry getMax() {return priorityQueue[0];};

	// constructor
	// ADD INVARIANT - Minimum capacity for Priority Queue objects is 3
	// - size <= capacity
	public PriorityQueue(int capacity) {
		// create priority queue of desired size
		PqEntry[] priorityQueue = new PqEntry[capacity];
	}

	// private methods

	/**
	 *  maintains heap order upon insertion of element
	 * @param childIndex
	 */
	private void upheap(int childIndex) {
		int parentIndex;
		do {
			parentIndex = (childIndex - 1) / 2;
			if (priorityQueue[childIndex].getKey() > priorityQueue[parentIndex]
					.getKey()) {
				swap(parentIndex, childIndex);
				// parent is new Child
				childIndex = parentIndex;
			} else
				break;
		} while (parentIndex != 0);
	}

	/**
	 * Switches the assignment of two array elements2
	 * @param index1
	 * @param index2
	 */
	private void swap(int index1, int index2) {
		PqEntry temp = priorityQueue[index1];
		priorityQueue[index1] = priorityQueue[index2];
		priorityQueue[index2] = temp;
	}

	// maintains heap order upon removal of element
	private void downHeap() {
		int parentIndex = 0;
		int biggerSiblingIndex;
		do {
			int leftChildIndex = ((parentIndex) * 2) + 1;
			int rightChildIndex = leftChildIndex + 1;
			// compare left and right, find bigger, compare with parent, swap else
			// break.
			if (priorityQueue[leftChildIndex].getKey() <= priorityQueue[rightChildIndex].getKey()) {
				biggerSiblingIndex = rightChildIndex;
			} else {
				biggerSiblingIndex = leftChildIndex;
			}
			if (priorityQueue[parentIndex].getKey() < priorityQueue[biggerSiblingIndex].getKey()) {
				swap(biggerSiblingIndex, parentIndex);
				parentIndex = biggerSiblingIndex;			
			}else {break;}
		}while(priorityQueue[biggerSiblingIndex] != null && priorityQueue[parentIndex].getKey() < priorityQueue[biggerSiblingIndex].getKey());

	}

	public static void main(String[] args) {
		PriorityQueue q = new PriorityQueue(3);

		System.out.println(q);
	}

}
