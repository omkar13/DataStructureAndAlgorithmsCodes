package Q2;

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
		System.out.println("no of inversions in level order traversal is: " + bst.levelOrderTraversalForInversions());
	}
}
