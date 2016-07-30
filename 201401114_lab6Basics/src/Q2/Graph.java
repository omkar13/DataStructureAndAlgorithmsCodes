package Q2;
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
//for undirected graphs
		public void addEdge(int valueOfu,int valueOfv){
			Vertex u=null,v=null;
			
			
			for(int i=0;i<vertices.size();i++){
				if(vertices.get(i).getValue()==valueOfv)
				{
					v=vertices.get(i);				
					break;
				}
			}
			
			for(int i=0;i<vertices.size();i++){
				if(vertices.get(i).getValue()==valueOfu)
				{
					u=vertices.get(i);				
					break;
				}
			}
		
			
			//adj[NoOfu].add(ver);
			adj.get(u.getNo()-1).add(v);	
			
			//adj[NoOfu].add(ver);
			adj.get(v.getNo()-1).add(u);
		}
		
		public void addVertex(int value,int no){
			Vertex ver=new Vertex(value,no);
			vertices.add(ver);
		}
		
/*		
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
	*/	
		private int globalTime;
		
		public void DFS(int value){
			
			globalTime=0;
			for(int i=0;i<vertices.size();i++){
				vertices.get(i).setDiscoveryTime(0);
				vertices.get(i).setFinishingtime(0);
				vertices.get(i).setParent(null);
				vertices.get(i).setColor("white");
			}
			
			for(int i=0;i<vertices.size();i++){
				if(vertices.get(i).getColor().equals("white"))
					DFSvisit(vertices.get(i));			
			}		
		}
		
		public void DFSvisit(Vertex v){
			v.setDiscoveryTime(++globalTime);
			v.setColor("grey");
			System.out.println("value: "+ v.getValue());
			Vertex u;
			for(int i=0;i<adj.get(v.getNo()-1).size();i++){
				u=adj.get(v.getNo()-1).get(i);
				
				if(u.getColor().equals("white")){
					u.setParent(v);
					DFSvisit(u);
				}			
			}
			
			v.setColor("black");
			v.setFinishingtime(++globalTime);
		}
		//detects presence of cycle in undirected graph 
		public boolean containsCycle(int value){
			
			globalTime=0;
			for(int i=0;i<vertices.size();i++){
				vertices.get(i).setDiscoveryTime(0);
				vertices.get(i).setFinishingtime(0);
				vertices.get(i).setParent(null);
				vertices.get(i).setColor("white");
			}
			
			for(int i=0;i<vertices.size();i++){
				if(vertices.get(i).getColor().equals("white"))
					if(cycleUtil(vertices.get(i)))
						return true;			
			}
			return false;
		}
		
		public boolean cycleUtil(Vertex v){
			v.setDiscoveryTime(++globalTime);
			v.setColor("grey");
			System.out.println("value: "+ v.getValue());
			Vertex u;
			for(int i=0;i<adj.get(v.getNo()-1).size();i++){			//if v has a non-white vertex in its adjacency list which is not its parent then
																	//cycle is present	
				u=adj.get(v.getNo()-1).get(i);
				
				if(u.getColor().equals("white")){
					u.setParent(v);
					if(cycleUtil(u)==true)
						return true;
				}	
				
				else {
					if(v.getParent()!=u){
						return true;
					}
				}
			}
			
			v.setColor("black");
			v.setFinishingtime(++globalTime);
			return false;
		}
		
		public void printAllvertices(){
			Vertex v;
			for(int i=0;i<vertices.size();i++){
				v=vertices.get(i);
				System.out.println("value : " + v.getValue() + "\n discovery time: " + v.getDiscoveryTime() + "\n finishing time: " + v.getFinishingtime()
									+ "color: " + v.getColor());
			
			}
			
		}
		
		public void printAdjacencyLists(){
			for(int i=1;i<=adj.size();i++){
				System.out.println("adjacency list of vertex with no : " + i);
				
				for(int j=0;j<adj.get(i-1).size();j++){
					System.out.print(adj.get(i-1).get(j).getValue() + " ");					
				}
				System.out.println();				
			}
			
		}
		
	
}
