package Q3_Stack_QueueUsingArrays;

public class Stack {

	int arr[],count;

	public Stack(int n) {
		this.arr = new int [n];
		count=0;
	}
	
	public void push(int a){
		if(count==arr.length)
		{System.out.println("stack overflow");
		return;	
		}
		
		arr[count] = a ;
		count++;
	}
	
	public int pop(){
		if(count==0){
			System.out.println("Stack is empty-pop not allowed");
			return 0;
		}
		
		else
			{
			return arr[(count--)-1];
			}
	}
	
	public void print(){
		for(int i=count-1;i>=0;i--)
			System.out.println(arr[i]);
	}
}
