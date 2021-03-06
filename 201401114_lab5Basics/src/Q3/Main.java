package Q3;

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
		bst.levelOrderTraversal();
		bst.getRoot().findHeightOfAllNodes();
		Node unBalNode=bst.findUnbalancedNode(bst.getRoot());
		if(unBalNode!=null)	
			{System.out.println("the unbalanced node found is: " + unBalNode.getKey());
			bst.rotateUnBalancedNode(unBalNode);
			
			}
		
			else{
			System.out.println("all nodes are balanced");
		}
		
		bst.levelOrderTraversal();
		}
}
