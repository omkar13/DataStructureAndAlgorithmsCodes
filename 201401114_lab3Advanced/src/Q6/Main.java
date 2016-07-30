package Q6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static int maxNo=0,rootIndexLargestSubtree;
	public static boolean isLargestSubtreeMaxHeap;

	public static void main(String[] args) {
		Scanner sc=new Scanner (System.in);
		System.out.println("enter no of elements in array");
		int n=sc.nextInt();
		int arr[]=new int[n+1];
		
		for(int i=1;i<=n;i++){
			arr[i]=sc.nextInt();			
		}
		sc.nextLine();
		
		findLargestSubtree(arr,1,n,sc);
		
	}
	
	public static void findLargestSubtree(int arr[],int rootIndex,int n,Scanner sc){
		findLargestMaxHeapSubtree(arr,1,n,sc);
		findLargestMinHeapSubtree(arr,1,n,sc);
		
		if(isLargestSubtreeMaxHeap==true){
			System.out.println("largest subtree is a max heap and it has " + maxNo+ " nodes and its root is at index :" + rootIndexLargestSubtree);
		}
		
		else{
			System.out.println("largest subtree is a min heap and it has " + maxNo+ " nodes and its root is at index :" + rootIndexLargestSubtree);
		}
	}
	
	public static void findLargestMaxHeapSubtree(int arr[],int rootIndex,int n,Scanner sc){
		//System.out.println("called for index: " +rootIndex );
	//	calls++;
		/*if(calls>20){
			//System.out.println("calls exceeded 20");
			sc.nextLine();
		}
		*/
		Queue<Integer> q=new LinkedList<Integer>();
		q.add(rootIndex);
		
		int count=1,x;
		int left,right,breakPoint=-1;
		
		while(q.isEmpty()==false){			//we use a queue to check for largest max heap for given node as root
			x=q.remove();
		
			if(2*x<=n)
				{
					left=arr[2*x];
					
					if(arr[x]>left){
						q.add(2*x);
						count++;
					}
					else{
						breakPoint=2*x;
						break;
					}
				
				}
			else
				break;
				
			if(2*x+1<=n){
				right=arr[2*x+1];
				
				if(arr[x]>right){
					q.add(2*x+1);
					count++;
				}
				
				else{
					breakPoint=2*x+1;
					break;
				}
			}
			else
				break;
			
		}

		if(count>maxNo){			
														//update max
			maxNo=count;
			rootIndexLargestSubtree=rootIndex;
			isLargestSubtreeMaxHeap=true;
		}
		
		if(breakPoint!=-1){							 
		
			//if we use brute force method,we can find largest max heap for each node and then find max among them
			//Here I have used a better method. We can eliminate some possibilities.
			//Suppose we find that at some node x the max heap property is violated. So we have found largest max heap for
			//given node and stopped at x. Now we NEED NOT CHECK THE LARGEST MAX HEAP FOR NODES WHICH ARE ANCESTORS OF x
			//INSTEAD WE SHOULD ONLY CHECK THE SIBLINGS OF ANCESTORS OF x and once for x. They are called recursively.
			
			
			
			
			
			int a=breakPoint;
			//System.out.println(breakPoint);
		
			while(a!=rootIndex){

				//System.out.print("rootIndex: "+ rootIndex + "a " +a );
				
				if(a%2==0){
					findLargestMaxHeapSubtree(arr,a+1,n,sc);					//call function for sibling
				}
				else{
					findLargestMaxHeapSubtree(arr,a-1,n,sc);					//call function for sibling
				}
				
			a=(int)Math.ceil((a-1)/2.0);	
			//System.out.print("After a:  " +a );
			
			}
		
			findLargestMaxHeapSubtree(arr,breakPoint,n,sc);					//call for x
		}
		
		
		//System.out.println("call finished for index: " + rootIndex);
	}

	
	//the logic for finding largest min heap subtree is similar to above logic.
	public static void findLargestMinHeapSubtree(int arr[],int rootIndex,int n,Scanner sc){
		//System.out.println("called for index: " +rootIndex );
		//calls++;
		/*if(calls>20){
			//System.out.println("calls exceeded 20");
			sc.nextLine();
		}
		*/
		Queue<Integer> q=new LinkedList<Integer>();
		q.add(rootIndex);
		
		int count=1,x;
		int left,right,breakPoint=-1;
		
		while(q.isEmpty()==false){
			x=q.remove();
		
			if(2*x<=n)
				{
					left=arr[2*x];
					
					if(arr[x]<left){
						q.add(2*x);
						count++;
					}
					else{
						breakPoint=2*x;
						break;
					}
				
				}
			else
				break;
				
			if(2*x+1<=n){
				right=arr[2*x+1];
				
				if(arr[x]<right){
					q.add(2*x+1);
					count++;
				}
				
				else{
					breakPoint=2*x+1;
					break;
				}
			}
			else
				break;
			
		}

		if(count>maxNo){
			maxNo=count;
			rootIndexLargestSubtree=rootIndex;
			isLargestSubtreeMaxHeap=false;
		}
		
		if(breakPoint!=-1){
			
			int a=breakPoint;
			//System.out.println(breakPoint);
		
			while(a!=rootIndex){

				//System.out.print("rootIndex: "+ rootIndex + "a " +a );
				
				if(a%2==0){
					findLargestMinHeapSubtree(arr,a+1,n,sc);
				}
				else{
					findLargestMinHeapSubtree(arr,a-1,n,sc);
				}
				
			a=(int)Math.ceil((a-1)/2.0);	
			//System.out.print("After a:  " +a );
			
			}
		
			findLargestMinHeapSubtree(arr,breakPoint,n,sc);
		}
		
		
		//System.out.println("call finished for index: " + rootIndex);
	}


}
