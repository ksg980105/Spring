<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
			<input type="text" name="order">
			<input type="button" value="주문">
		</td>
	</tr>
	<tr align="center">
		<td colspan="2">
			<a href="list.pd?pageNumber=${pageNumber}">상품 리스트</a>
		</td>
	</tr>
</table>