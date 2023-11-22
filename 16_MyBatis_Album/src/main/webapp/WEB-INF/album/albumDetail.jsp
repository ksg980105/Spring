<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

albumDetail.jsp<br>

<table border="1" width="300" height="400">
	<tr>
		<td>제목</td>
		<td>${album.title}</td>
	</tr>
	
	<tr>
		<td>가수명</td>
		<td>${album.singer}</td>
	</tr>
	
	<tr>
		<td>가격</td>
		<td>${album.price}</td>
	</tr>
	
	<tr>
		<td>발매일</td>
		<td>
			<fmt:parseDate var="day" value="${album.day}" pattern="yyyy-MM-dd"/>
			<fmt:formatDate value="${day}" pattern="yyyy-MM-dd"/>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<a href="list.ab?pageNumber=${pageNumber}">목록보기</a>
		</td>
	</tr>
</table>