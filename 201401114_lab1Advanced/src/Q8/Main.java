package Q8;

import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList ll=new LinkedList();
		Scanner sc=new Scanner(System.in);
				
		System.out.println("enter no of elements to add");
		int n=Integer.parseInt(sc.nextLine());
		String in[];
		
		for(int i=0;i<n;i++){
			in=sc.nextLine().split(" ");
			ll.add(in[0],Integer.parseInt(in[1]),Integer.parseInt(in[2]),in[3],in[4]);
		}
		
		ll.print();
		System.out.println("enter search parameters");
		in=sc.nextLine().split(" ");
		ll.search(in[0],Integer.parseInt(in[1]),Integer.parseInt(in[2]),in[3],in[4]).print();
		
		
	}

}
