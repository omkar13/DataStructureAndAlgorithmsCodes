package Q5;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyLinkedList ll=new SinglyLinkedList();
		Scanner sc=new Scanner(System.in);
				
		System.out.println("enter no of elements to add");
		int n=Integer.parseInt(sc.nextLine());
		String in[];
		
		for(int i=0;i<n;i++){
			in=sc.nextLine().split(" ");
			ll.add(Integer.parseInt(in[0]),in[1]);
		}
		
		ll.print();
		System.out.println("enter key to be searched");
		int k=Integer.parseInt(sc.nextLine());
		
		ll.searchKey(k).print();;
		
	}

}
