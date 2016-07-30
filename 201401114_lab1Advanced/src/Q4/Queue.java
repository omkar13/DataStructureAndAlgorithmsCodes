package Q4;
public class Queue<Type> {

	LinkedList ll;
	
	
	public Queue() {
		this.ll = new LinkedList();
	}

	public void enqueue(Type a){
		ll.addLast(a);		
	}
	
	public Type dequeue(){
		return ll.removeFirst();
	}
	
	public void print(){
		ll.print();
	}
	
	public boolean isEmpty(){
		
		return ll.isEmpty();
		
	}
	public class LinkedList{
		private Element<Type> head,tail;
		
		public LinkedList() {
			super();
			this.head = null;
			this.tail = null;
		}

		public void addLast(Type a){
			
			Element<Type> d=new Element<Type>(a);
			
			if(head==null){
				head=tail=d;
			}
			
			else {
				tail.setNext(d);
				d.setPrev(tail);
				tail=d;
			}
			
		}
		public Type removeFirst(){
			if(head!=null){
				Element<Type> first=head;
				head=head.getNext();
			
				if(head!=null)
				head.setPrev(null);
				else
				tail=null;
				return first.getKey();
			}
			
			else
			{
			System.out.println("Queue is empty-dequeue not allowed");
			return null;	
			}
		}
		
		public boolean isEmpty(){
			if(head==null)
				return true;
			else
				return false;
		}
		
		public void print(){
			if(head==null){
				System.out.println("Queue is empty");
				return;
			}				
			
			Element<Type> curr=head;
			
			while(curr!=null){
				System.out.print(curr.getKey() + " ");
				curr=curr.getNext();
			}
			System.out.println();
		}
	}
}

class Element <Type>{

	private Type key;
	private Element<Type> next,prev;
	
	public Element(Type data) {
		super();
		this.key = data;
		this.next = null;
		this.prev=null;
	}

	public Type getKey() {
		return key;
	}

	public void setKey(Type data) {
		this.key = data;
	}

	public Element<Type> getNext() {
		return next;
	}

	public void setNext(Element<Type> next) {
		this.next = next;
	}

	public Element<Type> getPrev() {
		return prev;
	}

	public void setPrev(Element<Type> prev) {
		this.prev = prev;
	}
	
	
	
	
}