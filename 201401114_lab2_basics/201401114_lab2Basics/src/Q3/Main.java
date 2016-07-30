package Q3;

import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc=new Scanner (System.in);
		System.out.println("enter no of elements in array");
		int n=sc.nextInt();
		sc.nextLine();
		String in[]=sc.nextLine().split(" ");
		int arr[]=new int [n];
		
		for(int i=0;i<n;i++){
			arr[i]=Integer.parseInt(in[i]);
		}
	
		System.out.println("enter element whose rank is to be found out");
		int e=sc.nextInt(),count=0,rank;
		sc.nextLine();
		
		for(int i=0;i<n;i++){
			if(arr[i]<e)
				count++;
		}
		
		rank=count+1;
	
		System.out.println(rank);	
		
	}

}
