package Q1;

public class LinkedList {

	private Element head,tail;
	
	public LinkedList() {
		super();
		this.head = null;
		this.tail = null;
	}

	public void add(int a){
		
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
	
	public void search(int key){
	
		Element curr=head;
		int pos=0;
		System.out.print("Element with key: " + key + " is present at following positions :");
		
		while(curr!=null ){
			
			if(curr.getKey()==key){
				System.out.print(pos + ", ");				
			}			
			
			pos++;
			curr=curr.getNext();
		}
		System.out.println();				
	}
	
	public void delete(int key){
		
		Element curr=head;
		
		while(curr!=null )
			{
				
		if(curr.getKey()==key){
			
			if(curr==head){
				head=curr.getNext();
				head.setPrev(null);
			}
			
			else if(curr==tail){
				Element prev=curr.getPrev();
				prev.setNext(null);
				tail=prev;
			}
			
			else{
				Element prev=curr.getPrev();
				Element next=curr.getNext();
				prev.setNext(next);
				next.setPrev(prev);
			}
		
			}
		curr=curr.getNext();
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
