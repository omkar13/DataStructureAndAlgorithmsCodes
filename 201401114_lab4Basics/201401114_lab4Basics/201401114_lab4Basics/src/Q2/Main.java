package Q2;

import java.util.Scanner;

public class Main {

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
					+ "2 : finding height of node with given key\n "
					+ "3 : finding depth of node with given key\n "
					+ "4 : finding size of subtree rooted at node with given key value"
					+ "5 : EXIT");
			
		o=sc.nextInt();
		sc.nextLine();
		
		switch(o){
		case 1: {
					int k=sc.nextInt();sc.nextLine();
					bst.insert(k);
					break;
				}
		case 2: {
					int k=sc.nextInt();sc.nextLine();
					System.out.println("height of node with given key is :" + bst.findHeightOfNode(k));			
					break;
				}
		
		case 3: {
			int k=sc.nextInt();sc.nextLine();
			System.out.println("depth of node with given key is :" + bst.findDepthOfNode(k));			
			break;
			}
		
		case 4: {
			int k=sc.nextInt();sc.nextLine();
			System.out.println("size of subtree rooted at node with given key is :" + bst.sizeOfSubtree(k));			
			break;
			}
		
		case 5 : {
				done=true;
				}
		
		}
		
			
			
		}
		
		
		sc.close();
	}

}
