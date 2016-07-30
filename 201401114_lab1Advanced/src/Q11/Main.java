package Q11;

import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner (System.in);
		System.out.println("enter size of stack");
		int n=sc.nextInt();
		sc.nextLine();
		Stack s=new Stack(n);
		
		System.out.println("enter no of elements to push");
		int m=sc.nextInt();
		sc.nextLine();
		
		for(int i=0;i<m;i++)
			s.push(sc.nextInt());
		sc.nextLine();
		
		System.out.println("Stack formed:");
		s.print();
	
		Stack newStack=new Stack(m);
		move(s,newStack,m);
		
		System.out.println("After shifting, old Stack ");
			s.print();
		System.out.println("new Stack ");			
			newStack.print();
		
	}

	public static void move(Stack st1,Stack st2,int n){
		Stack temp=new Stack(n);
		shift(st1,st2,temp,n);
		
	}
	
	public static void shift(Stack from,Stack to,Stack pole,int n){
		
	if(n==1){
		to.push(from.pop());
		return;
	}
	//tower of hanoi technique used
		shift(from,pole,to,n-1);		
		shift(from,to,pole,1);
		shift(pole,to,from,n-1);
	}
}
