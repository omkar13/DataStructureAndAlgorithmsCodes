package Q6_Q7;

public class DoublyLL {

	private Node head,tail;
	private int count;
	private Node pe1=null;
	private Node pe2=null;
	
	public DoublyLL() {
		this.head = null;
		this.tail = null;
		count=0;
	}
	
	public void add(int data){
		count++;
		if(head==null)
		{
			head=tail=new Node(data);
			return;
		}
		
		Node n=new Node (data);
		tail.setNext(n);
		n.setPrev(tail);
		tail=n;
		
	}
	
	public void reverseSublist(int p,int q){
		int i;
		Node curr=head;
		
		if(p==q)
			return;
		
		for(i=0;i<p;i++){
			curr=curr.getNext();
		}
		
		Node s=curr,temp;
		Node sPrev=s.getPrev();
		Node e=null;
		
		while(i<=q){
		if(i==q)	
			e=curr;
			temp=curr.getNext();
			curr.setNext(curr.getPrev());
			curr.setPrev(temp);
			i++;
			
			curr=curr.getPrev();
			
			}
		
		temp=s.getNext();
		s.setNext(e.getPrev());
		e.setPrev(temp);
		
		/*temp=sPrev.getNext();
		sPrev.setNext(curr.getPrev());
		curr.setPrev(temp);
		*/
		if(s==head){
			head=e;			
		}
		
		if(e==tail)
			tail=s;
		
		if(sPrev!=null){
			sPrev.setNext(e);
		}
		
		if(curr!=null){
			curr.setPrev(s);
		}
			
	}
	
	public void reverseSubSeq(int arr[]){
		
		 pe1=head;
		 pe2=tail;
		
		int p1=0,p2=arr.length-1;
		
		while(p1<p2){
			if(p1==0 && p2==arr.length-1)
				swap(arr[p1]-1,count-arr[p2]);						//input to swap method is m1,m2 where m1=no of right movements of pe1 so as to reach the next element to be swapped
			else																						//m2=no of left movements of pe2 so as to reach the next element to be swapped
				swap(arr[p1]-arr[p1-1],arr[p2+1]-arr[p2]);
			p1++;
			p2--;
		}

	}
	
	
	public void swap(int m1,int m2){
		
		System.out.println("m1:" + m1 + "  m2:" + m2);
		while(m1>0){
			pe1=pe1.getNext();			
			m1--;	
		}				//move pe1 by m1 times to right
		
		while(m2>0){
			pe2=pe2.getPrev();
			m2--;		//move pe2 by m2 times to left
		}
		
		System.out.println("pe1: "  + pe1.getData() + "  pe2: " +  pe2.getData());
		
		//............
		if(pe1==pe2)
			return;
			
		Node p_pe1=pe1.getPrev();
		Node n_pe1=pe1.getNext();
		Node p_pe2=pe2.getPrev();
		Node n_pe2=pe2.getNext();
		
		if(p_pe1!=null)
			p_pe1.setNext(pe2);
		
		n_pe1.setPrev(pe2);
		
		p_pe2.setNext(pe1);
		
		if(n_pe2!=null)
			n_pe2.setPrev(pe1);
		
		Node temp=pe1.getNext();
		pe1.setNext(pe2.getNext());
		pe2.setNext(temp);
		
		temp=pe1.getPrev();
		pe1.setPrev(pe2.getPrev());
		pe2.setPrev(temp);
		
		if(head==pe1)
			head=pe2;
		
		if(pe2==tail)
			tail=pe1;
		
		temp=pe1;
		pe1=pe2;
		pe2=temp;
		
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
	
	private Node next,prev;
	private int data;
	
	public Node(int data) {
		this.next = this.prev=null;
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
}
	