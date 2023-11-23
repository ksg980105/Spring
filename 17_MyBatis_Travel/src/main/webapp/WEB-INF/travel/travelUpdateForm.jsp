<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
travelUpdateForm.jsp<br>

<style>
	table{
		margin: auto;
		width: 700px;
		height: 200px;
	}
	.err{
		font-size: 9pt;
		color: red;
		font-weight: bold;
	}
</style>

<h2 align="center">상품 수정 화면</h2>

<form:form commandName="travelBean" action="update.tv" method="post">
	<input type="hidden" name="num" value="${travelBean.num}">
	<input type="hidden" name="pageNumber" value="${pageNumber}">
	<table border="1">
		<tr>
			<td>이름</td>
			<td>
				<input type="text" name="name" value="${travelBean.name}">
				<form:errors cssClass="err" path="name"/>
			</td>
		</tr>
		<tr>
			<td>나이</td>
			<td>
				<input type="text" name="age" value="${travelBean.age}">
				<form:errors cssClass="err" path="age"/>
			</td>
		</tr>
		<tr>
			<td>지역</td>
			<%
				String[] tarea = {"유럽","동남아","일본","중국"};
			%>
			<td>
				<c:forEach var="area" items="<%=tarea%>">
				<input type="checkbox" name="area" value="${area}" <c:if test="${travelBean.area.contains(area)}">checked</c:if>>${area}
				</c:forEach>
				<form:errors cssClass="err" path="area"/>
			</td>
		</tr>
		<tr>
			<td>여행타입</td>
			<%
				String[] travelstyle = {"패키지", "크루즈", "자유여행", "골프여행"};
			%>
			<td>
				<c:forEach var="type" items="<%= travelstyle %>">
					<input type="radio" name="style" value="${type}" <c:if test="${travelBean.style == type}">checked</c:if>>${type}
				</c:forEach>
				<form:errors cssClass="err" path="style"/>
			</td>
		</tr>
		<tr>
			<td>가격</td>
			<%
				String[] tprice = {"100~200","200~300","300~400","400~500"};
			%>
			<td>
				<select name="price">
					<option value="">선택하세요</option>
					<c:forEach var="price" items="<%=tprice%>">
						<option value="${price}" <c:if test="${travelBean.price == price}">selected</c:if>>${price}</option>
					</c:forEach>
				</select>
				<form:errors cssClass="err" path="price"/>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="수정하기">
				<a href="list.tv?pageNumber=${pageNumber}">목록</a>
			</td>
		</tr>
	</table>
</form:form>
