<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>

<style type="text/css">
	th{
		width: 25%;
	}
	td{
		padding-left: 10px;
	}
</style>

<center>
	<h2>회원 상세 화면</h2>
	<table border = "1" width="500" height="400">
		<tr>
			<th>아이디</th>
			<td>${memberBean.id}</td>
		</tr>
		
		<tr>
			<th>이름</th>
			<td>${memberBean.name}</td>
		</tr>
		
		<tr>
			<th>성별</th>
			<td>${memberBean.gender}</td>
		</tr>
		
		<tr>
			<th>취미</th>
			<td>${memberBean.hobby}</td>
		</tr>
		
		<tr>
			<th>주소</th>
			<td>${memberBean.address1} ${memberBean.address2}</td>
		</tr>
		
		<tr>
			<th>적립포인트</th>
			<td>${memberBean.mpoint}</td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<a href="memberList.mb?pageNumber=${param.pageNumber}">회원 목록 리스트</a>
			</td>
		</tr>
	</table>
</center>