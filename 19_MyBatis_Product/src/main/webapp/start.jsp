<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
start.jsp<br>

<%
	String viewProduct = request.getContextPath()+"/list.pd";
	String viewMember = request.getContextPath()+"/memberList.mb";
	String viewOrder = request.getContextPath()+"/order.mall"; // OrderMallController
%>

<a href="<%=viewProduct%>">상품 목록 보기</a> <br><br>
<a href="<%=viewMember%>">회원 목록 보기</a> <br><br>
<a href="<%=viewOrder%>">나의 주문 내역</a> <br><br>