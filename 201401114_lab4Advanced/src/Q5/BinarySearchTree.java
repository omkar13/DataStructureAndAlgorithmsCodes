package Q5;

public class BinarySearchTree {

	private Node root;

	
	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

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
	//this will initialize subtreeSize and local ranks of all nodes
	public int SubtreeSizeAndLocalRank(Node x){
		if(x.getLeft()!=null){
			x.setLocalRank(SubtreeSizeAndLocalRank(x.getLeft())+1);
		}
		else{
			x.setLocalRank(1);
		}
		
		if(x.getRight()!=null){
			x.setSubtreeSize(x.getLocalRank() +  SubtreeSizeAndLocalRank(x.getRight()) );
		}
		else
			x.setSubtreeSize(x.getLocalRank());
	
	return x.getSubtreeSize();
	}

	//main method
	public int noOfOrderingsPossible(Node x){
		if(x==null)
			return 1;
		
		int l=0,r=0;
		
		if(x.getLeft()!=null){
			l=x.getLeft().getSubtreeSize();
		}
		
		if(x.getRight()!=null){
			r=x.getRight().getSubtreeSize();
		}
		
		return comb(l+r,l)*noOfOrderingsPossible(x.getLeft())*noOfOrderingsPossible(x.getRight());
		
	}
	
	public static int comb(int n,int r){
		
		int nCr=fact(n)/(fact(n-r)*fact(r));
		return nCr;
	}
		
	public static int fact(int n){
	
		int factorial=1;
		for(int i=2;i<=n;i++){
			factorial=factorial*i;
		}
		return factorial;
	}
	
}
