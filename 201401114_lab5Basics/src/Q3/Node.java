package Q3;

public class Node {
	private int key,height,balance;
	private Node left,right,parent;
	
	public Node(int key) {
		this.key = key;
		this.left = null;
		this.right = null;
		this.parent = null;
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
	
	public int findHeightOfAllNodes(){
		
		int leftHeight=-1,rightHeight=-1;
		
		if(left!=null){
			leftHeight=left.findHeightOfAllNodes();
		}
		
		if(right!=null){
			rightHeight=right.findHeightOfAllNodes();
		}
		
		height = (int)Math.max(leftHeight, rightHeight)+1;
		
		return height;
	}
	
	
}
