package Q2;

import java.util.LinkedList;
import java.util.Queue;

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

	
	public int levelOrderTraversalForInversions(){
		
		SubtreeSizeAndLocalRank(root);
		
		Queue<Node> q=new LinkedList<Node>();
		q.add(root);
		int inversions=0,currentLevel=0,count=0;
		root.setLevel(0);
		Node x;
		
		while(q.isEmpty()==false){
			x=q.remove();
			
			if(x.getLevel()!=currentLevel){
				currentLevel++;
				count=0;
			}
			
			
			
			System.out.println(x.getKey());
			
			if(x.getLeft()!=null){
				q.add(x.getLeft());
				x.getLeft().setLevel(currentLevel+1);
				count=count + x.getLeft().getSubtreeSize();
				
			}
			inversions=inversions + count;
			
			if(x.getRight()!=null){
				q.add(x.getRight());
				x.getRight().setLevel(currentLevel+1);
				count=count + x.getRight().getSubtreeSize();
			}
			
		}
		
		return inversions;
		
	}
}
