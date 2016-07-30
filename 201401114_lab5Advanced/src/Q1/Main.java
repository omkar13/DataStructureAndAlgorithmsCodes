package Q1;

import java.util.Scanner;

public class Main {
	public static void main(String args[]){

	Scanner sc=new Scanner(System.in);		
	BinarySearchTree bst=new BinarySearchTree();
	System.out.println("enter no of elements to insert initially");
	int n=sc.nextInt();sc.nextLine();
	
	for(int i=1;i<=n;i++){
		bst.insert(sc.nextInt());
	}
	sc.nextLine();
	//bst.initialiseDepthOfAllNodes(bst.getRoot());
	//bst.levelOrderTraversal();

	//float avgdep1=bst.getSumOfDepths()/(float)n;
	//System.out.println("average depth before rotation:  " + avgdep1 );
	
	
	System.out.println("enter key of node of left rotate " );
	int key=sc.nextInt();
	Node x=bst.search(key);
	
	bst.setSumOfDepths(x.findDepthOfNode());
	bst.initialiseDepthOfSpecificNodes(x);
	int c1=bst.getSumOfDepths();			//note : getSumOfDepths() method returns sum of depths of all nodes on subtree of node to be rotated
	System.out.println("" + c1 );
	
	
	bst.LeftRotate(x);
	
	Node p=x.getParent();
	
	bst.setSumOfDepths(p.findDepthOfNode());
	bst.initialiseDepthOfSpecificNodes(p);
	int c2=bst.getSumOfDepths();
	System.out.println("" + c2 );
	
	System.out.println("change in average depth after rotation:  " + (c2-c1)/(float)n );
	
	}
}
