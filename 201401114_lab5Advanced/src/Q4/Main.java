package Q4;

import java.util.Scanner;

public class Main {

	public static void main(String args[]){
		Scanner sc=new Scanner (System.in);
		System.out.println("enter no of keys to add");
		int n=sc.nextInt();
		two_Three_FourTree t=new two_Three_FourTree();
		for(int i=1;i<=n;i++){
			t.insert(sc.nextInt());
			System.out.println("height of tree is : " + t.getHeight());
			t.levelOrderTraversal();
		}		
		sc.close();
	}
}
