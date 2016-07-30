package Q1;

import java.util.Scanner;

public class Main_traversals {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);		
		boolean done=false;
		int o;
		BinarySearchTree bst=new BinarySearchTree();
		System.out.println("enter no of elements to insert initially");
		int n=sc.nextInt();sc.nextLine();
		
		for(int i=1;i<=n;i++){
			bst.insert(sc.nextInt());
		}
		sc.nextLine();
		
		while(done==false){
			System.out.println("enter\n 1 : for inserting a node \n "
					+ "2 : in order traversal\n "
					+ "3 : pre order traversal\n "
					+ "4 : post order traversal\n"
					+ "5 : level order traversal\n"
					+ "6 : zig zag traversal\n"
					+ "7 : iterative in order traversal\n "
					+ "8 : iterative pre order traversal\n "
					+ "9 : iterative post order traversal\n"
					+ "10 : EXIT");
			
		o=sc.nextInt();
		sc.nextLine();
		
		switch(o){
		case 1: {
					int k=sc.nextInt();sc.nextLine();
					bst.insert(k);
					break;
				}
		case 2: {
					bst.RecursiveinOrderTraversal();
					break;
				}
		
		case 3: {
					bst.RecursivepreOrderTraversal();
					break;
				}
		
		case 4: {
					bst.RecursivepostOrderTraversal();
				break;
				}
		case 5 : {
			
			bst.levelOrderTraversal();
			break;
			}
	
		
		case 6 : {
			
				bst.zigZagTraversal();
				break;
				}
		
		case 7: {
			bst.IterativeInOrderTraversal();
			break;
		}

		case 8: {
			bst.IterativePreOrderTraversal();
			break;
		}

		case 9: {
			bst.IterativePostOrderTraversal();
		break;
		}

		
		
		case 10 : {
				done=true;
				}
		
		}
		
			
			
		}
		
		
		sc.close();

		
		
		

	}

}
