package Q4;

public class BinaryTree {

	private Node root;
	
	public BinaryTree(){
		root=null;
	}
	 
	
	public Node getRoot() {
		return root;
	}


	public void setRoot(Node root) {
		this.root = root;
	}

//this function makes binary tree from arbitrary rooted tree
	public void makeBinaryTree(int arr[][],char nodes[]){
		
		Queue<Node> q=new Queue<>();
		
		root=new Node(nodes[0],1);
		Node temp;
		int no;
		q.enqueue(root);
		
		while(q.isEmpty()==false){
			
			//q.print();
			
			temp=q.dequeue();
			no=temp.getNo();		//1 based
			int i;
			
			for(i=1;i<arr[no].length && arr[no][i]==0;i++){
				
			}
			
			if(i==arr[no].length)
				continue;
			
			temp.setLeftChild(new Node(nodes[i-1],i));
			temp=temp.getLeftChild();
			q.enqueue(temp);
			i++;
			
			for(;i<arr[no].length;i++){
				if(arr[no][i]==1){
					temp.setRightChild(new Node(nodes[i-1],i));
					temp=temp.getRightChild();
					q.enqueue(temp);
				}
			}
		}
		
		
	}
	//returns adjacency matrix of arbitrary rooted tree
	public int[][] GetBackArbitaryRootedtree(BinaryTree bt,char nodes[]){
		
		Queue <Node> q=new Queue<>();
		q.enqueue(bt.getRoot());
		Node temp;
		int n=nodes.length;
		int arr[][]= new int [n+1][n+1];
		
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++)
				arr[i][j]=0;
		}
		
		while(q.isEmpty()==false){
			temp=q.dequeue();
			int r=temp.getNo();
			
			temp=temp.getLeftChild();
			
			while(temp!=null){
				q.enqueue(temp);
				arr[r][temp.getNo()]=1;
				temp=temp.getRightChild();
				
			}
			
		}
		
		return arr;
		
	}
	
	
	public void printLevelOrder(){
		int c=1;	//no of elements in current level
		int n=0;	//no of elements in next level
		
		Queue <Node> q=new Queue<Node>();
		q.enqueue(root);
		Node temp;
		
		while(q.isEmpty()==false){
			temp=q.dequeue();
			System.out.print(temp +" ");
			c--;
			
			if(temp.getLeftChild()!=null){
				q.enqueue(temp.getLeftChild());
				n++;
			}
			
			if(temp.getRightChild()!=null){
				q.enqueue(temp.getRightChild());
				n++;
			}
			
			if(c==0){
				System.out.println();
				c=n;
				n=0;				
			}
			
		}
		
		
	}
	
}

class Node{
	private char data;
	private int no;
	private Node leftChild,rightChild;
	
	public Node(char data,int no) {
		this.data = data;
		this.leftChild = null;
		this.rightChild =null;
		this.no=no;
	}

	
	public int getData() {
		return data;
	}

	public void setData(char data) {
		this.data = data;
	}

	public Node getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	public Node getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}
	
	public String toString(){
		return Character.toString(data);
		
	}
	
	
}