package sample3;

public class Morning implements Car{

	public Morning() {
		System.out.println("Morning()");
	}
	
	@Override
	public String drive() {
		return "Morning-drive";
	}

}
