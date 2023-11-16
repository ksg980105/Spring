<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
result2.jsp<br>

name : ${param.name}<br>
name2 : <%=request.getParameter("name")%><br>

name : ${pb.name}<br>
age : ${pb.age}<br>
addr : ${pb.addr}<br>

${pb['age']}

${requestScope.pb.age}

<%
	PersonBean pb = (PersonBean)request.getAttribute("pb");
%>

<%=pb.getName()%>

<%=((PersonBean)request.getAttribute("pb")).getName()%>