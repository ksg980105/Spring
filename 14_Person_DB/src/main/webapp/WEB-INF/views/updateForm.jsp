<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form action="update" method="post">
	<input type="hidden" name="num" value="${dto.num}">
	<table border="1" width="500">
		<tr>
			<td>아이디</td>
			<td>
				<input type="text" name="id" value = "${dto.id}">
			</td>
		</tr>
		
		<tr>
			<td>이름</td>
			<td>
				<input type="text" name="name" value = "${dto.name}">
			</td>
		</tr>
		
		<tr>
			<td>나이</td>
			<td>
				<input type="text" name="age" value = "${dto.age}">
			</td>
		</tr>
		
		<tr>
			<td colspan="2">
				<input type="submit" value="수정">
			</td>
		</tr>
	</table>
</form>