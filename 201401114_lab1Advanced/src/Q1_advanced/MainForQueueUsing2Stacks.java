package Q1_advanced;

import java.util.Scanner;

public class MainForQueueUsing2Stacks {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter size of Queue");
		QueueUsing2Stacks q=new QueueUsing2Stacks(Integer.parseInt(sc.nextLine()));
		System.out.println("enter no of elements to be enqueued");
		int n=Integer.parseInt(sc.nextLine());
		
		for(int i=0;i<n;i++){
			q.enqueue(Integer.parseInt(sc.nextLine()));			
		}
		
		System.out.println("the queue formed is:");
		q.print();
		
		System.out.println("enter no of elements to be dequeued");
		n=Integer.parseInt(sc.nextLine());
		
		for(int i=0;i<n;i++){
			q.dequeue();
		}
		
		System.out.println("the modified queue is:");
		q.print();
		
	/*	q.enqueue(6);
		q.print();
		q.dequeue();
		q.enqueue(7);
		q.enqueue(8);
		q.enqueue(9);
		q.enqueue(10);
		q.dequeue();
		q.enqueue(10);
		q.enqueue(11);
		q.enqueue(12);
		q.enqueue(13);
		
		
		System.out.println("the modified queue is:");
		q.print();
	*/
		
	}

}
