package Q2;

import java.util.Scanner;

public class Main_bubbleSort {

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
	
		bubbleSort(arr);
		
		for(int i=0;i<n;i++)
			System.out.print(arr[i] + " ");
		
		System.out.println();
		
	}
	
	public static void bubbleSort(int arr[]){
	int n=arr.length,temp;	
	boolean done;
	
		for(int i=0;i<n-1;i++){
			
			done=true;
			for(int j=0;j<n-i-1;j++){
				
				if(arr[j]>arr[j+1]){
					done=false;
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
				
			}
			
			if(done)
				break;
		}
		
		
	}

}
