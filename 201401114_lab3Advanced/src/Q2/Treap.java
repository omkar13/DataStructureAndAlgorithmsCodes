package Q2;

import java.util.LinkedList;
import java.util.Queue;

public class Treap {

	private Element root;

	public Treap() {
		this.root = null;
	}
	
	public void insert(int key,int priority){
		if(root==null)
			root=new Element(key,priority);
	
		else{
			root=root.insert(key, priority);			
		}
		
	}
	
	public void inOrder(){
		root.inOrder();
		
	}
	
	public void levelOrder(){
		Queue <Element>q=new LinkedList<Element>();
		q.add(root);
		Element x;
		int level=1,nextLevel=0;
		
		
		while(q.isEmpty()==false){
			x=q.remove();
			level--;
			System.out.print(x.getKey() + " " + x.getPriority() +"  ,  ");
		
			if(x.getLeft()!=null){
				q.add(x.getLeft());
				nextLevel++;
			}
			
			if(x.getRight()!=null){
				q.add(x.getRight());
				nextLevel++;
			}
			
			if(level==0){
				level=nextLevel;
				nextLevel=0;
				System.out.println();
			}
		}
		
	}
	
}
