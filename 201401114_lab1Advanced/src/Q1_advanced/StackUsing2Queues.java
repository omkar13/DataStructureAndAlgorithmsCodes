package Q1_advanced;

public class StackUsing2Queues {

	Queue q1;
	Queue q2;
	
	public StackUsing2Queues(int n) {
		this.q1 = new Queue(n);
		this.q2 = new Queue(n);
	}
	
	public void push(int a){
		q1.enqueue(a);	
	}
	
	public int pop(){
		
		if(q1.isEmpty())
			{System.out.println("underflow!");
			return -1;
			}
		else
			{int temp=q1.dequeue();
			
				while(q1.isEmpty()==false){
					q2.enqueue(temp);
					temp=q1.dequeue();						
				}
				
				while(q2.isEmpty()==false){
					q1.enqueue(q2.dequeue());
				}
				return temp;
			}
	}
	
	public void print(){
		q1.printRev();
	}
	
	
	
}
