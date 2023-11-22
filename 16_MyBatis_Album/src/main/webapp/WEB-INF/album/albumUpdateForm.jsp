<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
albumUpdateForm.jsp
<br>

<style>
.err {
	font-size: 9pt;
	color: red;
	font-weight: bold;
}
</style>

<form:form action="update.ab" method="post" commandName="albumBean">
	<input type="hidden" name="num" value="${albumBean.num}">
	<input type="hidden" name="pageNumber" value="${pageNumber}">
	<p>
		<label>노래제목</label> <input type="text" name="title" value="${albumBean.title}">
		<form:errors cssClass="err" path="title" />
	</p>
	<p>
		<label>가수명</label> <input type="text" name="singer" value="${albumBean.singer}">
		<form:errors cssClass="err" path="singer" />
	</p>

	<p>
		<label>가격</label> <input type="text" name="price" value="${albumBean.price}">
		<form:errors cssClass="err" path="price" />
	</p>

	<p>
		<label>발매일</label>
		<fmt:parseDate var="day" value="${albumBean.day}" pattern="yyyy-MM-dd" />
		<input type="text" name="day" value="<fmt:formatDate value="${day}" pattern="yyyy-MM-dd"/>">
	</p>

	<p>
		<input type="submit" value="수정하기"> 
		<a href="list.ab?pageNumber=${pageNumber}">목록</a>
	</p>
</form:form>