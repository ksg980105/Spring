package sample1;

public class PointX implements Shape{

	public PointX() {
		System.out.println("PointX");
	}
	
	@Override
	public String make() {
		return "x�� �����";
	}

	@Override
	public String delete() {
		return "x�� �����";
	}

}
