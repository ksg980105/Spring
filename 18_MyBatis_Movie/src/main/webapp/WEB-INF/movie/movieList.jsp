<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
movieList.jsp<br>

<style>
	table{
		margin: auto;
		width: 700px;
	}
</style>

<script type="text/javascript">
	function goInsert(){
		location.href="insert.mv";
	}
</script>

<h2 align="center">영화 정보 리스트 화면</h2>

<center>
	<form action="list.mv" method="get">
		<select name="whatColumn">
			<option value="all">전체검색
			<option value="genre">장르
			<option value="grade">등급
			<option value="actor">배우
		</select>
		<input type="text" name="keyword">
		<input type="submit" value="검색">
	</form>
</center>

<table border="1">
	<tr>
		<td colspan="9" align="right">
			<input type="button" value="추가하기" onClick="goInsert()">
		</td>
	</tr>
	<tr>
		<td>번호</td>
		<td>제목</td>
		<td>대륙</td>
		<td>제작국가</td>
		<td>장르</td>
		<td>등급</td>
		<td>출연배우</td>
		<td>삭제</td>
		<td>수정</td>
	</tr>
	
	<c:if test = "${empty lists}">
   	  <tr>
   	  	<td colspan="9" align="center">
   	  		검색된 항목이 없습니다.
   	  	</td>
   	  </tr>
   </c:if>
   
    <c:if test = "${!empty lists}">
		<c:forEach var="list" items="${lists}">
		<tr>
			<td>${list.num}</td>
			<td>
				<a href="detail.mv?num=${list.num}&pageNumber=${pageInfo.pageNumber}">${list.title}</a>
			</td>
			<td>${list.continent}</td>
			<td>${list.nation}</td>
			<td>${list.genre}</td>
			<td>${list.grade}</td>
			<td>${list.actor}</td>
			<td>
				<a href="delete.mv?num=${list.num}&pageNumber=${pageInfo.pageNumber}">삭제</a>
			</td>
			<td>
				<a href="update.mv?num=${list.num}&pageNumber=${pageInfo.pageNumber}">수정</a>
			</td>
		</tr>
		</c:forEach>
	</c:if>
</table>

<center>
	${pageInfo.pagingHtml}
</center>