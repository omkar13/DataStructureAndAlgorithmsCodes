package Q11;
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
		
		int arr1[]=new int[2];	//array for storing no of comparisons and no of exchanges
		QuickSort(arr,0,n-1,arr1);
		
		for(int i=0;i<n;i++)
			System.out.print(arr[i] + " ");
		
		System.out.println("\n no of comparisons are : " + arr1[0] + "\n no of exchanges made: "+  arr1[1]);
	
	}
	
	public static void QuickSort(int arr[],int p,int r,int arr1[]){
		if(p>=r)
			return;
		
		int q=partition(arr,p,r,arr1);
		QuickSort(arr,p,q-1,arr1);
		QuickSort(arr,q+1,r,arr1);
		
	}
	
	public static int partition(int arr[],int p,int r,int arr1[]){
		int i=p-1,j=p;
		int x=arr[r],temp;
		
		while(j<r){
			
			if(arr[j]>x)			//comparison		
					j++;
			else{
				temp=arr[i+1];		//exchange
				arr[i+1]=arr[j];
				arr[j]=temp;
				i++;
				j++;	
				arr1[1]++;
			}
			
			arr1[0]++;
			
		}
		
		temp=arr[i+1];
		arr[i+1]=arr[r];
		arr[r]=temp;
		arr1[1]++;		//exchange
		
		return i+1;
	}
	

}