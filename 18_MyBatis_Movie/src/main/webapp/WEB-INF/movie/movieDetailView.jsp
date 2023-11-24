<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
movieDetailView.jsp<br>

<style>
	table{
		width: 400px;
		height: 400px;
		margin: auto;
	}
	th{
		width: 30%;
	}
</style>

<h2 align="center">영화 상세 화면</h2>

<table border="1">
	<tr>
		<th>번호</th>
		<td>${movieBean.num}</td>
	</tr>
	<tr>
		<th>영화제목</th>
		<td>${movieBean.title}</td>
	</tr>
	<tr>
		<th>제작국가</th>
		<td>${movieBean.nation}</td>
	</tr>
	<tr>
		<th>장르</th>
		<td>${movieBean.genre}</td>
	</tr>
	<tr>
		<th>등급</th>
		<td>${movieBean.grade}</td>
	</tr>
	<tr>
		<th>배우</th>
		<td>${movieBean.actor}</td>
	</tr>
	<tr align="center">
		<td colspan="2">
			<a href="list.mv?pageNumber=${pageNumber}">영화 리스트 화면으로 돌아감</a>
		</td>
	</tr>
</table>