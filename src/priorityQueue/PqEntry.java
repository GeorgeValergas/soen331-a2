package priorityQueue;

/**
 * 
 * Entry objects for priority queue.
 * 
 */
public class PqEntry {
	private int key;
	private String element;
	
	public PqEntry(int key, String element) {
		this.key = key;
		this.element = element;
	}
	

	public int getKey() { return this.key;}
	
	public String getElement() {return this.element;}
	
}
