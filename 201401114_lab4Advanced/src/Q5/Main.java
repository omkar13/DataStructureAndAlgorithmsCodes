package Q5;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);		
		BinarySearchTree bst=new BinarySearchTree();
		System.out.println("enter no of elements to insert in bst");
		int n=sc.nextInt();sc.nextLine();
		
		for(int i=1;i<=n;i++){
			bst.insert(sc.nextInt());
		}
		sc.nextLine();

		//we need subtree sizes - so this method initialises subtree sizes of all nodes
		bst.SubtreeSizeAndLocalRank(bst.getRoot());
		
		System.out.println("no of orderings giving same subtree is: " + bst.noOfOrderingsPossible(bst.getRoot()));
		
	}
	
}
