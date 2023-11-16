package sample2;

import org.springframework.stereotype.Component;

@Component("PointX")
public class PointX implements Shape{

	public PointX() {
		System.out.println("PointX");
	}
	
	@Override
	public String make() {
		return "x를 만들다";
	}

	@Override
	public String delete() {
		return "x를 지우다";
	}

}
