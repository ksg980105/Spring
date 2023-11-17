package com.spring.ex;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class BookBean {
	
//	@NotEmpty(message = "제목 입력 누락")
	private String title;
	
	//@Size(min = 5, message = "5글자 이상 입력하세요")
	@Min(value = 5, message = "5보다 큰 수를 넣어주세요")
	@Max(value = 10, message = "10보다 작은 수를 넣어주세요")
	private String author;
	
	@Length(max = 5, message = "5자리 이하로 입력하세요")
	@Pattern(regexp = "^[0-9]+$", message = "숫자로 입력하세요")
	private String price;
	
	@NotEmpty(message = "출판사 입력 누락")
	private String publisher;
	
	@NotBlank(message = "@NotBlank서점 1개 이상 선택해야합니다.")
	private String bookstore;
	
	@NotBlank(message = "@NotBlank 배송비 선택하세요")
	private String kind;
	
	public String getBookstore() {
		return bookstore;
	}
	public void setBookstore(String bookstore) {
		this.bookstore = bookstore;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
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
