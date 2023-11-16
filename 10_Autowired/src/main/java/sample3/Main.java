package sample3;

public class Main {

	public static void main(String[] args) {
		Consumer con = new Consumer();
		con.setName("À±¾Æ");
		con.setAge(20);

		Car c = new Morning();
		con.setCar(c);
		
		System.out.println(con.getName());
		System.out.println(con.getAge());
		System.out.println(con.personDrive());
	}
}
