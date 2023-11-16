<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
redirect/result.jsp<br>

name1 : ${param.name}<br>
name2 : <%=request.getParameter("name")%>
name3 : ${requestScope.name}<br>
name4 : <%=request.getAttribute("name")%><br>
name5 : ${name2}<br>
name6 : ${map1.mname}<br>

age1 : ${map1.mage}