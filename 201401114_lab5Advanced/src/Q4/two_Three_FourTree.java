package Q4;

import java.util.LinkedList;
import java.util.Queue;

public class two_Three_FourTree {
	
	private Node root;
	private int height;

	public two_Three_FourTree() {
		this.root = null;
		height=0;
	}
	
	
	
	
	public Node getRoot() {
		return root;
	}




	public void setRoot(Node root) {
		this.root = root;
	}




	public int getHeight() {
		return height;
	}




	public void setHeight(int height) {
		this.height = height;
	}




	public void insert(int key){
		if(root==null)
			{
			root=new Node(0,true);
			int keys[]=root.getKeys();
			keys[1]=key;
			root.setKeys(keys);
			root.setN(1);
			}
		else{
			root.insert(key,this);
		}	
		
	}
	
	public void levelOrderTraversal(){
		Queue <Node> q=new LinkedList<Node>();
		q.add(root);
		Node x;
		
		while(q.isEmpty()==false){
			
			x=q.remove();
			
			for(int i=1;i<=x.getN();i++){
				System.out.print(x.getKey(i) + " ");
			}
			System.out.println("");
			for(int i=1;i<=x.getN()+1;i++){
				if(x.getChild(i)!=null)
					q.add(x.getChild(i));
			}			
		}
		
	}
	
	
		
}
