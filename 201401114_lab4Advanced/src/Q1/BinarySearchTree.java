package Q1;

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
	public int subtreePresence(int i,int j){
		SubtreeSizeAndLocalRank(root);				//this will initialize subtreeSize and local ranks of all nodes
		root.setBaseRank(1);
		root.setRank(root.getBaseRank()+ root.getLocalRank()-1  );
		baseRankAndRank(root);		//this will initialize base ranks and ranks of all nodes

		this.levelOrderTraversalWithRanks();
		
		Node x=root;
		
		while(x!=null){
			if(x.getRank()<i){
				x=x.getRight();
			}
			else if(x.getRank()>j){
				x=x.getLeft();
			}
			
			else{
				if(x.getBaseRank()!=i)
					return -1;
				if((j-i+1)!=x.getSubtreeSize())
					return -1;
				
				return x.getRank();
			}
			
		}
		
		return -1;
		
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

	//this will initialize base ranks and ranks of all nodes
	public void baseRankAndRank(Node x){
		
		if(x.getLeft()!=null){
			x.getLeft().setBaseRank(x.getBaseRank());
			int leftRank=x.getLeft().getBaseRank() + x.getLeft().getLocalRank() -1;
			x.getLeft().setRank(leftRank);
			baseRankAndRank(x.getLeft());
		}
		
		if(x.getRight()!=null){
			x.getRight().setBaseRank(x.getRank()+1);
			int RightRank=x.getRight().getBaseRank() + x.getRight().getLocalRank() -1;
			x.getRight().setRank(RightRank);
			baseRankAndRank(x.getRight());			
		}
		
	}
	
	public void levelOrderTraversalWithRanks(){
		Queue<Node> q=new LinkedList<Node>();
		q.add(root);
		Node x;
		
		while(q.isEmpty()==false){
			x=q.remove();
			System.out.println(x.getKey() + " " + x.getBaseRank() + " " + x.getLocalRank() + " " + x.getRank());
			
			if(x.getLeft()!=null){
				q.add(x.getLeft());
			}
			
			if(x.getRight()!=null){
				q.add(x.getRight());
			}
		}
		
		
		
		
	}
}
