package Q3_Q4;

import java.util.Scanner;

public class Main_Q3 {

	  public static void main(String[] args) {
	        
	        Scanner sc=new Scanner(System.in);
	        int n=sc.nextInt();
	        sc.nextLine();
	        int arr[]=new int[n],min,max;
	        
	        min=max=arr[0]=sc.nextInt();
	        
	        for(int i=1;i<n;i++){
	            arr[i]=sc.nextInt();            
	            
	            if(arr[i]<min)
	                {min=arr[i];
	                continue;
	                }
	            
	            if(arr[i]>max)
	                max=arr[i];
	                
	        }
	        
	        System.out.println("min is:" + min  + "\nmax is: " + max);
	        
	        sc.close();
	  }	  
	
	
}
