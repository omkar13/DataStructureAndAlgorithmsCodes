package Q5;

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
		
		System.out.println("the second largest element is: " + secondLargest(arr));
		
	}
	
	public static int secondLargest(int arr[]){
		int n=arr.length;
		int p=(int)Math.ceil(Math.log(n)/Math.log(2.0))+1;
		int noOfNodesInTree=(int)Math.pow(2, p)-1;
		int t[]=new int[noOfNodesInTree];
	//	System.out.println("size of elimination tree is : " +noOfNodesInTree );
		
		int i=(int)Math.pow(2, p-1)-1;
		
		for(int j=0;j<arr.length;j++){
			t[i]=arr[j];
			i++;
		}
	/*	for(int l=0;l<t.length;l++){
			System.out.print(t[l] + " ");
		}
		System.out.println();
*/		
		int count=arr.length;			//no of nodes actually filled at bottom most level
		
		int levelWidth=(int)Math.pow(2, p-2);
		int k;
	
		//here we make the elimination tree(array based)
		
		while(levelWidth>=1){
			
		//	System.out.println("levelWidth: " + levelWidth + "count: " + count);
			
			k=levelWidth-1;
			int newCount=0,left,right;
			
			while(newCount<(int)Math.floor(count/2.0)){
				left=t[2*k+1];
				right=t[2*k+2];
			//	System.out.println("left child: " + left + "right child: " + right);
				
				if(left>right){
					t[k]=left;
				}
				else
					t[k]=right;
			
			//	System.out.println("index k: " + k + " of array t is : " + t[k]);
				
				newCount++;
				k++;
			}
			if(count%2==1){
				t[k]=t[2*k+1];
				newCount++;
			}
			
			count=newCount;
			
			levelWidth=levelWidth/2;
		}
/*
	//debug	
		for(int l=0;l<t.length;l++){
			System.out.print(t[l] + " ");
		}
		System.out.println();
	//debug	
*/		
		int maxIndex=0;
		int secondMax=Integer.MIN_VALUE;
		levelWidth=1;
		
		//now we will traverse top to bottom and find second largest element from the siblings of the max
		while(levelWidth<=(int)Math.pow(2, p-2)){
		
			if(t[maxIndex]==t[2*maxIndex + 1]){
				if(t[2*maxIndex + 2]>secondMax){
					secondMax=t[2*maxIndex + 2];
				}
			maxIndex=2*maxIndex + 1;
			}
			
			else{
				if(t[2*maxIndex + 1]>secondMax){
					secondMax=t[2*maxIndex + 1];
				}	
			maxIndex=2*maxIndex + 2;	
			}
		levelWidth=levelWidth*2;
		}
		
		return secondMax;
		
	}

}
