package Q1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner (System.in);
		System.out.println("enter heap elements in order");
		int n=sc.nextInt();
		sc.nextLine();
		String in[]=sc.nextLine().split(" ");
		int arr[]=new int [n];
		
		for(int i=0;i<n;i++){
			arr[i]=Integer.parseInt(in[i]);
		}

		int i=sc.nextInt();
	
		int parentIndex=(int)Math.floor((i-1)/2.0);
		
		if(parentIndex>=0)	
			System.out.println("parent is: " + arr[parentIndex]);
		else
			System.out.println("parent doesnt exist");
		
		int leftChildIndex=2*i+1;
	
		if(leftChildIndex<arr.length)
			System.out.println("left child is: " + arr[leftChildIndex]);
		else
			System.out.println("left child doesnt exist");
		
		int rightChildIndex=2*i+2;
		
		if(rightChildIndex<arr.length)
			System.out.println("right child is: " + arr[rightChildIndex]);
		else
			System.out.println("right child doesnt exist");
		
		
		
	}

}
