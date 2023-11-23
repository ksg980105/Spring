<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
travelList.jsp<br>

<style type="text/css">
   table{
      margin: auto;
      width: 60%;
   }
   th{
      background: cyan;
   }
   td{
      text-align: center;
   }
</style>
<script type="text/javascript">
   function insert(){
      location.href="insert.tv";
   }
   
   function goUpdate(num, pageNumber){
	   location.href="update.tv?num="+num+"&pageNumber="+pageNumber;
   }
</script>

<center>
<h2>상품 리스트</h2>
	<form action="list.tv" method="get">
		<select name="whatColumn">
			<option value="all">전체검색
			<option value="area">지역
			<option value="style">여행타입
		</select>
		<input type="text" name="keyword">
		<input type="submit" value="검색">
	</form>
</center>


<table border="1">
   <tr>
      <td colspan="8" style="text-align: right;"><input type="button" value="등록" onclick="insert()"></td>
   </tr>
   <tr>
      <th>번호</th>
      <th>이름</th>
      <th>나이</th>
      <th>관심 지역</th>
      <th>여행타입</th>
      <th>가격</th>
      <th>수정</th>
      <th>삭제</th>
   </tr>
   
   <c:if test = "${empty lists}">
   	  <tr>
   	  	<td colspan="8" align="center">
   	  		검색된 항목이 없습니다.
   	  	</td>
   	  </tr>
   </c:if>
   
   <c:if test = "${!empty lists}">
	   <c:forEach var="tb" items="${lists}">
	      <tr>
	         <td>${tb.num}</td>
	         <td>
	         	<a href="detail.tv?num=${tb.num}&pageNumber=${pageInfo.pageNumber}">${tb.name}</a>
	         </td>
	         <td>${tb.age}</td>
	         <td>${tb.area}</td>
	         <td>${tb.style}</td>
	         <td>${tb.price}</td>
	         <td>
	         	<%-- <a href="update.tv?num=${tb.num}&pageNumber=${pageInfo.pageNumber}">수정</a> --%>
	         	<input type="button" value="수정" onClick="goUpdate(${tb.num},${pageInfo.pageNumber})">
	         </td>
	         <td><a href="delete.tv?num=${tb.num}&pageNumber=${pageInfo.pageNumber}">삭제</a></td>
	      </tr>
	   </c:forEach>
   </c:if>
</table>

<center>
	${pageInfo.pagingHtml}
</center>
