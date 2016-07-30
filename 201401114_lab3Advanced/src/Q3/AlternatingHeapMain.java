package Q3;

import java.util.Scanner;


public class AlternatingHeapMain {
	static int heapSize;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner (System.in);
		System.out.println("enter no of elements in array");
		int n=sc.nextInt();
		sc.nextLine();
		String in[]=sc.nextLine().split(" ");
		int arr[]=new int [n+1];
		
		for(int i=1;i<=n;i++){
			arr[i]=Integer.parseInt(in[i-1]);
		}
		heapSize=0;
		buildAlternatingHeap_rootDown(arr);
		System.out.println("Alternating heap made using root downward approach is: ");
		
		for(int i=1;i<=n;i++)
			System.out.print(arr[i] + " ");
		
	}
	
	public static void buildAlternatingHeap_rootDown(int arr[]){
		heapSize=1;
		while(heapSize<arr.length-1){
			insert(arr,heapSize+1);
			heapSize++;
		}
		
	}
	
	public static void insert(int arr[],int index){
		int level=(int)Math.floor(Math.log(index)/Math.log(2));
		int parentIndex=(int) Math.ceil((index-1)/2.0);
		
		if(level%2==0){		
													//node must be lesser than parent
			if(arr[index]<arr[parentIndex]){
				shiftUpForMin(arr,index,parentIndex);				
			}
			else{
				swap(arr,index,parentIndex);
				shiftUpForMax(arr,parentIndex,(int) Math.ceil((parentIndex-1)/2.0));
			}
			
		}
		
		else{												//node must be greater than parent
			if(arr[index]>arr[parentIndex]){
				shiftUpForMax(arr,index,parentIndex);
			}
			
			else{
				swap(arr,index,parentIndex);
				shiftUpForMin(arr,parentIndex,(int) Math.ceil((parentIndex-1)/2.0));
						
			}
		}
		
	}
	
	public static void shiftUpForMin(int arr[],int index,int parentIndex){
		if(index==1)
			return;
		
		int grandparentIndex=(int) Math.ceil((parentIndex-1)/2.0);
		
		if(arr[index]<arr[grandparentIndex]){
			swap(arr,index,grandparentIndex);
			shiftUpForMin(arr,grandparentIndex,(int) Math.ceil((grandparentIndex-1)/2.0));
		}
		
	}
	
	public static void shiftUpForMax(int arr[],int index,int parentIndex){
		if(index==2 || index==3)
			return;
		
		int grandparentIndex=(int) Math.ceil((parentIndex-1)/2.0);
		
		if(arr[index]>arr[grandparentIndex]){
			swap(arr,index,grandparentIndex);
			shiftUpForMax(arr,grandparentIndex,(int) Math.ceil((grandparentIndex-1)/2.0));
		}
		
	}
	
	

public static void swap(int arr[],int i,int j){
	int temp=arr[i];
	arr[i]=arr[j];
	arr[j]=temp;

}
	
	

}
