package Q1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		int noOfu,noOfv;
		sc.nextLine();
		
		for(int i=0;i<n;i++){
			noOfu=sc.nextInt();
			noOfv=sc.nextInt();
			sc.nextLine();
			g.addEdge(noOfu, noOfv);			
		}
	
		System.out.println("enter val of source node: ");
		int sourceVal=sc.nextInt();
		System.out.println("bfs traversal is: ");
		
		g.BFS(sourceVal);
		
		System.out.println("all nodes: ");

		g.printAllvertices();
	}

}
