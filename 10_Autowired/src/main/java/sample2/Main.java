package sample2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
//		Shape px = new PointX();
//		PointY py = new PointY();
//		
//		CircleImpl circle = new CircleImpl();
//		circle.setPointx(px);
//		System.out.println(circle.make());
//		
//		System.out.println("---------------------");
		
		String location = "/sample2/ctx.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(location);
		
//		Circle circle = (CircleImpl) context.getBean("myCircleImpl");
//		Circle circle = context.getBean("myCircleImpl",Circle.class);
//		System.out.println(circle.make());
		
		Rectangle rectangle = context.getBean("rec",Rectangle.class);
		System.out.println(rectangle.make());
	}

}
