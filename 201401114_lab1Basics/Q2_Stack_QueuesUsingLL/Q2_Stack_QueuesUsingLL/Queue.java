package Q2_Stack_QueuesUsingLL;

import Q1.Element;

public class Queue {

	LinkedList ll;
	
	
	public Queue() {
		this.ll = new LinkedList();
	}

	public void enqueue(int a){
		ll.addLast(a);		
	}
	
	public int dequeue(){
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

		public void addLast(int a){
			
			Element d=new Element(a);
			
			if(head==null){
				head=tail=d;
			}
			
			else {
				tail.setNext(d);
				d.setPrev(tail);
				tail=d;
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
			System.out.println("Queue is empty-dequeue not allowed");
			return -1;	
			}
		}	
		
		public void print(){
			if(head==null){
				System.out.println("Queue is empty");
				return;
			}				
			
			Element curr=head;
			
			while(curr!=null){
				System.out.println(curr.getKey());
				curr=curr.getNext();
			}
		}
	}
}
