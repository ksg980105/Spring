<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<style>
	.err{
		font-size: 9pt;
		color: red;
		font-weight: bold;
	}
</style>

<form:form commandName="memberBean" action="memberForm" method="post">
	이름 <input type="text" name="name">
	<form:errors cssClass="err" path="name" value="${memberBean.name}"/>
	<br><br>
	
	아이디 <input type="text" name="id">
	<form:errors cssClass="err" path="id" value="${memberBean.id}"/>
	<br><br>
	<input type="submit" value="전송"><br><br>
</form:form>