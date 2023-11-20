<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
updateForm.jsp<br>

<style>
	.err{
		font-size: 9pt;
		color: red;
		font-weight: bold;
	}
</style>

<form:form commandName="fdto" action="update" method="post">
	<input type="hidden" name="num" value="${fdto.num}">
	<input type="hidden" name="id" value="${fdto.id}">
	<table border="1" width="700">
		<tr>
			<td>번호</td>
			<td>${fdto.num}</td>
		</tr>
		<tr>
			<td>아이디</td>
			<td>${fdto.id}</td>
		</tr>
		<tr>
			<td>비번</td>
			<td>
				<input type="text" name="pw" value="${fdto.pw}">
				<form:errors cssClass="err" path="pw"/>
			</td>
		</tr>
		<tr>
			<td>우승 예상국가</td>
			<td>
				<input type="radio" name="win" value="한국" <c:if test="${fdto.win == '한국'}">checked</c:if>>한국
				<input type="radio" name="win" value="미국" <c:if test="${fdto.win == '미국'}">checked</c:if>>미국
				<input type="radio" name="win" value="독일" <c:if test="${fdto.win == '독일'}">checked</c:if>>독일
				<input type="radio" name="win" value="스페인" <c:if test="${fdto.win == '스페인'}">checked</c:if>>스페인
				<form:errors cssClass="err" path="win"/>
			</td>
		</tr>
		<tr>
			<td>16강 예상국가</td>
			<td>
				<input type="checkbox" name="round16" value="한국" <c:if test="${fn:contains(fdto.round16,'한국')}">checked</c:if>>한국
				<input type="checkbox" name="round16" value="멕시코" <c:if test="${fn:contains(fdto.round16,'멕시코')}">checked</c:if>>멕시코
				<input type="checkbox" name="round16" value="브라질" <c:if test="${fn:contains(fdto.round16,'브라질')}">checked</c:if>>브라질
				<input type="checkbox" name="round16" value="스위스" <c:if test="${fn:contains(fdto.round16,'스위스')}">checked</c:if>>스위스
				<input type="checkbox" name="round16" value="잉글랜드" <c:if test="${fn:contains(fdto.round16,'잉글랜드')}">checked</c:if>>잉글랜드
				<input type="checkbox" name="round16" value="스페인" <c:if test="${fn:contains(fdto.round16,'스페인')}">checked</c:if>>스페인
				<form:errors cssClass="err" path="round16"/>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="수정"> &nbsp;&nbsp;
				<a href="list">목록보기</a>
			</td>
		</tr>
	</table>
</form:form>