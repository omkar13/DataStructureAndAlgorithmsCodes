package Q4;

public class Node {

	private int n;//no of keys
	private int childNo;	//tells whats the no of this child node according to its parent
	private boolean isLeaf;
	private int keys[];
	private Node child[],parent;
	
	public Node(int n, boolean isLeaf) {
		this.n = n;
		this.isLeaf = isLeaf;
		this.keys = new int [4];	//one based
		this.child = new Node[5];	//one based
		this.parent=null;
		for(int i=1;i<=4;i++){
			child[i]=null;
		}				
									
	}
	
	public int getKey(int keyNo){
		return keys[keyNo];									//keyNo can be 1 2 or 3					
	}
	
	public Node getChild(int childNo){
		return child[childNo];								//child no can be 1 2 3 or 4
	}
	
	
	
	public int[] getKeys() {
		return keys;
	}

	public void setKeys(int[] keys) {
		this.keys = keys;
	}

	public Node[] getChild() {
		return child;
	}

	public void setChild(Node[] child) {
		this.child = child;
	}

	public int getN() {
		return n;
	}



	public void setN(int n) {
		this.n = n;
	}



	public boolean isLeaf() {
		return isLeaf;
	}



	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}



	public void addKey(int ke){
		
	}
	
	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	
	
	public int getChildNo() {
		return childNo;
	}

	public void setChildNo(int childNo) {
		this.childNo = childNo;
	}

	public void insert(int key,two_Three_FourTree t){
											//called on root
		if(n==3){							//root needs to be split
			Node s=new Node(1,false);
			t.setRoot(s);
			t.setHeight(t.getHeight()+1);
			s.isLeaf=false;
			s.n=0;
			Node children[]=s.getChild();
			children[1]=this;
			s.setChild(children);
			s.splitNode(this, 1);
			s.insertNonFullNode(key);
		}
		
		else{
			this.insertNonFullNode(key);
		}
		
		
	}
	
	public void insertNonFullNode(int key){
		/*if(n==3){							//spilt needed
			if(parent!=null){
				parent.splitNode(this,this.childNo);
				parent.insertNonFullNode(key);
			}
		}*/
		if(this.isLeaf==true){		//insert key directly__base case
			int pos=n;
			while(pos>=1 && keys[pos]>key){
				keys[pos+1]=keys[pos];
				pos--;
			}
			pos++;
			//insert at pos
			keys[pos]=key;			
			n++;
		}
		
		else{
			int pos=n;
		
			while(pos>=1 && keys[pos]>key){
				pos--;
			}
			pos++;
			//tell child at pos to insert
			System.out.println("pos :" + pos);
			if(child[pos].getN()==3){		//full child ...spilt it
				this.splitNode(child[pos], pos);
				
				if(key>keys[pos])
					pos++;			
			}
			
			child[pos].insertNonFullNode(key);
			
		}
			
	}
	
	public void splitNode(Node child,int childNo){			//child is node to be split. Note that spilt is called for parent of full child
		int pos=this.n + 1;											
		
		while(pos>=1 && childNo!=pos){
			this.child[pos+1]=this.child[pos];
			this.child[pos+1].setChildNo(pos+1);												//shift keys and children rightwards to make space for new node			
			keys[pos]=keys[pos-1];
			pos--;
		}
		this.n=this.n+1;
		Node x=new Node(1,child.isLeaf());
		x.setChildNo(pos+1);
		x.setParent(this);
		this.child[childNo+1]=x;
		
		if(child.isLeaf()==false){							//need to set up children of x
			Node childarr[]=x.getChild();
			childarr[1]=child.getChild(3);
			childarr[2]=child.getChild(4);
			x.setChild(childarr);
			child.setN(1);			
		}
		int keyarr[]=x.getKeys();
		keyarr[1]=child.getKey(3);
		x.setKeys(keyarr);
	}
	
	
}
