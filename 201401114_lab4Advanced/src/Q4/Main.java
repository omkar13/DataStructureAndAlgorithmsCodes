package Q4;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);	
		System.out.println("enter height of tree");
		int h=sc.nextInt();
		sc.nextLine();
		
		int ans,temp=(int)Math.pow(8, Math.floor(h/2.0));
		//the ans is based upon sir's hint.
		if(h%2==1){
			ans=temp*2;			//note the factor of 2 comes because the root's child can be either left or right
		}
		else{
			ans=(temp/8)*3*2;	//here the last level is even but it doesnt have any children. So it gives factor of 3 and not 8. The factor of 2 is for the same reason as above
		}
		
		System.out.println("the no of subtrees possible is: " + ans);
	}

}
