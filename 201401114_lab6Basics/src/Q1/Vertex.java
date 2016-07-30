package Q1;

public class Vertex {

	private int distance;
	private String color;
	private Vertex parent;
	private int value;
	private int no;
	
	public Vertex(int value,int no) {
		this.value = value;
		this.no=no;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
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
	
	
	
}
