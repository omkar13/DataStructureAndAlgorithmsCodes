package Q2;

import java.util.Scanner;

public class Main_SelectionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
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
	
		selectionSort(arr);
		
		for(int i=0;i<n;i++)
			System.out.print(arr[i] + " ");
		
		System.out.println();
	
	}
	
	public static void selectionSort(int arr[]){

		int n=arr.length,min,pos,temp;
		
		for(int i=0;i<n-1;i++){
			min=arr[i];
			pos=i;
			
			for(int j=i+1;j<n;j++){
				if(arr[j]<min){
					min=arr[j];
					pos=j;
				}
							
			}
			
			temp=arr[i];
			arr[i]=arr[pos];
			arr[pos]=temp;
		}
	
	
	}

}
