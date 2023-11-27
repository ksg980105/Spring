<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
start.jsp<br>

<%
	String viewProduct = request.getContextPath()+"/list.pd";
	String viewMember = request.getContextPath()+"/list.mb";
%>

<a href="<%=viewProduct%>">상품 목록 보기</a> <br><br>
<a href="<%=viewMember%>">회원 목록 보기</a>