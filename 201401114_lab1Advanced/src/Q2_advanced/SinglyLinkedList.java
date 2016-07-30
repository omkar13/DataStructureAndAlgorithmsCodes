package Q2_advanced;

public class SinglyLinkedList {

	private Node head;

	public SinglyLinkedList() {
		this.head = null;
	}
	
	public void add(int a){
		
		if(head==null){
			head=new Node(a);
			return;
		}
		
		Node curr=head;
		
		while(curr.getNext()!=null){
			curr=curr.getNext();
		}
			
		curr.setNext(new Node(a));
		
	}
	
	public void print(){
		Node curr=head;
		
		while(curr!=null){
			System.out.print(curr.getData() + " ");
			curr=curr.getNext();
		}
		
		System.out.print("\n");
	}
	
	public void reverse(){
		Node prev=null;
		Node curr=head;
		Node next=head;			//handle empty ll
		
		while(curr!=null){
			next=curr.getNext();
			curr.setNext(prev);
			prev=curr;
			curr=next;			
		}
		
		head=prev;
	}
	
}

class Node{
	
	private Node next;
	private int data;
	
	public Node(int data) {
		this.next = null;
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
	
	
	
}

