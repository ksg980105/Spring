<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
albumList.jsp<br>

<style>
	table{
		margin: auto;
	}
</style>

<script type="text/javascript">
	function insert(){
		location.href="insert.ab";
	}
</script>

<center>
	<form action="list.ab" method="get">
		<select name="whatColumn">
			<option value="all">전체검색
			<option value="title">노래제목
			<option value="singer">가수명
		</select>
		<input type="text" name="keyword">
		<input type="submit" value="검색">
	</form>
</center>

<table border="1">
	<tr>
		<td colspan="7" align="right">
			<input type="button" value="추가하기" onClick="insert()">
		</td>
	</tr>
	<tr>
		<td>번호</td>
		<td>제목</td>
		<td>가수</td>
		<td>가격</td>
		<td>발매일</td>
		<td>수정</td>
		<td>삭제</td>
	</tr>
	
	<c:forEach var="list" items="${albumLists}">
	<tr>
		<td>${list.num}</td>
		<td>
			<a href="detail.ab?num=${list.num}">${list.title}</a>
		</td>
		<td>${list.singer}</td>
		<td>${list.price}</td>
		<td>
			<fmt:parseDate var="day" value="${list.day}" pattern="yyyy-MM-dd"/>
			<fmt:formatDate value="${day}" pattern="yyyy-MM-dd"/>
		</td>
		<td>
			<a href="update.ab?num=${list.num}">수정</a>
		</td>
		<td>
			<a href="delete.ab?num=${list.num}">삭제</a>
		</td>
	</tr>
	</c:forEach>
</table>

<br>
<a href="insert.ab">등록하러 가기</a>