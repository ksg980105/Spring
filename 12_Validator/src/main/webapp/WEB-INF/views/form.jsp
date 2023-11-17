<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
	
	구입 가능 서점<br>
	교보문고 <input type="checkbox" name="bookstore" value="교보문고" <c:if test="${bookBean.bookstore.contains('교보문고')}">checked</c:if>>
	알라딘 <input type="checkbox" name="bookstore" value="알라딘" <c:if test="${bookBean.bookstore.contains('알라딘')}">checked</c:if>>
	yes24 <input type="checkbox" name="bookstore" value="yes24" <c:if test="${bookBean.bookstore.contains('yes24')}">checked</c:if>>
	인터파크 <input type="checkbox" name="bookstore" value="인터파크" <c:if test="${fn:contains(bookBean.bookstore,'인터파크')}">checked</c:if>>
	<form:errors cssClass="err" path="bookstore"/>
	<br><br>
	
	배송비<br>
	<input type="radio" name="kind" value="유료" <c:if test="${bookBean.kind == ('유료')}">checked</c:if>>유료
	<input type="radio" name="kind" value="무료" <c:if test="${bookBean.kind == ('무료')}">checked</c:if>>무료
	<form:errors cssClass="err" path="kind"/>
	<br><br>
	
	<input type="submit" value="전송">
</form:form>