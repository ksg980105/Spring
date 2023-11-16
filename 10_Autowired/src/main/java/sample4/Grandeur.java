package sample4;

import org.springframework.stereotype.Component;

@Component("grandeur")
public class Grandeur implements Car{

	public Grandeur() {
		System.out.println("Grandeur()");
	}
	
	@Override
	public String drive() {
		return "Grandeur-drive";
	}
	
}
