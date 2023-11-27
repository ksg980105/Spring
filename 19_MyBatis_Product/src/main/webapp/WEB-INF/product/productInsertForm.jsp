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

<form:form commandName="productBean" action="insert.pd" method="post" enctype="multipart/form-data">
	<h2>상품 추가 화면</h2>
	
	<p>
		<label>*상품명 </label>
		<input type="text" name="name" value="${productBean.name}">
		<form:errors cssClass="err" path="name" />
	</p>
	
	<p>
		<label>제조 회사 </label>
		<input type="text" name="company" value="${productBean.company}">
	</p>
	
	<p>
		<label>*가격 </label>
		<input type="text" name="price" value="${productBean.price}">
		<form:errors cssClass="err" path="price" />
	</p>
	
	<p>
		<label>재고 수량 </label>
		<input type="text" name="stock" value="${productBean.stock}">
	</p>
	
	<p>
		<label>적립 포인트 </label>
		<input type="text" name="point" value="${productBean.point}">
	</p>
	
	<p>
		<label>*설명 </label>
		<input type="text" name="contents" value="${productBean.contents}">
		<form:errors cssClass="err" path="contents" />
	</p>
	
	<p>
		<label>*상품 이미지 </label>
		<input type="file" name="upload" value="${productBean.image}">
		<form:errors cssClass="err" path="image" />
	</p>
	
	<p>
		<label>입고 일자 </label>
		<input type="date" name="inputdate" value="${productBean.inputdate}">
	</p>
	
	<input type="submit" value="추가하기">
</form:form>