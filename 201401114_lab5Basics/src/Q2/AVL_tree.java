package Q2;

import java.util.LinkedList;
import java.util.Queue;

public class AVL_tree {
	
		private Node root;

		public AVL_tree() {
			this.root = null;
		}
		
		public void AVL_insert(int key){
			AVL_restore(BstInsert(key));		
		}
		
		public Node BstInsert(int key){
			if(root==null)
				{root=new Node(key);
				return root;
				}
			else
				return root.bstInsert(key);
			
		}
		
		public void AVL_restore(Node x){
			x.setHeight(-1);
			x.setBalance(0);
			
			//keep going up till u encounter a previously unbalanced node
			//On the way update the balance and heights of the nodes
			while(x!=null && x.getBalance()==0){
				x.setHeight(x.getHeight()+1);
				x.setBalance(height(x.getRight())-height(x.getLeft()));
				x=x.getParent();				
			}
			
			if(x!=null){
				//compute new balance of the previously unbalanced node
				//new balance will be 2 , -2 or 0
				x.setBalance(height(x.getRight())-height(x.getLeft()));
				 
				//if balance is 0 dont do anything
				
				if(x.getBalance()==-2){
					//check if double rotation is required
					if(x.getLeft().getBalance()==1){
						LeftRotate(x.getLeft());
						//??why to exchange heights??
						/*int h=x.getLeft().getHeight();
						x.getLeft().setHeight(x.getLeft().getLeft().getHeight());
						x.getLeft().getLeft().setHeight(h);
						*/
						x.getLeft().setHeight(x.getLeft().findHeightOfNode());
						x.getLeft().getLeft().setHeight(x.getLeft().getLeft().findHeightOfNode());
						
						x.getLeft().setBalance(height(x.getLeft().getRight())-height(x.getLeft().getLeft()));
						x.getLeft().getLeft().setBalance(height(x.getLeft().getLeft().getRight())-height(x.getLeft().getLeft().getLeft()));
					}
					
					RightRotate(x);	
					/*int h=x.getHeight();
					x.setHeight(x.getParent().getHeight());
					x.getParent().setHeight(h);
					*/
					x.setHeight(x.findHeightOfNode());
					x.getParent().setHeight(x.getParent().findHeightOfNode());
					x.setBalance(height(x.getRight())-height(x.getLeft()));
					x.getParent().setBalance(x.getHeight()-x.getParent().getLeft().getHeight());
					
				}
				
				else if(x.getBalance()==2){
					if(x.getRight().getBalance()==-1){
						RightRotate(x.getRight());
						
						/*int h=x.getRight().getHeight();
						x.getRight().setHeight(x.getRight().getRight().getHeight());
						x.getRight().getRight().setHeight(h);
						*/
						x.getRight().setHeight(x.getRight().findHeightOfNode());
						x.getRight().getRight().setHeight(x.getRight().getRight().findHeightOfNode());
								
						x.getRight().setBalance(height(x.getRight().getRight())-height(x.getRight().getLeft()));
						x.getRight().getRight().setBalance(height(x.getRight().getRight().getRight())-height(x.getRight().getRight().getLeft()));
						
					}
					
					LeftRotate(x);
					
					/*
					int h=x.getHeight();
					x.setHeight(x.getParent().getHeight());
					x.getParent().setHeight(h);
					*/
					x.setHeight(x.findHeightOfNode());
					x.getParent().setHeight(x.getParent().findHeightOfNode());
					
					x.setBalance(height(x.getRight())-height(x.getLeft()));
					x.getParent().setBalance(height(x.getParent().getRight())-x.getHeight());
					
				}
				
			}
			
		}
		
		public int height(Node x){
			if(x==null)
				return -1;
			
			return x.findHeightOfNode();
			
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
		
		/*public Node delete(Node x){
			
		
		
		}
		*/
		
		public Node delete(Node x){
			if(x==null)
				{System.out.println("node doesnt exist");
				return null;
				}
			Node p;
			
			if(x.getLeft()==null){
				p=x.getParent();
				transplant(x,x.getRight());	
			}
			
			else if(x.getRight()==null){
				p=x.getParent();
				transplant(x,x.getLeft());
			}
			
			else{
				Node y=minimum(x.getRight().getKey());
				p=y.getParent();
				
			y.setLeft(x.getLeft());
			x.getLeft().setParent(y);
			
			if(y!=x.getRight()){
				transplant(y,y.getRight());
				y.setRight(x.getRight());
				x.getRight().setParent(y);
			//	y.setHeight(1 + Math.max(y.getLeft().getHeight(), y.getRight().getHeight()));
			//	y.setBalance(y.getRight().getHeight() - y.getLeft().getHeight());
		
			}
			
			else{
				p=x.getParent();
			//	y.setHeight(1 + Math.max(y.getLeft().getHeight(), y.getRight().getHeight()));
			//	y.setBalance(y.getRight().getHeight() - y.getLeft().getHeight());
			}
			
			transplant(x,y);
			}
			
			//recalculate heights and balance of ancestors of p
			Node n=p;
			
			while(n!=null){
				n.setHeight(1 + Math.max(height(n.getLeft()), height(n.getRight())));
				n.setBalance(height(n.getRight()) - height(n.getLeft()));
				n=n.getParent();
			}
			
			delete_restore(p);		//the node p is above which restoring will have to be done
									//if node is leaf p is its parent
									//if node has only 1 child p is again its parent
									//if node has 2 children p is parent of its successor if its successor is not its right child
									//if successor is right child p is parent of node 
			return x;
		}
		
		
		public void delete_restore(Node x){
			x.setHeight(1 + Math.max(height(x.getLeft()), height(x.getRight())));
			
			while(x!=null){													//in delete we need to go all the way up to the root
		
			if(x.getBalance()!=0)	
				{
				x.setBalance(height(x.getRight()) - height(x.getLeft()));
				
				if(x.getBalance()==-2){
					if(x.getLeft().getBalance()==1){
						LeftRotate(x.getLeft());
						
						x.getLeft().setHeight(x.getLeft().findHeightOfNode());
						x.getLeft().getLeft().setHeight(x.getLeft().getLeft().findHeightOfNode());
						
						x.getLeft().setBalance(height(x.getLeft().getRight())-height(x.getLeft().getLeft()));
						x.getLeft().getLeft().setBalance(height(x.getLeft().getLeft().getRight())-height(x.getLeft().getLeft().getLeft()));															//left rotate at left(x)
						
						
					}
					RightRotate(x);	
					/*int h=x.getHeight();
					x.setHeight(x.getParent().getHeight());
					x.getParent().setHeight(h);
					*/
					x.setHeight(x.findHeightOfNode());
					x.getParent().setHeight(x.getParent().findHeightOfNode());
					x.setBalance(height(x.getRight())-height(x.getLeft()));
					x.getParent().setBalance(x.getHeight()-x.getParent().getLeft().getHeight());
					
					x=x.getParent();
					
				}
				
				else if(x.getBalance()==2){
					if(x.getRight().getBalance()==-1){
						RightRotate(x.getRight());
				
						x.getRight().setHeight(x.getRight().findHeightOfNode());
						x.getRight().getRight().setHeight(x.getRight().getRight().findHeightOfNode());
								
						x.getRight().setBalance(height(x.getRight().getRight())-height(x.getRight().getLeft()));
						x.getRight().getRight().setBalance(height(x.getRight().getRight().getRight())-height(x.getRight().getRight().getLeft()));
						
					}
					
					LeftRotate(x);
					
					x.setHeight(x.findHeightOfNode());
					x.getParent().setHeight(x.getParent().findHeightOfNode());
					
					x.setBalance(height(x.getRight())-height(x.getLeft()));
					x.getParent().setBalance(height(x.getParent().getRight())-x.getHeight());
				
					x=x.getParent();
				}
				
				//h(x)=h(x)-1       ???
				x=x.getParent();
							
				}
			//just update height and balance
			else{
				x.setHeight(x.findHeightOfNode());
				x.setBalance(height(x.getRight())-height(x.getLeft()));
				x=x.getParent();
				
			}
			
			}
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
				System.out.print(x.getKey() + "," + x.getBalance() + "\n");
				
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


