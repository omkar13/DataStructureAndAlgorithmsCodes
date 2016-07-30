package Q3c;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
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
		
		System.out.println("enter indexes of elements to be swapped");
		int a=sc.nextInt();
		int b=sc.nextInt();
		exchange(a,b,q,m);
		q.print();		
		sc.close();
	
	}
	
	public static void exchange(int a ,int b,Queue q,int n){
		
		Queue q1=new Queue(n);
		Queue q2=new Queue(n);
		int i,j=0;	
		
		for(i=0;i<a;i++){
			q.enqueue(q.dequeue());
			j++;
		}
		
		q2.enqueue(q.dequeue());
		i++;
		j++;
		
		for(;i<b;i++){
			q1.enqueue(q.dequeue());
		}
		
		q.enqueue(q.dequeue());
		j++;
	
		while(q1.isEmpty()==false){
			q.enqueue(q1.dequeue());
		j++;	
		}
		
		q.enqueue(q2.dequeue());
		j++;
	
		while(j<=n){
			q.enqueue(q.dequeue());
			j++;
		}
			
		
	}

}
