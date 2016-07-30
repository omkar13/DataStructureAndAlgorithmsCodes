package Q1;

public class Node {

	private int key,height,balance,depth;
	private Node left,right,parent;
	
	public Node(int key) {
		this.key = key;
		this.left = null;
		this.right = null;
		this.parent = null;
		this.depth=0;
	}
	
	
	public int getDepth() {
		return depth;
	}


	public void setDepth(int depth) {
		this.depth = depth;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public int getBalance() {
		return balance;
	}


	public void setBalance(int balance) {
		this.balance = balance;
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
	
	public Node bstInsert(int key){
		
		if(key>this.key){
			if(right!=null){
				return right.bstInsert(key);				
			}
			
			else{
				Node x=new Node(key);
				x.setParent(this);
				this.setRight(x);
				return x;
			}
		}
		
		else{
			if(left!=null){
				return left.bstInsert(key);
			}
			
			else{
				Node x=new Node(key);
				x.setParent(this);
				this.setLeft(x);				
				return x;
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
			{this.setDepth(0);
			return 0;
			}
		
		this.setDepth(parent.findDepthOfNode() + 1);
		return this.getDepth() ;	
	}
	
}


