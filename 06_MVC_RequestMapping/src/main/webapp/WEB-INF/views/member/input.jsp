<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
input.jsp<br>

id1 : ${id} <br>
id2 : <%=request.getParameter("id")%> <br>
id3 : ${requestScope.id} <br>
id4 : <%=request.getAttribute("id")%> <br>
id5 : ${param.id} <br>
