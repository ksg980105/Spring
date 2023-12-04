<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>

<style type="text/css">
	.err{
		color: red;
		font-weight: bold;
		font-size: 9pt;
	}
</style>

<h1>회원 가입 화면</h1> <br>

<form:form commandName="memberBean" action="memberInsert.mb" method="post">
	아이디 <input type="text" name="id" value="${memberBean.id}">
	<form:errors cssClass="err" path="id"/>
	<br><br>
	
	이름 <input type="text" name="name" value="${memberBean.name}">
	<form:errors cssClass="err" path="name"/>
	<br><br>
	
	비번 <input type="text" name="password" value="${memberBean.password}">
	<form:errors cssClass="err" path="password"/>
	<br><br>
	
	<c:set var="genderList">남자,여자</c:set>
	성별
	<c:forEach var="gender" items="${genderList}">
		<input type="radio" name="gender" value="${gender}"
		<c:if test="${memberBean.gender eq gender}">checked</c:if>>${gender}
	</c:forEach>
	<form:errors cssClass="err" path="gender"/>
	<br><br>
	
	<c:set var="hobbyList">마라톤,영화감상,게임,공부</c:set>
	취미
	<c:forEach var="hobby" items="${hobbyList}">
		<input type="checkbox" name="hobby" value="${hobby}" 
		<c:if test="${fn:contains(memberBean.hobby, hobby)}">checked</c:if>>${hobby}
	</c:forEach>
	<form:errors cssClass="err" path="hobby"/>
	<br><br>
	
	주소1 <input type="text" name="address1" value="${memberBean.address1}">
	<form:errors cssClass="err" path="address1"/>
	<br><br>
	
	주소2 <input type="text" name="address2" value="${memberBean.address2}">
	<form:errors cssClass="err" path="address2"/>
	<br><br>
	
	적립포인트 <input type="text" name="mpoint" value="${memberBean.mpoint}">
	<form:errors cssClass="err" path="mpoint"/>
	<br><br>
	
	
	<input type="submit" value="추가하기">
	<br><br>

</form:form>