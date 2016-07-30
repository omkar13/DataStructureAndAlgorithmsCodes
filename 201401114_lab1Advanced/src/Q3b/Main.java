package Q3b;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
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
		
		System.out.println("enter end indexes of continuous susequence to be reversed");
		int p=sc.nextInt();
		int q=sc.nextInt();
		reverseContSubSequence(p, q,s,n,m);
		s.print();
		sc.close();
	}
	
public static void reverseContSubSequence(int p,int q,Stack s,int n,int m){
		
		Stack st1=new Stack(n);
		Stack st2=new Stack(n);
		
		int top=m;
		while(top!=q+1){
			st1.push(s.pop());
			top--;
		}
		
		while(top!=p){
			st2.push(s.pop());
			top--;
		}
		
		while(st2.isEmpty()==false){
			st1.push(st2.pop());
		}
		
		while(st1.isEmpty()==false){
			s.push(st1.pop());
			top++;
		}
	}
}
