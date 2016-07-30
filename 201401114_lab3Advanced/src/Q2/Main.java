package Q2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner (System.in);
		System.out.println("enter no of elements in treap");
		int n=sc.nextInt();
		sc.nextLine();
		System.out.println("enter key and priority  value separated by a space on each line");
		Treap t=new Treap();
		
		for(int i=0;i<n;i++){
		String s[]=sc.nextLine().split(" ");
		int key=Integer.parseInt(s[0]);
		int priority=Integer.parseInt(s[1]);
			t.insert(key, priority);			
		}
		
		t.inOrder();
		t.levelOrder();
	}

}
