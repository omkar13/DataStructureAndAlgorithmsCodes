package Q6_Q7;

import java.util.Scanner;

public class MainQ7 {

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
		System.out.println("enter no of elements in subsequence");
		int m=Integer.parseInt(sc.nextLine());
		System.out.println("enter indices(1 based) of subsequence to be reversed");
		
		String in[]=sc.nextLine().split(" ");
		int arr[]=new int[m];
		
		for(int j=0;j<m;j++){
			arr[j]=Integer.parseInt(in[j]);
		}
		
		ll.reverseSubSeq(arr);			//this algo takes O(n) time because it scans the entire linked list at most once
		
		ll.print();
		
		sc.close();
	
	}

	
	
}
