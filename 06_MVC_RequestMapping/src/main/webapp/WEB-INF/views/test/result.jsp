<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
test/result.jsp<br>

id1 : ${rid}<br>
id2 : ${requestScope.rid}<br>
id3 : <%=request.getAttribute("rid") %><br>
id4 : <%=request.getParameter("id") %><br>

pw1 : ${pw}<br>
pw2 : ${requestScope.rpw}<br>
pw3 : <%=request.getAttribute("rpw")%><br>