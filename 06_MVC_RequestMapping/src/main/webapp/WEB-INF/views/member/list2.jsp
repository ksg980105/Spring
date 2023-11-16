<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
member/list2.jsp<br>

name1 : ${name}<br>
name2 : ${requestScope.name}<br>
name3 : ${param.name}<br>
name4 : <%=request.getAttribute("name") %><br>
name5 : <%=request.getParameter("name") %><br>

pw1 : ${pw}<br>
pw2 : ${requestScope.pw}<br>
pw3 : <%=request.getAttribute("pw") %><br>