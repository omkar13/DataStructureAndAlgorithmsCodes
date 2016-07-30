package Q2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	
		Scanner sc=new Scanner (System.in);
		int n=sc.nextInt();
		sc.nextLine();
		System.out.println("give any location to find possible rank at that location");
		int i=sc.nextInt(),j=sc.nextInt();
		
		int lowerLimit=i*j;
		int upperLimit=n*(i+j-2)+i+j-i*j;
		System.out.println("lowest rank possible is: " + lowerLimit + "\nhighest rank possible is: " + upperLimit);
	
		System.out.println("enter a rank to get possible locations");
		int r=sc.nextInt();
		
		for(i=1;i<=n;i++){
			for(j=1;j<=n;j++){
				if(r>=i*j && r<=n*(i+j-2)+i+j-i*j)
					System.out.println(i + " " + j);				
				}
		}
		
		
	}

}
