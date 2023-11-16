package sample1;

public class PointY implements Shape{
	
	public PointY() {
		System.out.println("PointY");
	}
	
	@Override
	public String make() {
		return "y를 만들다";
	}

	@Override
	public String delete() {
		return "y를 지우다";
	}
}
