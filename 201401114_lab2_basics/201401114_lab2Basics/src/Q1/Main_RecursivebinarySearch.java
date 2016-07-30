package Q1;

import java.util.Scanner;

public class Main_RecursivebinarySearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner (System.in);
		System.out.println("enter no of elements in sorted array");
		int n=sc.nextInt();
		sc.nextLine();
		String in[]=sc.nextLine().split(" ");
		int arr[]=new int [n];
		
		for(int i=0;i<n;i++){
			arr[i]=Integer.parseInt(in[i]);
		}
		
		System.out.println("enter no of queries");
		int q=sc.nextInt();
		sc.nextLine();
		int k,index;
		
		for(int i=0;i<q;i++){
			System.out.println("enter key to be searched");
			k=Integer.parseInt(sc.nextLine());
		
			index=RecursivebinarySearch(arr,0,n-1,k);
			System.out.println("index of key is :" + index);
		}
		
	}
	
	
	public static int RecursivebinarySearch(int arr[],int l,int u,int k){
		
		if(u<l)
			return -1;
		
		int m=(int)Math.ceil((u+l)/2.0);
		
		if(k<arr[m])
				return RecursivebinarySearch(arr,l,m-1,k);
		else if(k==arr[m])
				return m;
		else
				return RecursivebinarySearch(arr,m+1,u,k);
		
	}
	

}
