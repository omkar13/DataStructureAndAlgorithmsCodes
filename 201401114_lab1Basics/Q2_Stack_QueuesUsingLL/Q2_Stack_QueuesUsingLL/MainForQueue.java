package Q2_Stack_QueuesUsingLL;

import java.util.Scanner;

public class MainForQueue {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		Queue q=new Queue();
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
		
	}

}
