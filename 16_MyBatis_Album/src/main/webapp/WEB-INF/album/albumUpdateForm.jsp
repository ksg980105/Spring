<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
albumUpdateForm.jsp<br>

<style>
	.err{
		font-size: 9pt;
		color: red;
		font-weight: bold;
	}
</style>

<form:form commandName="albumBean" action="update.ab" method="post">
	<input type="hidden" name="num" value="${album.num}">
	<table border="1">
		<tr>
			<td>노래제목</td>
			<td>
				<input type="text" name="title" value="${album.title}">
				<form:errors cssClass="err" path="title"/>
			</td>
		</tr>
		<tr>
			<td>가수명</td>
			<td>
				<input type="text" name="singer" value="${album.singer}">
				<form:errors cssClass="err" path="singer"/>
			</td>
		</tr>
		<tr>
			<td>가격</td>
			<td>
				<input type="text" name="price" value="${album.price}">
				<form:errors cssClass="err" path="price"/>
			</td>
		</tr>
		<tr>
			<td>발매일</td>
			<td>
				<fmt:parseDate var="day" value="${album.day}" pattern="yyyy-MM-dd" /> 
				<input type="text" name="day" value="<fmt:formatDate value="${day}" pattern="yyyy-MM-dd"/>">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="수정하기">
			</td>
		</tr>
	</table>
</form:form>