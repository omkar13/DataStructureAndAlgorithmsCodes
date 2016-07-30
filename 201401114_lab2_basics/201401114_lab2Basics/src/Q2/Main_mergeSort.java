package Q2;

import java.util.Scanner;

public class Main_mergeSort {

	public static void main(String[] args) {
		Scanner sc=new Scanner (System.in);
		System.out.println("enter no of elements in unsorted array");
		int n=sc.nextInt();
		sc.nextLine();
		String in[]=sc.nextLine().split(" ");
		int arr[]=new int [n];
		
		for(int i=0;i<n;i++){
			arr[i]=Integer.parseInt(in[i]);
		}
	
		mergeSort(arr,0,n-1);
		
		for(int i=0;i<n;i++)
			System.out.print(arr[i] + " ");
		
		System.out.println();
	
	}
	
	public static void mergeSort(int arr[],int p,int r){
	
		if(p>=r){
			return;			
		}
		
		int q=(int)Math.floor((p+r)/2.0);

		mergeSort(arr,p,q);
		mergeSort(arr,q+1,r);
		merge(arr,p,q,r);
		
	}
	
	public static void merge(int arr[],int p,int q,int r){
		
		int b[]=new int[r-p+1];
		int ptr1=p,ptr2=q+1,ptr=0,ptr_;
		
		while(ptr1<=q && ptr2<=r){
			
			if(arr[ptr1]<arr[ptr2]){
				b[ptr]=arr[ptr1];
				ptr1++;
			}
			else{
				b[ptr]=arr[ptr2];
				ptr2++;
						
			}
			
			ptr++;		
		}
		
		if(ptr1==q+1)
			ptr_=ptr2;
		else
			ptr_=ptr1;
		
		while(ptr<b.length){
			b[ptr]=arr[ptr_];
			ptr_++;
			ptr++;
		}
		
		ptr=p;
		
		for(int i=0;i<b.length;i++){
			arr[ptr]=b[i];
			ptr++;
		}
		
	}
	
	
}


