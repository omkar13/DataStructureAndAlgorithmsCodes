package Q9;

import java.util.Scanner;

public class MainPart_b {
	public static void main(String[] args) {
		Scanner sc=new Scanner (System.in);
		System.out.println("enter size of Stack");
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
		
		System.out.println("enter permutation(1 index based) from bottom to top in single line");
		String p=sc.nextLine();
		
		permuteUsing2Stacks(p,s,m);
		s.print();
		
	}
	
//this  method takes a stack as input along with a permutation. It changes the order of the elements in th stack according to the permutation
//the permutation is index based with bottom of stack labelled as 1	
public static void permuteUsing2Stacks(String p,Stack s,int m){
		
		int newP[]=new int[m];
		Stack s1=new Stack(m);
		Stack s2=new Stack(m);
		
		String in[]=p.split(" ");
		
		for(int i=0;i<m;i++){
			newP[i]=Integer.parseInt(in[i]);
			}
		
		while(s.isEmpty()==false){
			s2.push(s.pop());
		}
		while(s2.isEmpty()==false){
			s1.push(s2.pop());
		}
		
		int index,r;			
		
		for(int i=0;i<m;i++){
			index=newP[i];
			
			r=m-index;
			//System.out.println("i: " + i + "r: " + r);
			
			for(int j=1;j<=r;j++){
				s2.push(s1.pop());
			}
			//System.out.println("stack s1:");
			//s1.print();
			
			s.push(s1.peek());
			
			while(s2.isEmpty()==false){
				s1.push(s2.pop());
			}
			
			//System.out.println("stack s:");
			//s.print();
			
		}
		
		
	}
	


}
