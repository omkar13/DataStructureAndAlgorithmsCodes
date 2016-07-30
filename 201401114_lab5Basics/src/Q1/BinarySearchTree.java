package Q1;

import java.util.LinkedList;
import java.util.Queue;

import Q1.Node;

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
	
	public Node delete(Node x){
		if(x.getLeft()==null){
			transplant(x,x.getRight());			
		}
		
		else if(x.getRight()==null){
			transplant(x,x.getLeft());
		}
		
		else{Node y=minimum(x.getRight().getKey());
		
		y.setLeft(x.getLeft());
		x.getLeft().setParent(y);
		
		if(y!=x.getRight()){
			transplant(y,y.getRight());
			y.setRight(x.getRight());
			x.getRight().setParent(y);
		}
		
		transplant(x,y);
		}
		
		return x;
	}
	
	public void transplant(Node u , Node v){		//places node v in place of u
													//children of v are not changed
		
		if(u.getParent()==null){
			root=v;
			return;
		}
		
		if(u.getParent().getLeft()==u){
			u.getParent().setLeft(v);
		}
		else{
			u.getParent().setRight(v);
		}
		if(v!=null)
			v.setParent(u.getParent());
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
	
	
	
	public void LeftRotate(Node x){
		if(x.getRight()==null){
			System.out.println("cannot left rotate as right child is not present");
			return ;
		}
		
		Node y=x.getRight();
		x.setRight(y.getLeft());		//Beta is set
		
		if(y.getLeft()!=null)
			y.getLeft().setParent(x);
		
		if(x!=root){
			Node z=x.getParent();
			y.setParent(z);
		
			if(x==z.getLeft()){
				z.setLeft(y);
			}
			else		
				z.setRight(y);
				
		}
		else{
			y.setParent(null);
			root=y;
		}
		
		x.setParent(y);
		y.setLeft(x);

		System.out.println("after left rotation: ");
		levelOrderTraversal();		
	}
	
	public void RightRotate(Node x){
		if(x.getLeft()==null){
			System.out.println("cannot right rotate as left child is not present");
			return ;
		}
		
		Node y=x.getLeft();
		x.setLeft(y.getRight());		//Beta is set
		
		if(y.getRight()!=null)
			y.getRight().setParent(x);
		
		if(x!=root){
			Node z=x.getParent();
			y.setParent(z);
		
			if(x==z.getLeft()){
				z.setLeft(y);
			}
			else		
				z.setRight(y);
				
		}
		else{
			y.setParent(null);
			root=y;
		}
		
		x.setParent(y);
		y.setRight(x);

		System.out.println("after right rotation: ");
		levelOrderTraversal();		
	}
	
	
}
