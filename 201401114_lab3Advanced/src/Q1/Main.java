package Q1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner (System.in);
		System.out.println("enter value of k (k-ary heap)");
		int k=sc.nextInt();
		sc.nextLine();
		
		System.out.println("enter heap elements in order");
		int n=sc.nextInt();
		sc.nextLine();
		String in[]=sc.nextLine().split(" ");
		int arr[]=new int [n+1];
		
		for(int i=1;i<=n;i++){
			arr[i]=Integer.parseInt(in[i-1]);		//note index is 1 based
		}

		System.out.println("enter any index (1 based) value");
		
		int i=sc.nextInt();
	
		int parentIndex=(int)Math.ceil((i-1)/(float)k);
		
		if(parentIndex>=1)	
			System.out.println("parent index is: " + parentIndex  + "and parent is: " + arr[parentIndex]);
		else
			System.out.println(" parent doesnt exist");
		
		int leftMostChildIndex=k*(i-1)+2;
		int childIndex= leftMostChildIndex,childno=1;;
		
		while(childIndex<arr.length && childno<=k){
			System.out.println("child no: " + childno + " has index: " +childIndex + " and its value is :" + arr[childIndex]);
			childno++;
			childIndex++;
		}	
		
		while(childno<=k ){
			System.out.println("child no: "+ childno + "  doesn't exist" );
			childno++;
		}
	sc.close();	
	}

}
