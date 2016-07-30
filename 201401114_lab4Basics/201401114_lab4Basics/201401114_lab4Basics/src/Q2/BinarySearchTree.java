package Q2;

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
	
	public int findHeightOfNode(int key){
		Node n=search(key); 
		return n.findHeightOfNode();
	}
	
	public int findDepthOfNode(int key){
		Node n=search(key); 
		return n.findDepthOfNode();		
	}
		
	public Node search(int key){
		return root.search(key);
	}
	
	public int sizeOfSubtree(int k){
		Node n=search(k); 
		return n.sizeOfSubtree();
	}

}
