package Q4;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc=new Scanner (System.in);
		System.out.println("enter no of elements in heap");
		int n=sc.nextInt();
		
		System.out.println("no of possible arrangements of " + n + " distinct elements in a max heap is " + computePossibleArrangements(n));
		
		sc.close();
		
	}
	
	public static int computePossibleArrangements(int n){
		
		if(n==0 || n==1)
			return 1;
		int logN=(int)Math.floor(Math.log(n)/Math.log(2));
		
		int noOfElementsInLeftSubtree=(int)Math.pow(2, logN-1)-1 + (int)Math.min(n+1-Math.pow(2, logN), Math.pow(2, logN)-1);
		int noOfElementsInRightSubtree=n-noOfElementsInLeftSubtree-1;
		
		int l=noOfElementsInLeftSubtree;
		int r=noOfElementsInRightSubtree;
		
		int ans=comb(n-1,l)*computePossibleArrangements(l)*computePossibleArrangements(r);
		return ans;
	}
	
	public static int comb(int n,int r){
		
		int nCr=fact(n)/(fact(n-r)*fact(r));
		return nCr;
	}
	
	public static int fact(int n){
	
		int factorial=1;
		for(int i=2;i<=n;i++){
			factorial=factorial*i;
		}
		return factorial;
	}

}
