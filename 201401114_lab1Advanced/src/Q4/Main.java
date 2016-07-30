package Q4;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner (System.in);
	
		System.out.println("enter no of nodes in arbitary rooted tree");
		int n=sc.nextInt(),r,c;
		sc.nextLine();
		int adMatrix[][]=new int[n+1][n+1];
		//The edges of the arbitrary rooted tree are taken as input.
		//adjacency matrix is formed
		for(int i=0;i<n-1;i++){
			r=sc.nextInt();
			c=sc.nextInt();
			sc.nextLine();
			adMatrix[r][c]=1;	
		}
		//here data of node is assumed to be a character. It can be anything else
		System.out.println("enter the character in each node in order");
		char nodes[]=new char[n];
		String in[]=sc.nextLine().split(" ");
		
		for(int i=0;i<n;i++){
			nodes[i]=in[i].charAt(0);
		}
		
		BinaryTree bt=new BinaryTree();
		bt.makeBinaryTree(adMatrix, nodes);
		
		System.out.println("binary tree made: level order representation");
		bt.printLevelOrder();
		
		int arr[][]=bt.GetBackArbitaryRootedtree(bt, nodes);
		System.out.println("The newly made binary tree is reconverted to arbritary rooted tree \nThe adjacency matrix of arbritary rooted tree is:");
		
		
		for(int i=1;i<arr.length;i++){
			for(int j=1;j<arr[i].length;j++)
				System.out.print(arr[i][j] + " ");
			
			System.out.println();
		}
		
		sc.close();
		
	}

}
