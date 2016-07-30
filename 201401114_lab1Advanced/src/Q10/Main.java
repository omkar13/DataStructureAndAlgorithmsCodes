package Q10;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ModifiedListDS ll=new ModifiedListDS();
		Scanner sc=new Scanner(System.in);
				
		System.out.println("enter no of elements to add");
		int n=Integer.parseInt(sc.nextLine());
		
		for(int i=0;i<n;i++){
			ll.add(Integer.parseInt(sc.nextLine()));
		}
		
		ll.print();
		System.out.println("enter no of elements to delete");
		n=Integer.parseInt(sc.nextLine());
		
		for(int i=0;i<n;i++){
			ll.delete();
			ll.print();
		}
		sc.close();
	}
}
