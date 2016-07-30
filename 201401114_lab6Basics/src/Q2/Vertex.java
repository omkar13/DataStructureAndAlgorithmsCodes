package Q2;

public class Vertex {

	private String color;
	private Vertex parent;
	private int value;
	private int no;
	private int discoveryTime,finishingtime;
	
	public Vertex(int value,int no) {
		this.value = value;
		this.no=no;
		this.discoveryTime=this.finishingtime=0;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Vertex getParent() {
		return parent;
	}

	public void setParent(Vertex parent) {
		this.parent = parent;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getDiscoveryTime() {
		return discoveryTime;
	}

	public void setDiscoveryTime(int discoveryTime) {
		this.discoveryTime = discoveryTime;
	}

	public int getFinishingtime() {
		return finishingtime;
	}

	public void setFinishingtime(int finishingtime) {
		this.finishingtime = finishingtime;
	}
	
	
}
