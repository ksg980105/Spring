<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>

<style>
	table{
		margin: auto;
	}
</style>

<h2 align="center">상품 상세 화면${productBean.num}</h2>

<table border="1" width="600" height="400">
	<tr>
		<td rowspan="7">
			<img src="<%=request.getContextPath()%>/resources/uploadFolder/${productBean.image}" width="150">
			<%= application.getContextPath()%>/resources/uploadFolder/ %>
		</td>
	</tr>
	<tr>
		<td>상품명</td>
		<td>${productBean.name}</td>
	</tr>
	<tr>
		<td>가격</td>
		<td>${productBean.price} 원</td>
	</tr>
	<tr>
		<td>재고 수량</td>
		<td>${productBean.stock}</td>
	</tr>
	<tr>
		<td>설명</td>
		<td>${productBean.contents}</td>
	</tr>
	<tr>
		<td>주문 수량</td>
		<td>
			<form action="add.mall" method="post">
				<input type="hidden" name="num" value="${productBean.num}">
				<input type="hidden" name="pageNumber" value="${pageNumber}">
				<input type="text" name="orderqty" value="1">
				<input type="submit" value="주문">
			</form>
		</td>
	</tr>
	<tr align="center">
		<td colspan="2">
			<a href="list.pd?pageNumber=${pageNumber}">상품 리스트</a>
		</td>
	</tr>
</table>