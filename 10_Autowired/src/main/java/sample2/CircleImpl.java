package sample2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("myCircleImpl")
public class CircleImpl implements Circle{
	
	@Autowired
	@Qualifier("PointX")
	Shape pointx;
	int x;
	int y;
	int radius;
	
	public CircleImpl() {
		System.out.println("CircleImpl()");
	}
	

	public Shape getPointx() {
		return pointx;
	}


	public void setPointx(Shape pointx) {
		System.out.println("setPointx(Shape pointx)");
		this.pointx = pointx;
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
		return pointx.make();
	}

}
