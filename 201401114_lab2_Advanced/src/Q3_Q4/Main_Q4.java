package Q3_Q4;

import java.util.Scanner;

public class Main_Q4 {

	
public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        int arr[]=new int[n],min,max;
        
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();            
        }
        
        int arrMin[]=new int[(int)Math.ceil(n/2.0)];
        int arrMax[]=new int[(int)Math.ceil(n/2.0)];
        
        int i=0;

        for(int j=0;j<(int)Math.ceil(n/2.0);j++){
        
            if(i+1==arr.length){
                arrMin[j]=arrMax[j]=arr[i];
                break;
            }
                
            if(arr[i]<arr[i+1]){
                arrMin[j]=arr[i];
                arrMax[j]=arr[i+1];
            }
            
            else{
                arrMin[j]=arr[i+1];
                arrMax[j]=arr[i];
        
            }
            i=i+2;
        }
        
        for(int p=0;p<arrMin.length;p++){
            System.out.print(arrMin[p] + " ");
        }
        System.out.println();

        for(int p=0;p<arrMax.length;p++){
            System.out.print(arrMax[p] + " ");
        }
        
        System.out.println();

        min=arrMin[0];
        max=arrMax[0];
        
        for(int j=1;j<arrMin.length;j++){
            
            if(arrMin[j]<min)
                min=arrMin[j];
            
            if(arrMax[j]>max)
                max=arrMax[j];
        }
        
        System.out.println("min is:" + min  + "\nmax is: " + max);
                
        
    }
    

	
	
	
	
	
	
	
}
