package Q5;

public class Node {

	private int key,subtreeSize,localRank;
	private Node left,right,parent;
	
	public Node(int key) {
		this.key = key;
		this.left = null;
		this.right = null;
		this.parent = null;
		
	}
	
	
	
	
	public int getLocalRank() {
		return localRank;
	}




	public void setLocalRank(int localRank) {
		this.localRank = localRank;
	}




	public int getSubtreeSize() {
		return subtreeSize;
	}



	public void setSubtreeSize(int subtreeSize) {
		this.subtreeSize = subtreeSize;
	}


	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	public Node getParent() {
		return parent;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	public void insert(int key){
		
		if(key>this.key){
			if(right!=null){
				right.insert(key);				
			}
			
			else{
				Node x=new Node(key);
				x.setParent(this);
				this.setRight(x);
			}
		}
		
		else{
			if(left!=null){
				left.insert(key);
			}
			
			else{
				Node x=new Node(key);
				x.setParent(this);
				this.setLeft(x);				
			}
					
		}
		
	}
	
	public Node search(int key){
		if(key==this.key)
			return this;
		
		if(key>this.key){
			if(right!=null){
				return right.search(key);
			}
			
			else{
				return null;
			}
			
		}
		
		else{
			if(left!=null){
				return left.search(key);
			}
			
			else{
				return null;
			}
		}
		
	}
	
	public int findHeightOfNode(){
				
		int leftHeight=-1,rightHeight=-1;
		
		if(left!=null){
			leftHeight=left.findHeightOfNode();
		}
		
		if(right!=null){
			rightHeight=right.findHeightOfNode();
		}
		
		return (int)Math.max(leftHeight, rightHeight)+1;		
	}
	
	public int findDepthOfNode(){
	
		if(parent==null)
			return 0;
		
		return parent.findDepthOfNode() + 1 ;
		
	}
	
	public int sizeOfSubtree(){
		int leftSize=0,rightSize=0;
		
		if(left!=null)
			leftSize=left.sizeOfSubtree();
		if(right!=null)
			rightSize=right.sizeOfSubtree();
		
		return leftSize+rightSize+1;
	}
}
