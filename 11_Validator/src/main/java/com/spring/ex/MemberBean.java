package com.spring.ex;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class MemberBean {
	
	@NotEmpty(message = "이름 입력 누락")
	private String name;
	
	//@NotEmpty(message = "아이디 입력 누락")
	//@Size(min = 3, max = 5, message = "3자리~5자리만 가능")
	//@Length(min = 3, max = 5, message = "3자리~5자리만 가능")
	@Pattern(regexp = "^[0-9]+$", message = "id는 숫자만 입력 가능합니다.")
	private String id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
