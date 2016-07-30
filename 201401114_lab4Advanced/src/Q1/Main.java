package Q1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);		
		BinarySearchTree bst=new BinarySearchTree();
		System.out.println("enter no of elements to insert initially");
		int n=sc.nextInt();sc.nextLine();
		
		for(int i=1;i<=n;i++){
			bst.insert(sc.nextInt());
		}
		sc.nextLine();
		
		int i=sc.nextInt();
		int j=sc.nextInt();
		
		int root=bst.subtreePresence(i, j);
		
		if(root!=-1){
			System.out.println("subtree is present and rooted at : "  + root);
		}
		
		else{
			System.out.println("subtree is not present");	
		}
	}

}
