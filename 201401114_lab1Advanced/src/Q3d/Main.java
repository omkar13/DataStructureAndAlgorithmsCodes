package Q3d;

import java.util.Scanner;

import Q3c.Queue;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner (System.in);
		System.out.println("enter size of Queue");
		int n=sc.nextInt();
		sc.nextLine();
		Queue q=new Queue(n);
		
		System.out.println("enter no of elements to enqueue");
		int m=sc.nextInt();
		sc.nextLine();
		
		for(int i=0;i<m;i++)
			q.enqueue(sc.nextInt());
		sc.nextLine();
		
		System.out.println("Queue formed:");
		q.print();
		
		System.out.println("enter end indexes of cont subsequenece to be reversed");
		int a=sc.nextInt();
		int b=sc.nextInt();
		revContSubSeq(a,b,q,m);
		q.print();		
		sc.close();
	
	}
	
	public static void revContSubSeq(int a ,int b,Queue q,int m){
		
		StackUsing2Queues s=new StackUsing2Queues(m);
		int i;
		for(i=0;i<a;i++){
			q.enqueue(q.dequeue());
			
		}
		
		for(;i<=b;i++){
			s.push(q.dequeue());
		}
		
		while(!s.isEmpty())
			q.enqueue(s.pop());
		
		for(;i<m;i++)
			q.enqueue(q.dequeue());
		
	}

}
