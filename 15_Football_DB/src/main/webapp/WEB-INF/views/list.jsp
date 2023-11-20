<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

list.jsp<br>

<table border="1">
	<tr>
		<td>번호</td>
		<td>아이디</td>
		<td>비번</td>
		<td>우승 예상국가</td>
		<td>16강 예상국가</td>
		<td>삭제</td>
		<td>수정</td>
	</tr>
	
	<c:forEach var="list" items="${list}">
	<tr>
		<td>${list.num}</td>
		<td>${list.id}</td>
		<td>${list.pw}</td>
		<td>${list.win}</td>
		<td>${list.round16}</td>
		<td>
			<a href="delete?num=${list.num}">삭제</a>
		</td>
		<td>
			<a href="update?num=${list.num}">수정</a>
		</td>
	</tr>
	</c:forEach>
</table>
<br><br>

<a href="write">삽입</a>