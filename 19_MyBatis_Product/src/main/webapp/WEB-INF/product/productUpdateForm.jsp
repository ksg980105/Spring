<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>

<style>
.err {
	font-size: 9pt;
	color: red;
	font-weight: bold;
}
</style>

<center>
<h2>상품 수정 화면</h2>
<form:form commandName="productBean" action="update.pd" method="post" enctype="multipart/form-data">
	<input type="hidden" name="num" value="${productBean.num}">
	<input type="hidden" name="pageNumber" value="${param.pageNumber}">
	
	<table border="1" width="600">
		<tr>
			<th>*상품명 </th>
			<td>
				<input type="text" name="name" value="${productBean.name}">
				<form:errors cssClass="err" path="name" />
			</td>
		</tr>
		
		<tr>
			<th>제조 회사 </th>
			<td>
				<input type="text" name="company" value="${productBean.company}">
			</td>
		</tr>
		
		<tr>
			<th>*가격</th>
			<td>
				<input type="text" name="price" value="${productBean.price}">
				<form:errors cssClass="err" path="price" />
			</td>
		</tr>
		
		<tr>
			<th>재고 수량</th>
			<td>
				<input type="text" name="stock" value="${productBean.stock}">
			</td>
		</tr>
		
		<tr>
			<th>적립 포인트</th>
			<td>
				<input type="text" name="point" value="${productBean.point}">
			</td>
		</tr>
		
		<tr>
			<th>*설명</th>
			<td>
				<input type="text" name="contents" value="${productBean.contents}">
				<form:errors cssClass="err" path="contents" />
			</td>
		</tr>
		
		<tr>
			<th>*상품 이미지</th>
			<td>
				<img src="<%=request.getContextPath()%>/resources/uploadFolder/${productBean.image}" width="150">
				<input type="file" name="upload" value="${productBean.image}">
				<input type="hidden" name="upload2" value="${productBean.image}">
				<form:errors cssClass="err" path="image" />
			</td>
		</tr>
		
		<tr>
			<td colspan="2" align="center"><input type="submit" value="수정하기"></td>
		</tr>
	</table>
</form:form>
</center>