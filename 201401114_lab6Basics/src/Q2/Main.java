package Q2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner (System.in); 
		
		
		System.out.println("enter the vertices with their values");
		int n=sc.nextInt(),val,no=1;
		Graph g =new Graph(n);
		
		sc.nextLine();
		
		for(int i=0;i<n;i++){
			val=sc.nextInt();
			g.addVertex(val, no);
			no++;				//pos in adjacency list
		}
		System.out.println("enter the edges");
		n=sc.nextInt();
		int valueOfu,valueOfv;
		sc.nextLine();
		
		for(int i=0;i<n;i++){
			valueOfu=sc.nextInt();
			valueOfv=sc.nextInt();
			sc.nextLine();
			g.addEdge(valueOfu, valueOfv);			
		}

		System.out.println("the adjacency lists are");
		
		g.printAdjacencyLists();

		System.out.println("enter val of source node: ");
		int sourceVal=sc.nextInt();
		System.out.println("dfs traversal is: ");
		
		//g.DFS(sourceVal);
		if(g.containsCycle(sourceVal))
			System.out.println("cycle present");
		else{
			System.out.println("cycle not present");
		}
		
		System.out.println("all nodes: ");

		g.printAllvertices();
	}

}
