package Q1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
	
	
	public void RecursiveinOrderTraversal(){
		root.inOrderTraversal();		
	}
	
	public void IterativeInOrderTraversal(){
		Node x=minimum(root.getKey());
		
		while(x!=null){
			System.out.print(x.getKey() + " ");
			x=successor(x.getKey());
		}
		
	}
	
	public void RecursivepreOrderTraversal(){
		root.preOrderTraversal();		
	}
	
	public void IterativePreOrderTraversal(){
		
		Node x=root;
		int prevMov=1;
		//prevMov = 1 --- down
		//prevMov = 2 --- up left
		//prevMov = 3 --- up right
		while(!(x==root && prevMov==3)){
			
		
			switch(prevMov){
		
			case 1: {
					System.out.print(x.getKey() + " ");	
					
					if(x.getLeft()!=null){
						x=x.getLeft();
						prevMov=1;
					}
					
					else if(x.getRight()!=null){
						x=x.getRight();
						prevMov=1;					
					}
					
					else{
						if(x.getParent().getLeft()==x){
							prevMov=2;
						}
						else
							prevMov=3;
						
						x=x.getParent();
						
					}
					break;
			}
			
			case 2: {
				if(x.getRight()!=null){
					x=x.getRight();
					prevMov=1;					
				}
				
				else{
					if(x.getParent().getLeft()==x){
						prevMov=2;
					}
					else
						prevMov=3;
					
					x=x.getParent();
					
				}
			break;
			}
			
			case 3: {
				if(x.getParent().getLeft()==x){
					prevMov=2;
				}
				else
					prevMov=3;
				
				x=x.getParent();
				
				}
		}
		
		}
		
		
	}
	
public void IterativePostOrderTraversal(){
		
		Node x=root;
		int prevMov=1;
		//prevMov = 1 --- down
		//prevMov = 2 --- up left
		//prevMov = 3 --- up right
		while(!(x==root && prevMov==3)){
			
		
			switch(prevMov){
		
			case 1: {
					
					if(x.getLeft()!=null){
						x=x.getLeft();
						prevMov=1;
					}
					
					else if(x.getRight()!=null){
						x=x.getRight();
						prevMov=1;					
					}
					
					else{
						System.out.print(x.getKey() + " ");	
						
						if(x.getParent().getLeft()==x){
							prevMov=2;
						}
						else
							prevMov=3;
						
						x=x.getParent();
						
					}
					break;
			}
			
			case 2: {
				if(x.getRight()!=null){
					x=x.getRight();
					prevMov=1;					
				}
				
				else{
					System.out.print(x.getKey() + " ");	
					
					if(x.getParent().getLeft()==x){
						prevMov=2;
					}
					else
						prevMov=3;
					
					x=x.getParent();
					
				}
			break;
			}
			
			case 3: {
				System.out.print(x.getKey() + " ");	
				
				if(x.getParent().getLeft()==x){
					prevMov=2;
				}
				else
					prevMov=3;
				
				x=x.getParent();
				
				}
		}
		
		}
		
		System.out.print(root.getKey() + " ");	
				
	}
	
	public void RecursivepostOrderTraversal(){
		root.postOrderTraversal();		
	}
	
	public void zigZagTraversal(){
		Stack<Node> sEven=new Stack<Node>();
		Stack<Node> sOdd=new Stack<Node>();
		Stack<Node> currentStack;
		Node x;
		
		if(root!=null){
			sEven.push(root);
		}
		
		currentStack=sEven;
		
		while(sEven.isEmpty()==false || sOdd.isEmpty()==false){
			
			if(currentStack==sEven){
				x=currentStack.pop();
				
				if(x.getLeft()!=null){
					sOdd.push(x.getLeft());
				}
				if(x.getRight()!=null){
					sOdd.push(x.getRight());
				}
			}
			
			else{
				x=currentStack.pop();
				
				if(x.getRight()!=null){
					sEven.push(x.getRight());
				}				
				if(x.getLeft()!=null){
					sEven.push(x.getLeft());
				}			
			}
			
			System.out.print(x.getKey() + " ");
		
			if(currentStack.isEmpty()){
				if(currentStack==sEven)
					currentStack=sOdd;
				else
					currentStack=sEven;
			}
		}
		
		
	}
	
	public void levelOrderTraversal(){
		Queue<Node> q=new LinkedList<Node>();
		q.add(root);
		Node x;
		
		while(q.isEmpty()==false){
			x=q.remove();
			System.out.print(x.getKey() + " ");
			
			if(x.getLeft()!=null){
				q.add(x.getLeft());
			}
			
			if(x.getRight()!=null){
				q.add(x.getRight());
			}
		}
		
		
		
		
	}
	
}
