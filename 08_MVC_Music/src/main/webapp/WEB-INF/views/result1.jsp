<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
result1.jsp<br>
<table border="1">
	<tr>
		<td>제목</td>
		<td>${requestScope.title}</td>
	</tr>
	<tr>
		<td>가수명</td>
		<td>${requestScope.singer}</td>
	</tr>
	<tr>
		<td>가격</td>
		<td>${requestScope.price}</td>
	</tr>
</table>
