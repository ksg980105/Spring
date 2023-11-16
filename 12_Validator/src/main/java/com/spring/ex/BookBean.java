package com.spring.ex;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class BookBean {
	
//	@NotEmpty(message = "���� �Է� ����")
	private String title;
	
	//@Size(min = 5, message = "5���� �̻� �Է��ϼ���")
	@Min(value = 5, message = "5���� ū ���� �־��ּ���")
	@Max(value = 10, message = "10���� ���� ���� �־��ּ���")
	private String author;
	
	@Length(max = 5, message = "5�ڸ� ���Ϸ� �Է��ϼ���")
	@Pattern(regexp = "^[0-9]+$", message = "���ڷ� �Է��ϼ���")
	private String price;
	
	@NotEmpty(message = "���ǻ� �Է� ����")
	private String publisher;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	
}
