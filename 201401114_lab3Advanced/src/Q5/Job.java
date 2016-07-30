package Q5;

public class Job {

	private int timeOfArrival;
	private int priority;
	public Job(int priority,int timeOfArrival) {
		super();
		this.timeOfArrival = timeOfArrival;
		this.priority = priority;
	}
	public int getTimeOfArrival() {
		return timeOfArrival;
	}
	public void setTimeOfArrival(int timeOfArrival) {
		this.timeOfArrival = timeOfArrival;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	};
	
	
	
}
