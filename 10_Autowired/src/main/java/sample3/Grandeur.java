package sample3;

public class Grandeur implements Car{

	public Grandeur() {
		System.out.println("Grandeur()");
	}
	
	@Override
	public String drive() {
		return "Grandeur-drive";
	}
	
}
