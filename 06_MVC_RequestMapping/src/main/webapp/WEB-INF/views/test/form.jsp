<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
test/form.jsp<br>

<form action="<%=request.getContextPath()%>test/insert" method="get">
	<table border="1">
		<tr>
			<td>ID</td>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<td>PW</td>
			<td><input type="text" name="pw"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="����">
			</td>
		</tr>
	</table>
</form>