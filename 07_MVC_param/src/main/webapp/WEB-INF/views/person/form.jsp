<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
form.jsp<br>

<form action="<%=request.getContextPath()%>/person/input5" method="post">
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
			<td>NAME</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>AGE</td>
			<td><input type="text" name="age"></td>
		</tr>
		<tr>
			<td colspan="4">
				<input type="submit" value="전송">
			</td>
		</tr>
	</table>
</form>