package com.spring.ex;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class MartBean {
	
	@NotEmpty(message = "id입력 누락")
	private String id;
	
	@NotEmpty(message = "pw 입력 누락")
	@Length(min = 3, max = 5, message = "3~5자리로 입력")
	private String pw;
	
	@NotNull(message = "product 선택 누락")
	private String product;
	
	@NotEmpty(message = "time선택 누락")
	private String time;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
}
