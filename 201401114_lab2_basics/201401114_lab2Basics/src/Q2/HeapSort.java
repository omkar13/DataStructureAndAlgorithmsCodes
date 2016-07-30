package Q2;

import java.util.Scanner;

public class HeapSort {

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

		heapSort(arr);
		
		for(int i=0;i<n;i++)
			System.out.print(arr[i] + " ");
		

		
	}
	
	public static void heapSort(int arr[]){
		
		buildMaxHeap(arr);
		int heapSize=arr.length;
		while(heapSize>1){
			swap(arr,0,heapSize-1);
			heapSize--;
			heapify(arr,0,heapSize);
		}
		
	}
	
	public static void buildMaxHeap(int arr[]){
		
		for(int i=(int)Math.floor((arr.length-2)/2.0);i>=0;i--){
			heapify(arr,i,arr.length);
		}
	}
	
	public static void heapify(int arr[],int i,int heapSize){
		
	//	System.out.println("heapify called with i = " + i + " heapSize=  " + heapSize  );
		int largestIndex=i;
		int largest=arr[i];
		
		if(2*i+1>=heapSize){
			return;
		}
		
		if(arr[2*i+1]>largest)
			{
				largestIndex=2*i+1;
				largest=arr[2*i+1];
			}
		if(2*i+2<heapSize && arr[2*i+2]>largest){
			largestIndex=2*i+2;
			largest=arr[2*i+2];
		}
		
		if(largestIndex!=i){
			swap(arr,i,largestIndex);
			heapify(arr,largestIndex,heapSize);
		}
	}
	
	public static void swap(int arr[],int i,int j){
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}

}
