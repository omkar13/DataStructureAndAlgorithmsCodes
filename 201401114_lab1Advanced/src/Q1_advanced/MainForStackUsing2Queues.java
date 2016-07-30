package Q1_advanced;

import java.util.Scanner;

public class MainForStackUsing2Queues {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter size of stack");
		StackUsing2Queues s=new StackUsing2Queues(Integer.parseInt(sc.nextLine()));		
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
