package Q1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

	private ArrayList<LinkedList<Vertex>> adj;
	private LinkedList<Vertex> vertices;
	
	public Graph(int n) {
		this.vertices = new LinkedList<Vertex>();
		adj=new ArrayList<LinkedList<Vertex>>();
		
		for(int i=0;i<n;i++){
			adj.add(new LinkedList<Vertex>());
		}
	}

	public void addEdge(int NoOfu,int NoOfv){
		Vertex ver=null;
		
		for(int i=0;i<vertices.size();i++){
			if(vertices.get(i).getNo()==NoOfv)
			{
				ver=vertices.get(i);				
				break;
			}
		}
		
		//adj[NoOfu].add(ver);
		adj.get(NoOfu-1).add(ver);
		
		
		for(int i=0;i<vertices.size();i++){
			if(vertices.get(i).getNo()==NoOfu)
			{
				ver=vertices.get(i);				
				break;
			}
		}
		
		//adj[NoOfu].add(ver);
		adj.get(NoOfv-1).add(ver);
	}
	
	public void addVertex(int value,int no){
		Vertex ver=new Vertex(value,no);
		vertices.add(ver);
	}
	
	
	public void BFS(int value){
		Vertex v,sourceNode=null;
		Queue<Vertex> q=new LinkedList<Vertex>(); 
		
		
		for(int i=0;i<vertices.size();i++){
			v=vertices.get(i);
			if(v.getValue()!=value){
				v.setColor("white");
				v.setDistance(Integer.MAX_VALUE);
				v.setParent(null);
			}
			else{
				sourceNode=v;
			}
		}
		

		sourceNode.setColor("grey");
		sourceNode.setDistance(0);
		sourceNode.setParent(null);
		
		q.add(sourceNode);
		Vertex u,w;
		
		while(q.isEmpty()==false){
			u=q.remove();
			
			//for(int i=0;i<adj[u.getNo()].size();i++){
			for(int i=0;i<adj.get(u.getNo()-1).size();i++){
				//w=adj[u.getNo()].get(i);
				w=adj.get(u.getNo()-1).get(i);
				
				if(w.getColor().equals("white")){
					w.setColor("grey");
					w.setDistance(u.getDistance()+1);
					w.setParent(u);					
					System.out.println("value of Node: " +  w.getValue()) ;
					q.add(w);
				}				
			}
			u.setColor("black");			
		}
		
	}
	
	public void printAllvertices(){
		Vertex v;
		for(int i=0;i<vertices.size();i++){
			v=vertices.get(i);
			System.out.println("value : " + v.getValue() + "\n distance : "  + v.getDistance()
								+ "color: " + v.getColor());
		
		}
		
	}
	
}
