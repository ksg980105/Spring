<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
albumInsertForm.jsp<br>

<style>
	.err{
		font-size: 9pt;
		color: red;
		font-weight: bold;
	}
</style>

<form:form commandName="albumBean" action="insert.ab" method="post">
	<h1>앨범 추가</h1>
	<p>
		<label>노래제목</label>
		<input type="text" name="title" value="${albumBean.title}">
		<form:errors cssClass="err" path="title"/>
	</p>
	
	<p>
		<label>가수명</label>
		<input type="text" name="singer" value="${albumBean.singer}">
		<form:errors cssClass="err" path="singer"/>
	</p>
	<p>
		<label>가격</label>
		<input type="text" name="price" value="${albumBean.price}">
		<form:errors cssClass="err" path="price"/>
	</p>
	<p>
		<label>발매일</label>
		<input type="text" name="day" value="2023-1-1">
	</p>
	
	<p>
		<input type="submit" value="추가하기">
	</p>
</form:form>