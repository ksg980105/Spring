<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>

<style>
	.err{
		font-size: 9pt;
		color: red;
		font-weight: bold;
	}
</style>

<form:form commandName="travelBean" action="insert.tv" method="post">
	<h1>여행 정보 등록 화면</h1>
	<p>
		<label>이름</label>
		<input type="text" name="name" value="${travelBean.name}">
		<form:errors cssClass="err" path="name"/>
	</p>
	
	<p>
		<label>나이</label>
		<input type="text" name="age" value="${travelBean.age}">
		<form:errors cssClass="err" path="age"/>
	</p>
	<p>
		<label>관심지역</label>
		<input type="checkbox" name="area" value="유럽" <c:if test="${travelBean.area.contains('유럽')}">checked</c:if>>유럽
		<input type="checkbox" name="area" value="동남아" <c:if test="${travelBean.area.contains('동남아')}">checked</c:if>>동남아
		<input type="checkbox" name="area" value="일본" <c:if test="${travelBean.area.contains('일본')}">checked</c:if>>일본
		<input type="checkbox" name="area" value="중국" <c:if test="${travelBean.area.contains('중국')}">checked</c:if>>중국
		<form:errors cssClass="err" path="area"/>
	</p>
	<p>
	<label>여행 타입</label>
		<%
			String[] travelstyle = {"패키지", "크루즈", "자유여행", "골프여행"};
		%>
		<c:forEach var="type" items="<%= travelstyle %>">
			<input type="radio" name="style" value="${type}" <c:if test="${travelBean.style == type}">checked</c:if>>${type}
		</c:forEach>
		<form:errors cssClass="err" path="style"/>
	</p>

	<p>
		<label>가격</label>
		<select name="price">
			<option value="">선택하세요</option>
			<option value="100~200" <c:if test="${travelBean.price == ('100~200')}">selected</c:if>>100~200</option>
			<option value="200~300" <c:if test="${travelBean.price == ('200~300')}">selected</c:if>>200~300</option>
			<option value="300~400" <c:if test="${travelBean.price == ('300~400')}">selected</c:if>>300~400</option>
			<option value="400~500" <c:if test="${travelBean.price == ('400~500')}">selected</c:if>>400~500</option>
		</select>
		<form:errors cssClass="err" path="price"/>
	</p>
	
	<p>
		<input type="submit" value="추가하기">
	</p>
</form:form>