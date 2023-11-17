<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<style>
	.err{
		font-size: 9pt;
		color: red;
		font-weight: bold;
	}
</style>

insertForm.jsp <br>

<h2> 마트 상품 구매 내역 </h2>
<form:form commandName="martBean" METHOD="post" ACTION="insertProc">

	 <span>아이디 :</span> <INPUT TYPE="text" NAME="id" value="${martBean.id}">
	 <form:errors cssClass="err" path="id"/>
	 <br>
	 <span>비번 :</span> <INPUT TYPE="text" NAME="pw" value="${martBean.pw}">
	 <form:errors cssClass="err" path="pw"/>
	 <br>
	  <p> 
 
 
	<span>구매상품:</span>
		<input type="checkbox" name="product" value="식품" <c:if test="${fn:contains(martBean.product,'식품')}">checked</c:if>>식품
		<input type="checkbox" name="product" value="의류" <c:if test="${fn:contains(martBean.product,'의류')}">checked</c:if>>의류
		<input type="checkbox" name="product" value="도서" <c:if test="${fn:contains(martBean.product,'도서')}">checked</c:if>>도서
		<input type="checkbox" name="product" value="가구" <c:if test="${fn:contains(martBean.product,'가구')}">checked</c:if>>가구
		<form:errors cssClass="err" path="product"/>
	<p>
	
	<span>배송시간 :</span> 
	 	<SELECT NAME="time">
	 		<OPTION VALUE="">선택</OPTION>
			<OPTION  VALUE="9시~11시" <c:if test="${martBean.time == ('9시~11시')}">selected</c:if>>9시~11시</OPTION>
			<OPTION VALUE="11시~1시" <c:if test="${martBean.time == ('11시~1시')}">selected</c:if>>11시~1시</OPTION>
			<OPTION VALUE="1시~5시" <c:if test="${martBean.time == ('1시~5시')}">selected</c:if>>1시~5시</OPTION>
			<OPTION VALUE="5시~9시" <c:if test="${martBean.time == ('5시~9시')}">selected</c:if>>5시~9시</OPTION>
		</SELECT>
		<form:errors cssClass="err" path="time"/>
	<p>
	
	<INPUT TYPE="submit" value="보내기" >

</form:form>