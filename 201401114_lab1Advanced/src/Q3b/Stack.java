package Q3b;

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
		for(int i=top-1;i>=0;i--)
			System.out.println(arr[i]);
		
	}
	
	/*public void reverseContSubSequence(int p,int q){
		
		Stack st1=new Stack(arr.length);
		Stack st2=new Stack(arr.length);
		
		while(top!=q+1){
			st1.push(this.pop());
		}
		
		while(top!=p){
			st2.push(this.pop());
		}
		
		while(st2.isEmpty()==false){
			st1.push(st2.pop());
		}
		
		while(st1.isEmpty()==false){
			this.push(a);
		}
	}
	*/
}
