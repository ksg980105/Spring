<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>

<style>
	table{
		margin: auto;
		width: 500px;
		height: 200px;
		text-align: center;
	}
</style>

<script type="text/javascript">
	function goInsert(){
		location.href="insert.pd";
	}
</script>

<h2 align="center">상품 리스트 화면</h2>
<h3 align="center">productList.jsp</h3>

<center>
	<form action="list.pd" method="get">
		<select name="whatColumn">
			<option value="all">전체검색
			<option value="name">상품명
			<option value="contents">설명
		</select>
		<input type="text" name="keyword">
		<input type="submit" value="검색">
	</form>
</center>

<table border="1">
	<tr align="right">
		<td colspan="6">
			<input type="button" value="추가하기" onClick="goInsert()">
		</td>
	</tr>
	<tr>
		<th>상품번호</th>
		<th>상품명</th>
		<th>설명</th>
		<th>가격</th>
		<th>삭제</th>
		<th>수정</th>
	</tr>
	
	<c:if test = "${empty lists}">
   	  <tr>
   	  	<td colspan="6" align="center">
   	  		검색된 항목이 없습니다.
   	  	</td>
   	  </tr>
   </c:if>
   
   <c:if test="${!empty lists}">
	<c:forEach var="list" items="${lists}">
		<tr>
			<td>${list.num}</td>
			<td>
				<a href="detail.pd?num=${list.num}&pageNumber=${pageInfo.pageNumber}">${list.name}</a>
			</td>
			<td>${list.contents}</td>
			<td>${list.price}</td>
			<td>
				<a href="delete.pd?num=${list.num}">삭제</a>
			</td>
			<td>
				<input type="button" value="수정" onClick="goUpdate()">
			</td>
		</tr>
	</c:forEach>
	</c:if>
</table>

<center>
	${pageInfo.pagingHtml}
</center>