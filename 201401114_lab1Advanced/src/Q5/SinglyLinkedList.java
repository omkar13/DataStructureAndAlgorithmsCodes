package Q5;

public class SinglyLinkedList {

	private Node head;

	public SinglyLinkedList() {
		this.head = null;
	}
	
	public Node getHead() {
		return head;
	}

	public void add(int age,String name){
		
		if(head==null){
			head=new Node(age,name);
			return;
		}
		
		Node curr=head;
		
		while(curr.getNext()!=null){
			curr=curr.getNext();
		}
			
		curr.setNext(new Node(age,name));
		
	}
	
	public SinglyLinkedList searchKey(int age){
		Node curr=head;
		SinglyLinkedList ll=new SinglyLinkedList();
		
		while(curr!=null){
			if(curr.getAge()==age){
				ll.add(age, curr.getName());
			}
			curr=curr.getNext();
		}
		return ll;
	}
	
	public void print(){
		Node curr=head;
		
		if(curr==null){
			System.out.println("list is empty");
			return;
		}
		
		
		while(curr!=null){
			System.out.print(curr.getAge() + " " + curr.getName() + " ,");
			curr=curr.getNext();
		}
		
		System.out.print("\n");
	}
	
}

class Node{
	
	private Node next;
	private String name;
	private int age;  		//here key is age
	
	public Node(int age,String name) {
		this.next = null;
		this.age = age;
		this.name=name;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
