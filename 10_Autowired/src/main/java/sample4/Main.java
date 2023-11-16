package sample4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
//		Consumer con = new Consumer();
//		con.setName("À±¾Æ");
//		con.setAge(20);
//
//		Car c = new Morning();
//		con.setCar(c);
//		
//		System.out.println(con.getName());
//		System.out.println(con.getAge());
//		System.out.println(con.personDrive());
		
		String location = "/sample4/ctx.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(location);
		
		Person person = (Person)context.getBean("consumer");
		person.setName("À±¾Æ");
		person.setAge(20);
		
		System.out.println(person.getName());
		System.out.println(person.getAge());
		System.out.println(person.personDrive());
		
	}
}
