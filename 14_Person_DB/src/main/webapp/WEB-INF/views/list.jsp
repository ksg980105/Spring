<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

list.jsp <br>
레코드 갯수 : ${fn:length(lists)}<br>
<table border="1">
   <tr>
      <td>번호</td>
      <td>아이디</td>
      <td>이름</td>
      <td>나이</td>
      <td>삭제</td>
      <td>수정</td>
   </tr>
	<c:forEach var="pb" items="${ lists }">
	   <tr>
	      <td>${pb.num}</td>
	      <td>${pb.name}</td>
	      <td>${pb.id}</td>
	      <td>${pb.age}</td>
	      <td><a href="delete?num=${pb.num}">삭제</a></td>
	      <td><a href="updateForm?num=${pb.num}">수정</a></td>
	   </tr>
	</c:forEach>
</table>
<br>
<a href="write">삽입</a>