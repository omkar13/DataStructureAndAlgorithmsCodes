package Q1;

public class Element {

	private int key;
	private Element next,prev;
	
	public Element(int data) {
		super();
		this.key = data;
		this.next = null;
		this.prev=null;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int data) {
		this.key = data;
	}

	public Element getNext() {
		return next;
	}

	public void setNext(Element next) {
		this.next = next;
	}

	public Element getPrev() {
		return prev;
	}

	public void setPrev(Element prev) {
		this.prev = prev;
	}
	
	
	
	
}
