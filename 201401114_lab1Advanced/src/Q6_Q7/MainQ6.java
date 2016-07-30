package Q6_Q7;

import java.util.Scanner;

public class MainQ6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DoublyLL ll=new DoublyLL();
		Scanner sc=new Scanner(System.in);
				
		System.out.println("enter no of elements to add");
		int n=Integer.parseInt(sc.nextLine());
		
		for(int i=0;i<n;i++){
			ll.add(Integer.parseInt(sc.nextLine()));
		}
		
		ll.print();
		System.out.println("enter end indices of sublist to be reversed");
		String in[]=sc.nextLine().split(" ");
		int p=Integer.parseInt(in[0]);
		int q=Integer.parseInt(in[1]);
		
		ll.reverseSublist(p, q);
			
		ll.print();
		
		sc.close();
	}

}
