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
form.jsp<br>

<form:form commandName="bookBean" action="bookForm" method="post">
	제목 <input type="text" name="title" value="${bookBean.title}"> 
	<form:errors cssClass="err" path="title"/>
	<br><br>
	
	저자 <input type="text" name="author" value="${bookBean.author}"> 
	<form:errors cssClass="err" path="author"/>
	<br><br>
	
	가격 <input type="text" name="price" value="${bookBean.price}">
	<form:errors cssClass="err" path="price"/>
	<br><br>
	
	출판사 <input type="text" name="publisher" value="${bookBean.publisher}"> 
	<form:errors cssClass="err" path="publisher"/>
	<br><br>
	
	<input type="submit" value="전송">
</form:form>