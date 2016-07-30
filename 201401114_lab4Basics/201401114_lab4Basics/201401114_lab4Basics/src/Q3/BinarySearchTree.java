package Q3;


public class BinarySearchTree {

	private Node root;

	public BinarySearchTree() {
		this.root = null;
	}
	
	public void insert(int key){
		if(root==null)
			root=new Node(key);
		else
			root.insert(key);
	}
	
	public Node search(int key){
		return root.search(key);
	}
	
	public Node maximum(int key){
		Node x=search(key);
		
		while(x.getRight()!=null){
			x=x.getRight();
		}
		return x;
	}
	
	public Node minimum(int key){
		Node x=search(key);
		
		while(x.getLeft()!=null){
			x=x.getLeft();
		}
		return x;
	}
	
	public Node successor(int key){
		Node n=search(key);
		
		if(n.getRight()!=null){
			return minimum(n.getRight().getKey());
		}
		
		Node x=n;
		Node y=n.getParent();
		
		while(y!=null && y.getRight()==x){
			x=y;
			y=y.getParent();
		}
		
		return y;
	}
	
	public Node predecessor(int key){
		Node n=search(key);
		
		if(n.getLeft()!=null){
			return maximum(n.getLeft().getKey());
		}
		
		Node x=n;
		Node y=n.getParent();
		
		while(y!=null && y.getLeft()==x){
			x=y;
			y=y.getParent();
		}
		
		return y;
	}
	
	
	
	
}
