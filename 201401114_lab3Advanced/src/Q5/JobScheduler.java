package Q5;

import java.util.LinkedList;
import java.util.Queue;

public class JobScheduler {

	Queue<Job> q;
	Queue<Job> temp;
	int lowestPriority;
	
	public JobScheduler() {
		q = new LinkedList<Job>();
		temp=new LinkedList<Job>();
		lowestPriority=Integer.MAX_VALUE;
	}
	
	public void addNewJob(int priority , int time){
		Job j=new Job(priority,time);
		
		if(priority<=lowestPriority){
			q.add(j);
			lowestPriority=priority;
			return;
		}
	
		while(q.peek().getPriority()>=priority){
			temp.add(q.remove());				//copy all high priority jobs in same order
		}
		
		temp.add(j);				//inserting new job at its correct location according to priority and time of arrival
		
		while(!q.isEmpty()){		//copy remaining low priority jobs in same order
			temp.add(q.remove());
		}
		
		while(!temp.isEmpty()){			//transfer everything to main queue q
			q.add(temp.remove());		
		}
	}
	
	public Job removeHighestPriorityJobWhichArrivedEarliest(){
		if(q.isEmpty())
			return null;
		
		return q.remove();		
	}	
}
