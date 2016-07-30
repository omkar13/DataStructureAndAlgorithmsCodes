package Q4;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
					+ "2 : delete node with given key\n "
					+ "3 : EXIT");
			
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
					bst.delete(bst.search(k));
					bst.levelOrderTraversal();
				}
		}
		
	}
	
}
}