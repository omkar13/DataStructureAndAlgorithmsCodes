package Q5;

import java.util.Scanner;

public class JobSchedulerMain {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("input jobs in any order of priority but increasing order of time");
		JobScheduler js=new JobScheduler();
		boolean loop=true;
		
		while(loop){
			System.out.println("enter \n 1: to add new job(give priority and time of arrival)\n"
								+ " 2: to remove highest priority job which came earliest\n"
								+ " 3: exit\n");
			
			int option=sc.nextInt();
			sc.nextLine();
			
			switch(option){
			
			case 1:int p=sc.nextInt();
					int t=sc.nextInt();
					sc.nextLine();
					js.addNewJob(p, t);
					
					break;
					
			case 2: Job j=js.removeHighestPriorityJobWhichArrivedEarliest();
				
					if(j==null){
						System.out.println("no jobs left");
						break;
					}
			
					System.out.println("HighestPriorityJobWhichArrivedEarliest is Job priority: " + j.getPriority() + " Its time of arrival was: " + j.getTimeOfArrival());
					System.out.println("this job has been removed");
					break;
			
			case 3: loop=false;
			}
			
		}
		
		
		sc.close();
	}

}
