package Q10;

import java.util.Scanner;

public class Main {

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
		System.out.println("enter val of k: ");
		int k=sc.nextInt();
		ModifiedBubbleSort(arr,k);
		
		for(int i=0;i<n;i++)
			System.out.print(arr[i] + " ");
		
		System.out.println();
		
	}
	
	public static void ModifiedBubbleSort(int arr[],int k){
	int n=arr.length,temp;	
	int inversionsCount=0;

	for(int i=0;i<n-1;i++){
		for(int j=i+1;j<n;j++){
			if(arr[i]>arr[j])
				inversionsCount++;
		}
		
	}
	
	System.out.println("no of inversions in input is " + inversionsCount);
	
		for(int i=0;i<n-1;i++){
			for(int j=0;j<n-i-1;j++){
				
				if(inversionsCount==k)
					break;
					
				else if(inversionsCount>k && arr[j]>arr[j+1]){
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					inversionsCount--;
				}
				
				else if (inversionsCount<k && arr[j]<arr[j+1]){
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					inversionsCount++;					
				}
				
			}
		}
		
		
	}

}