package Q2;

public class Element {

	private int key;
	private int priority;
	private Element left,right;
	
	public Element(int key, int priority) {
		super();
		this.key = key;
		this.priority = priority;
		left=right=null;
	}
	
	
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}

	public Element getLeft() {
		return left;
	}


	public void setLeft(Element left) {
		this.left = left;
	}


	public Element getRight() {
		return right;
	}


	public void setRight(Element right) {
		this.right = right;
	}
	
	public Element insert(int key,int priority){

		if(key<=this.key){
			if(left!=null){
				left=left.insert(key, priority);
			}
			else{
				left=new Element(key,priority);		
			}
		
			if(left.getPriority()>this.priority){		//rotate right
				Element x=left;
				Element y=this;
				
				y.setLeft(x.getRight());
				//y.getLeft().setParent(y);
				
				x.setRight(y);
				
			/*	if(y==y.getParent().getLeft()){
					y.getParent().setLeft(x);
					x.setParent(y.getParent());
					y.setParent(x);					
				}
			*/		
			return x;
			}
			
			return this;
		}
		
		else{
			if(right!=null){
				right=right.insert(key, priority);
			}
			else{
				right=new Element(key,priority);
			}

			if(right.getPriority()>this.getPriority()){	//rotate left
				Element y=this;
				Element x=right;
				
				y.setRight(x.getLeft());
				x.setLeft(y);
			
				return x;
			}
			
			return this;
		}
		
		
		
		
	}
	
	public void inOrder(){
			if(left!=null){
			left.inOrder();
		}
		
		System.out.println("key: " + key + "priority: " + priority);
		
		if(right!=null)
			right.inOrder();
	}
	
}
