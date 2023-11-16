package sample2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("rec")
public class RectangleImpl implements Rectangle{
	
	@Autowired
	@Qualifier("PointY")
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
