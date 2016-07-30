package Q2;

import java.util.Scanner;

public class Main_InsertionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Scanner sc=new Scanner (System.in);
		System.out.println("enter no of elements in unsorted array");
		int n=sc.nextInt();
		sc.nextLine();
		String in[]=sc.nextLine().split(" ");
		int arr[]=new int [n];
		
		for(int i=0;i<n;i++){
			arr[i]=Integer.parseInt(in[i]);
		}
	
		insertionSort(arr);
		
		for(int i=0;i<n;i++)
			System.out.print(arr[i] + " ");
		
		System.out.println();
	
	}
	
	public static void insertionSort(int arr[]){
		
		int j,n=arr.length,element;
		
		for(int i=1;i<n;i++){
		
			element=arr[i];
			for(j=i-1;j>=0;j--){
				
				if(arr[j]>element){
					arr[j+1]=arr[j];
				}
				
				else
					break;
				
			}
			
			arr[j+1]=element;
			
		}
		
		
		
	}

}
