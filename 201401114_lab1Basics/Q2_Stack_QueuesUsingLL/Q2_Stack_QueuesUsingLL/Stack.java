package Q2_Stack_QueuesUsingLL;

import Q1.Element;

public class Stack {

	LinkedList ll;
	
	
	public Stack() {
		this.ll = new LinkedList();
	}

	public void push(int a){
		ll.addFirst(a);		
	}
	
	public int pop(){
		return ll.removeFirst();
	}
	
	public void print(){
		ll.print();
	}
	
public class LinkedList{
	private Element head,tail;
	
	public LinkedList() {
		super();
		this.head = null;
		this.tail = null;
	}

	public void addFirst(int a){
		
		Element d=new Element(a);
		
		if(head==null){
			head=tail=d;
		}
		
		else {
			head.setPrev(d);
			d.setNext(head);
			head=d;			
		}		
	}
	
	public int removeFirst(){
		if(head!=null){
			Element first=head;
			head=head.getNext();
		
			if(head!=null)
			head.setPrev(null);
			else
			tail=null;
			return first.getKey();
		}
		
		else
		{
		System.out.println("Stack is empty-pop not allowed");
		return -1;	
		}
	}	
	
	public void print(){
		Element curr=head;
		
		while(curr!=null){
			System.out.println(curr.getKey());
			curr=curr.getNext();
		}
	}
}

}