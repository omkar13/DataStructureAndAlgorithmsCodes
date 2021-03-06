package Q2;

import java.util.Scanner;

public class Main_QuickSort {

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
	
		QuickSort(arr,0,n-1);
		
		for(int i=0;i<n;i++)
			System.out.print(arr[i] + " ");
		
		System.out.println();
	
	}
	
	public static void QuickSort(int arr[],int p,int r){
		if(p>=r)
			return;
		
		int q=partition(arr,p,r);
		QuickSort(arr,p,q-1);
		QuickSort(arr,q+1,r);
		
	}
	
	public static int partition(int arr[],int p,int r){
		int i=p-1,j=p;
		int x=arr[r],temp;
		
		while(j<r){
			
			if(arr[j]>x)
				j++;
			
			else{
				temp=arr[i+1];
				arr[i+1]=arr[j];
				arr[j]=temp;
				i++;
				j++;	
			}
			
			
			
		}
		
		temp=arr[i+1];
		arr[i+1]=arr[r];
		arr[r]=temp;
		
		return i+1;
	}
	

}
