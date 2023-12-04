<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
shopList.jsp<br>

<style type="text/css">
	td{
		text-align: center;
	}
</style>

<center>
<h2>주문 내역</h2>
<table border="1">
	<tr>
		<td	colspan="3">
			주문자 정보: ${loginInfo.name}(${loginInfo.id})
		</td>
	</tr>
	
	<tr>
		<th>주문 번호</th>
		<th>주문 일자</th>
		<th>상세 보기</th>
	</tr>
	<c:forEach var="orderBean" items="${lists}">
		<tr>
			<td>${orderBean.oid}</td>
			<td>${orderBean.orderdate}</td>
			<td><a href="orderDetail.mall?oid=${orderBean.oid}">상세 보기</a></td>
		</tr>
	</c:forEach>
</table>
</center>