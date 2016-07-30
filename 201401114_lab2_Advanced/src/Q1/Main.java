package Q1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        int arr[]=new int[n];
        
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();            
        }
        int minPos=minPos(arr,0,arr.length-1);
        System.out.println("min pos is at:" + minPos);
        int maxPos=minPos-1;
        
        if(maxPos<0)
            maxPos=n-1;
        
        System.out.println("max pos is at:" + maxPos);
        
        sc.close();
    }
    
    public static int minPos(int arr[],int p,int r){
        
        if(r==p+1){
            return r;
        }
        
        if(arr[p]<arr[r]){
            return p;
        }
        
        int q=(int)Math.floor((p+r)/2.0);
        
        if(arr[p]<=arr[q]){
            return minPos(arr,q,r);
        }
        
        else
            return minPos(arr,p,q);
    }

}





