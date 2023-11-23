package travel.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class TravelBean {
	private int num;
	
	@NotEmpty(message = "이름은 필수 입력 사항입니다.")
	private String name;
	
	@Min(value = 10, message = "10살~100살로 작성해야 합니다.")
	@Max(value = 100, message = "10살~100살로 작성해야 합니다.")
	private String age;
	
	@NotNull(message = "관심지역은 1개 이상 선택해야 합니다.")
	private String area;
	
	@NotNull(message = "원하는 여행 타입을 선택해주세요.")
	private String style;
	
	@NotEmpty(message = "원하는 가격대를 선택하세요")
	private String price;
	
	public TravelBean() {
		
	}
	
	public TravelBean(int num, String name, String age, String area, String style, String price) {
		super();
		this.num = num;
		this.name = name;
		this.age = age;
		this.area = area;
		this.style = style;
		this.price = price;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	
}
