package Q1;

import java.util.Scanner;

public class Main_iterativeBinarySearch {

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
		
			index=iterativeBinarySearch(arr,0,n-1,k);
			System.out.println("index of key is :" + index);
		}
	
		
	}


	public static int iterativeBinarySearch(int arr[],int l,int u,int k){
		int m;
		int index=-1;
		
		while(u>=l){
			
			m=(int)Math.ceil((u+l)/2.0);
			
			if(k<arr[m]){
				u=m-1;				
			}
			
			else if(k==arr[m]){
				index=m;
				break;
			}
			
			else{
				l=m+1;
			}
			
		}
		
		return index;
		
	}

}
