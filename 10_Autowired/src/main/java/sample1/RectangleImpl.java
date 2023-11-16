package sample1;

public class RectangleImpl implements Rectangle{

	Shape pt;
	int x;
	int y;
	int radius;
	
	public RectangleImpl() {
		System.out.println("CircleImpl()");
	}
	

	public Shape getPt() {
		return pt;
	}


	public void setPt(Shape pt) {
		System.out.println("setPt(Shape pt)");
		this.pt = pt;
	}


	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public String make() {
		return pt.make();
	}

}
