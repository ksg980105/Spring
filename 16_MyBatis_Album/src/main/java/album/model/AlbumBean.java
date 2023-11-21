package album.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class AlbumBean {
	private int num;
	
	@NotEmpty(message = "제목 누락")
	private String title;
	
	@Size(min = 3, max = 7, message = "3자리~7자리로 입력")
	private String singer;
	
	@Min(value = 1000, message = "최소 1000원이상 입력")
	private String price;
	private String day;
	
	public AlbumBean() {
		System.out.println("AlbumBean()");
	}
	
	public AlbumBean(int num, String title, String singer, String price, String day) {
		super();
		this.num = num;
		this.title = title;
		this.singer = singer;
		this.price = price;
		this.day = day;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		System.out.println("getTitle()");
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	
}
