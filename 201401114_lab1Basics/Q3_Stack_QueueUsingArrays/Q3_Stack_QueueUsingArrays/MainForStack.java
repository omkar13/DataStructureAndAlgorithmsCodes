package Q3_Stack_QueueUsingArrays;

import java.util.Scanner;

public class MainForStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Stack s=new Stack(100);		//default size of stack is 100
		System.out.println("enter no of elements to be pushed in stack");
		int n=Integer.parseInt(sc.nextLine());
		
		for(int i=0;i<n;i++){
			s.push(Integer.parseInt(sc.nextLine()));			
		}
		
		System.out.println("the stack formed is:");
		s.print();
		
		System.out.println("enter no of elements to be popped from stack");
		n=Integer.parseInt(sc.nextLine());
		
		for(int i=0;i<n;i++){
			s.pop();
		}
		
		System.out.println("the modified stack is:");
		s.print();
		
	
	}

}
