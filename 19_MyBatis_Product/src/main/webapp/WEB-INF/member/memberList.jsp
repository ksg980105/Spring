<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../common/common.jsp" %>

<style>
	table{
		margin: auto;
		width: 700px;
		text-align: center;
	}
</style>

<script type="text/javascript">
	function goInsert(){
		location.href="memberInsert.mb";
	}
	
	function goUpdate(id, pageNumber){
		location.href="update.mb?id="+id+"&pageNumber="+pageNumber;
	}
</script>

<h2 align="center">회원 리스트 화면</h2>

<center>
	<form action="memberList.mb" method="get">
		<select name="whatColumn">
			<option value="all">전체검색
			<option value="name">이름
			<option value="gender">성별
			<option value="hobby">취미
		</select>
		<input type="text" name="keyword">
		<input type="submit" value="검색">
	</form>
</center>

<table border="1">
	<tr align="right">
		<td colspan="9">
			<input type="button" value="추가하기" onClick="goInsert()">
		</td>
	</tr>
	<tr>
		<th>ID</th>
		<th>이름</th>
		<th>비번</th>
		<th>성별</th>
		<th>취미</th>
		<th>주소</th>
		<th>포인트</th>
		<th>삭제</th>
		<th>수정</th>
	</tr>
	
	<c:if test = "${empty memberLists}">
   	  <tr>
   	  	<td colspan="9" align="center">
   	  		검색된 항목이 없습니다.
   	  	</td>
   	  </tr>
   </c:if>
   
   <c:if test="${!empty memberLists}">
	<c:forEach var="memberBean" items="${memberLists}">
		<tr>
			<td>${memberBean.id}</td>
			<td>
				<a href="detail.mb?id=${memberBean.id}&pageNumber=${pageInfo.pageNumber}">${memberBean.name}</a>
			</td>
			<td>${memberBean.password}</td>
			<td>${memberBean.gender}</td>
			<td>${memberBean.hobby}</td>
			<td>${memberBean.address1} ${memberBean.address2}</td>
			<td>${memberBean.mpoint}</td>
			<td>
				<a href="delete.mb?id=${memberBean.id}&pageNumber=${pageInfo.pageNumber}">삭제</a>
			</td>
			<td>
				<input type="button" value="수정" onClick="goUpdate('${memberBean.id}', '${pageInfo.pageNumber}')">
			</td>
		</tr>
	</c:forEach>
	</c:if>
</table>

<center>
	${pageInfo.pagingHtml}
</center>