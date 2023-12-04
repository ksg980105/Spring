<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>

<style type="text/css">
	td{
		text-align: center;
	}
</style>

<a href="">로그아웃2</a> mallList.jsp<br>

<center>
	<h1>주문 내역</h1>
	<table border="1">
		<tr>
			<td colspan="5" align = "center">
				주문자 정보 : ${loginInfo.id}
			</td>
		</tr>
		
		<tr>
			<th>상품 번호</th>
			<th>상품명</th>
			<th>주문 수량</th>
			<th>단가</th>
			<th>금액</th>
		</tr>

		<c:forEach var="shopInfo" items="${shopLists}">
			<tr>
				<td>${shopInfo.pnum}</td>
				<td>${shopInfo.pname}</td>
				<td>${shopInfo.qty}</td>
				<td><fmt:formatNumber value="${shopInfo.price}" pattern="###,###원"/></td>
				<td><fmt:formatNumber value="${shopInfo.amount}" pattern="###,###"/>원</td>
				<c:set var="sum" value="${sum+shopInfo.amount}"/>
			</tr>
		</c:forEach>
		
		<tr>
			<td colspan="3" align = "center">
				<a href="calculate.mall">결제하기</a>
				<a href="list.pd">추가 주문</a>
			</td>
			<td colspan="2">
				총 금액: <fmt:formatNumber value="${sum}" pattern="###,###"/>원
			</td>
		</tr>
	</table>
</center>