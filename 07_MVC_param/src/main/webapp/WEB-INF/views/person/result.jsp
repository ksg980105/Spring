<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
person/result.jsp<br>

name : <%=request.getParameter("name")%><br>
age : <%=request.getParameter("age")%><br>

name : ${param.name}<br>
age : ${param.age}<br>

name : ${name}<br>
age : ${age}<br>

name : <%=request.getAttribute("name")%>