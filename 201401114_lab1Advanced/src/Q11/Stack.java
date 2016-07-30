package Q11;

public class Stack {
	int arr[],top;

	public Stack(int n) {
		
		this.arr = new int [n];
		this.top = 0;
	}
	
	public void push(int a){
		if(top==arr.length)
			System.out.println("overflow!!");
		else
			arr[top++]=a;		
	}

	public int pop(){
		if(top==0)
			{System.out.println("underflow!!");
			return -1;
			}
		
		else{
			int x=arr[top-1];
			top--;
			return x;
		}
		
	}
	
	public boolean isEmpty(){
		if(top==0){
			return true;
		}
		else
			return false;
	}
	
	public void print(){ 
		if(top==0){
			System.out.println("stack is empty");
			return;
		}
			
		for(int i=top-1;i>=0;i--)
			System.out.println(arr[i]);
		
	}
	
}
