package Q8;

import Q5.SinglyLinkedList;

public class LinkedList {

	private Node head;

	public LinkedList() {
		this.head = null;
	}
	
	public Node getHead() {
		return head;
	}

	public void add(String name, int age, int id, String school, String gender){
		
		if(head==null){
			head=new Node(name,age,id,school,gender);
			return;
		}
		
		Node curr=head;
		
		while(curr.getNext()!=null){
			curr=curr.getNext();
		}
			
		curr.setNext(new Node(name,age,id,school,gender));
		
	}
	
	public LinkedList search(String name, int age, int id, String school, String gender){
		Node curr=head;
		LinkedList ll=new LinkedList();
		
		while(curr!=null){
			if(curr.matchAtLeast3(name, age, id, school, gender)){
				ll.add(curr.getName(),curr.getAge(),curr.getId(),curr.getSchool(),curr.getGender());
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
			System.out.print(curr.getId()+ " ,");
			curr=curr.getNext();
		}
		
		System.out.print("\n");
	}
	
}


class Node{
	
	private Node next;
	private String name;
	private int age;  		
	private int id;
	private String school;
	private String gender;
	

	public Node(String name, int age, int id, String school, String gender) {
		this.name = name;
		this.age = age;
		this.id = id;
		this.school = school;
		this.gender = gender;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	
	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean matchAtLeast3(String name, int age, int id, String school, String gender){
		int count=0;
		
		if(this.name.equals(name))
			count++;
		
		if(this.age == age)
			count++;
		if(this.id == id)
			count++;
		if(this.school.equals(school))
			count++;
		if(this.gender.equals(gender))
			count++;
		
		if(count>=3)
			return true;
		else
			return false;
	}
}
