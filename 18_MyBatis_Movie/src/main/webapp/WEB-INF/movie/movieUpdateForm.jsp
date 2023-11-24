<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
movieUpdateForm
<%@include file = "./../common/common.jsp" %>
<style>
	.err{
		font-size: 9pt;
		color: red;
	}
</style>
<script type="text/javascript">
	var f_selbox = new Array('아시아','아프리카','유럽','아메리카','오세아니아');
 
	var s_selbox = new Array();
	s_selbox[0] = new Array('한국','중국','베트남','네팔');
	s_selbox[1] = new Array('케냐', '가나', '세네갈');
	s_selbox[2] = new Array('스페인', '영국','덴마크','러시아','체코');
	s_selbox[3] = new Array('미국', '캐나다'); 
	s_selbox[4] = new Array('뉴질랜드','오스트레일리아');
	
	function init(){
		f.continent.options[0] = new Option("대륙선택", "");
		for (i = 0; i < f_selbox.length; i++) {
			f.continent.options[i + 1] = new Option(f_selbox[i]);
			if(f_selbox[i] == '${movieBean.continent}'){
				f.continent.options[i + 1].selected = true;
			}
		}
		f.nation.options[0] = new Option("나라선택", "");
		firstChange();
	}
	
	function firstChange(){
		fIndex = f.continent.selectedIndex; // 아시아:1
		len = f.nation.options.length; // 1
		for(i=len-1;i>0;i--){	
			f.nation.options[i]= null;				
		}
		for (i = 0; i < s_selbox[fIndex - 1].length; i++) {
			f.nation.options[i + 1] = new Option(s_selbox[fIndex - 1][i]);
			if(s_selbox[fIndex - 1][i] == '${movieBean.nation}'){
				f.nation.options[i + 1].selected = true;
			}
		}
	}//firstChange
	
</script>
<body onload="init()">
<h2>영화 정보 수정 화면</h2>
<form:form name="f" commandName="movieBean" action="update.mv" method="post">
	<input type="hidden" name="num" value="${movieBean.num }">
	<input type="hidden" name="pageNumber" value="${pageNumber}">
	<table border="1">
		<tr>
			<td>영화 제목</td> 
			<td>
			 <input type="text" name="title" value="${movieBean.title }">
			 <form:errors path="title" class="err"/>
			</td>
		</tr>
	<tr>
		<td>대륙</td> 
		<td>
		 <select name="continent" onChange="firstChange()">
		 </select>
		 <form:errors path="continent" class="err"/>
		</td>
	</tr>
	<tr>
		<td>나라</td>
		<td>
		 <select name="nation">
		 </select>
		 <form:errors path="nation" class="err"/>
		</td>
	</tr>
	
	<tr>
		<td>장르</td> 
		<td>
		 <c:set var="genreArr" value="${fn:split('액션,스릴러,코미디,판타지,애니메이션',',') }"/>
		 <c:forEach var="genre" items="${genreArr }">
		 <input type="checkbox" name="genre" value="${genre }" 
		 <c:if test="${fn:contains(movieBean.genre,genre) }"> checked </c:if>>${genre }
		 </c:forEach>
		 <form:errors path="genre" class="err"/>
		</td>
	</tr>
	<tr>
		<td>등급</td>
		<td>
		 <c:set var="gradeArr" value="${fn:split('19,15,12,7',',') }"/>
		 <c:forEach var="grade" items="${gradeArr }">
		  <input type="radio" name="grade" value="${grade }" 
		  <c:if test="${movieBean.grade == grade }"> checked </c:if>>${grade }
	 	 </c:forEach>
		 <form:errors path="grade" class="err"/>
	 	</td>
	</tr>
	<tr>
		<td>배우</td>
		<td>
		 <input type="text" name="actor" value="${movieBean.actor }">
	 	 <form:errors path="actor" class="err"/>
	 	</td>
	</tr>
	<tr>
		<td colspan="2">
	 	 <input type="submit" value="수정하기">
		</td>
	</tr>
</table>
</form:form>
</body>
