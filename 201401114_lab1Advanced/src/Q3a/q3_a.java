package Q3a;

import java.util.Scanner;

import Q1_advanced.Stack;

public class q3_a {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		System.out.println("enter size of stack");
		Stack s=new Stack(Integer.parseInt(sc.nextLine()));		
		System.out.println("enter no of elements to be pushed in stack");
		int n=Integer.parseInt(sc.nextLine()),p,q;
		
		for(int i=0;i<n;i++){
			s.push(Integer.parseInt(sc.nextLine()));			
		}
		
		System.out.println("the stack formed is:");
		s.print();
	
		System.out.println("enter index of elements to be exchanged");
		String in[]=sc.nextLine().split(" ");
		p=Integer.parseInt(in[1]);
		q=Integer.parseInt(in[0]);
		
		exchange(p,q,s);
		s.print();
		
	}
	
	public static void exchange(int p,int q,Stack s){
		
		Stack s1=new Stack(s.getCount());
		Stack s2=new Stack(s.getCount());
		
		int topIndex=s.getCount()-1;
		
		do{
			s1.push(s.pop());
			topIndex--;			
		}while(topIndex+1!=p);
		
		
		do{
			s2.push(s.pop());
			topIndex--;			
					
		}while(topIndex+1!=q);
	
		s.push(s1.pop());
		s1.push(s2.pop());
		
		while(s2.isEmpty()!=true){
			s.push(s2.pop());
		}
		
		while(s1.isEmpty()!=true){
			s.push(s1.pop());
		}
		
	}

}
