package com.spring.ex;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class MemberBean {
	
	@NotEmpty(message = "�̸� �Է� ����")
	private String name;
	
	//@NotEmpty(message = "���̵� �Է� ����")
	//@Size(min = 3, max = 5, message = "3�ڸ�~5�ڸ��� ����")
	//@Length(min = 3, max = 5, message = "3�ڸ�~5�ڸ��� ����")
	@Pattern(regexp = "^[0-9]+$", message = "id�� ���ڸ� �Է� �����մϴ�.")
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
