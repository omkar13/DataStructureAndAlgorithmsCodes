package Q4;

import java.util.Scanner;

public class Main {

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
		
		System.out.println("enter rank whose element is to be found");		
		int r=sc.nextInt();
		
		int e=ModifiedQuickSort(arr,0,n-1,r);
		
		System.out.println("the element is:" + e);		
		
	}
	
	public static int ModifiedQuickSort(int arr[],int p,int r,int rank){
		//if(p>=r)
		//	return;
		
		int q=partition(arr,p,r);
		
		if(q+1==rank)
			return arr[q];
	
		else if(rank<q+1)
			return ModifiedQuickSort(arr,p,q-1,rank);
		else
			return ModifiedQuickSort(arr,q+1,r,rank);
		
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
