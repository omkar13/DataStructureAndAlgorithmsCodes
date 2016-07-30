package Q10;

public class ModifiedListDS {

	
	private Node head;
	private int n;

	public ModifiedListDS() {
		this.head = null;
		n=0;
	}
	
	public Node getHead() {
		return head;
	}

	public void add(int data){
		
		if(head==null){
			head=new Node(data);
			n++;
			return;
		}
		
		Node curr=head;
		
		while(curr.getNext()!=null){
			curr=curr.getNext();
		}
			
		curr.setNext(new Node(data));
	n++;	
	}
	
	public int delete(){
		
		if(n<=8)
			return deleteFirst();			
													//delete according to queue
		else
			return deleteLast();	
		
	}
	
	public int deleteFirst(){
		
		if(head!=null){
			int x=head.getData();
			head=head.getNext();
			n--;
			return x;
		}
			
		else
		{
			System.out.println("underflow");
			return -1;
		}
	}
	
	public int deleteLast(){
		
		Node curr=head;
		
		if(n==1){
			n--;
			int x=head.getData();
			head=null;
			return x;
		}
		
		while(curr.getNext().getNext()!=null){
			curr=curr.getNext();
		}
		
		int x=curr.getNext().getData();
		n--;
		curr.setNext(null);
		
		return x;
	}
	
	public void print(){
		Node curr=head;
		
		if(curr==null){
			System.out.println("list is empty");
			return;
		}
		
		
		while(curr!=null){
			System.out.print(curr.getData() + " ");
			curr=curr.getNext();
		}
		
		System.out.print("\n");
	}

	
}



class Node{
	
	private Node next;
	private int data;  		
	
	public Node(int data) {
		this.next = null;
		this.data=data;
		
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