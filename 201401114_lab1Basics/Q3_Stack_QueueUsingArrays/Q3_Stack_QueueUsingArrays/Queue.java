package Q3_Stack_QueueUsingArrays;

//circular array implementation is used!
public class Queue {
	
int arr[],count,start,end;
	
	public Queue(int n) {
		arr=new int [n];
		count=0;
		start=0;
		end=0;
	}

	public void enqueue(int a){
	
		if(count==arr.length){
			System.out.println("Overflow!");
			return;
		}
		
		arr[(end)%arr.length]=a;
		end=(end+1)%arr.length;
		count++;
	}
	
	public int dequeue(){
		if(count==0){
			System.out.println("Underflow");
			return -1;		
		}
		
		count--;
		int x=arr[start];
		start=(start+1)%arr.length;
		return x;		
	}
	
	public void print(){
		int tc=0;
		
		while(tc!=count){
			System.out.println(arr[(tc+start)%arr.length]);
			tc++;
		}
		
	}
	
}