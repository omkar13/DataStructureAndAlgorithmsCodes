package Q2_advanced;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		SinglyLinkedList ll=new SinglyLinkedList();
		Scanner sc=new Scanner(System.in);
				
		System.out.println("enter no of elements to add");
		int n=Integer.parseInt(sc.nextLine());
		
		for(int i=0;i<n;i++){
			ll.add(Integer.parseInt(sc.nextLine()));
		}
		
		ll.print();
		
		ll.reverse();
		
		ll.print();
		
		
	}

}
