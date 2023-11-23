<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
travelDetailView.jsp<br>

<style>
	table{
		margin: auto;
	}
	th{
		text-align: center;
		width: 30%;
	}
</style>

<h2 align="center">여행 상세 화면</h2>

<table border="1" width="400" height="400">
	<tr>
		<th>번호</th>
		<td>${travelBean.num}</td>
	</tr>
	<tr>
		<th>이름</th>
		<td>${travelBean.name}</td>
	</tr>
	<tr>
		<th>관심지역</th>
		<td>${travelBean.area}</td>
	</tr>
	<tr>
		<th>여행타입</th>
		<td>${travelBean.style}</td>
	</tr>
	<tr>
		<th>가격대</th>
		<td>${travelBean.price}</td>
	</tr>
	<tr>
		<th colspan="2">
			<a href="list.tv?pageNumber=${pageNumber}">여행 리스트 화면으로 돌아감</a>
		</th>
	</tr>
</table>