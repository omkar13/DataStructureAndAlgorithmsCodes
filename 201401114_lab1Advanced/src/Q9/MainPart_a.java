package Q9;

import java.util.Scanner;

public class MainPart_a {
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
		
		System.out.println("enter permutation");
		String p=sc.nextLine();
		
			permuteUsingSingleQueue(p,q,m);
		q.print();
		
	}
	
	public static void permuteUsingSingleQueue(String p,Queue q,int m){
		//note the input is the changed indices positions in the given array
		Queue q1=new Queue(m);
		
		while(q.isEmpty()==false){
			q1.enqueue(q.dequeue());
		}
		
		int newP[]=new int[m];
		
		String in[]=p.split(" ");
		
		for(int i=0;i<m;i++){
			newP[i]=Integer.parseInt(in[i]);
			}
		
		int index,el,j;
		
		for(int i=0;i<m;i++){
			index=newP[i];
			
			for(j=1;j<=index-1;j++){
				q1.enqueue(q1.dequeue());
				}
			
			el=q1.dequeue();
			q1.enqueue(el);
			j++;
			q.enqueue(el);
			
			while(j<=m){
				q1.enqueue(q1.dequeue());
				j++;
			}
			
		}
	}


}
