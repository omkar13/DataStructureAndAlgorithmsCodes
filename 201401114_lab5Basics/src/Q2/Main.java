package Q2;

import java.util.Scanner;


public class Main {
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);		
		boolean done=false;
		int o;
		AVL_tree avl=new AVL_tree();
	
		System.out.println("enter no of elements to insert initially");
		int n=sc.nextInt();sc.nextLine();
		
		for(int i=1;i<=n;i++){
			avl.AVL_insert(sc.nextInt());
		}
		avl.levelOrderTraversal();
		sc.nextLine();
		System.out.println("avl tree ");
		while(done==false){
			System.out.println("\n enter\n 1 : for inserting a node \n "
					+ 	"enter\n 2 : for deleting a node \n "
							+	"3 : EXIT");
			
		o=sc.nextInt();
		sc.nextLine();
		
		switch(o){
			case 1: {
					int k=sc.nextInt();sc.nextLine();
					avl.AVL_insert(k);
					System.out.println("\n");

					avl.levelOrderTraversal();
					break;
					}
			case 2: {
					int k=sc.nextInt();sc.nextLine();
					avl.delete(avl.search(k));
					System.out.println("\n");

					avl.levelOrderTraversal();
					break;

					}
			
			case 3: {
					done = true;
					}
				}
		}

	sc.close();
	}
	
}
