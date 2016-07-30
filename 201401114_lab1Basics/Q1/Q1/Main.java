package Q1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		LinkedList ll=new LinkedList();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter no of elements");
		int n=sc.nextInt();
		sc.nextLine();
		
		for(int i=0;i<n;i++){
			ll.add(Integer.parseInt(sc.nextLine()));			
		}
		
		System.out.println("the linked list formed is:");
		ll.print();
		
		System.out.println("enter element to be searched");
		int x=Integer.parseInt(sc.nextLine());
		ll.search(x);
		//System.out.println("Pos of element is " + ll.search(x));
		
		System.out.println("enter element key to be deleted");
		x=Integer.parseInt(sc.nextLine());
		ll.delete(x);
		System.out.println("modified linked list is:");
		ll.print();
		//ll.delete(8);
		//ll.print();
		sc.close();
	}

}
