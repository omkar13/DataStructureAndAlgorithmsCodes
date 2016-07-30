package Q1_advanced;

public class Stack {

	int arr[],count;

	public Stack(int n) {
		this.arr = new int [n];
		count=0;
	}
	
	
	public int getCount() {
		return count;
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
			return -1;
		}
		
		else
			{
			return arr[(count--)-1];
			}
	}
	
	public boolean isEmpty(){
		if(count==0)
			return true;
		else
			return false;
	}
	
	public void print(){
		for(int i=count-1;i>=0;i--)
			System.out.println(arr[i]);
	}
	
	public void printRev(){
		for(int i=0;i<=count-1;i++)
			System.out.println(arr[i]);
	}
	
	
}