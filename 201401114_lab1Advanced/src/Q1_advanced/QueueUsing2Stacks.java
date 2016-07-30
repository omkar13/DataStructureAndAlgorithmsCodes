package Q1_advanced;

public class QueueUsing2Stacks {

	Stack s1;
	Stack s2;
	
	public QueueUsing2Stacks(int n) {
		
		this.s1 = new Stack(n);
		this.s2 = new Stack(n);
	
	}
	
	public void enqueue(int a){
		s1.push(a);		
	}
	
	public int dequeue(){
		
		int temp;
		if(s1.isEmpty())
			{System.out.println("Underflow!");
			return -1;
			}
		
		else{
			while(s1.isEmpty()==false){
				s2.push(s1.pop());
			}
			
			temp=s2.pop();
			
			while(s2.isEmpty()==false){
				s1.push(s2.pop());
			}
			
			return temp;
		}
		
	}
	
	public void print(){
		s1.printRev();	
	}

	
	
	
}
