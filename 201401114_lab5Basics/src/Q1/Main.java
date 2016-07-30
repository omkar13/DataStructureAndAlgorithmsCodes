package Q1;

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
					+ "2 : enter keyvalue of node to left rotate \n "
					+ "3 : enter keyvalue of node to right rotate \n "
					+ "4 : EXIT");
			
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
					Node x=bst.search(k);
					bst.LeftRotate(x);
					break;
				}
		
		case 3: {
				int k=sc.nextInt();sc.nextLine();
				Node x=bst.search(k);
				bst.RightRotate(x);
				break;
				}
		
		case 4: {
				done=true;
				}
		
			}
		
	}

		
	}

}
