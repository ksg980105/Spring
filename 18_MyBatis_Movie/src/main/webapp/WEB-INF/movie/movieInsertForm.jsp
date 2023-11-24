<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
movieInsertForm.jsp
<br>

<style>
.err {
	font-size: 9pt;
	color: red;
	font-weight: bold;
}
</style>

<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
<script type="text/javascript">
	var f_selbox = new Array('아시아','아프리카','유럽','아메리카','오세아니아');
	
	var s_selbox = new Array();
	s_selbox[0] = new Array('한국','중국','베트남','네팔');
	s_selbox[1] = new Array('케냐', '가나', '세네갈');
	s_selbox[2] = new Array('스페인', '영국','덴마크','러시아','체코');
	s_selbox[3] = new Array('미국', '캐나다'); 
	s_selbox[4] = new Array('뉴질랜드','오스트레일리아');
	
	var selectedContinent;
	function init(myform, continent, nation){
		for(i=0; i<f_selbox.length; i++){
			myform.continent.options[i + 1] = new Option(f_selbox[i]);
			if(myform.continent.options[i + 1].value == continent){
				myform.continent.options[i + 1].selected = true;
				selectedContinent = i;
			}
		}
		
		for(j=0; j<s_selbox[selectedContinent].length; j++){
			myform.nation.options[j+1] = new Option(s_selbox[selectedContinent][j]);
			if(myform.nation.options[j+1].value == nation){
				myform.nation.options[j+1].selected = true;
			}
		}
	}
	
	function firstChange(){
		fIndex = myform.continent.selectedIndex;
		slen = myform.nation.options.length;
		
		for(i=slen-1; i>0; i--){
			myform.nation.options[i] = null;
		}
		
		for(i=0; i<s_selbox[fIndex-1].length; i++){
			myform.nation.options[i+1] = new Option(s_selbox[fIndex-1][i]);
		}
	}
	
	$(document).ready(function() { 
		var isCheck = false;
		
		$('#title_check').click(function(){ // 중복체크버튼
			
			isCheck = true;
			
			$.ajax({
				url : "title_check_proc.mv", // 요청url
				data : ({
					inputtitle : $('input[name="title"]').val() // inputtitle=배트맨
				}),
				success : function(data){
					
					if($('input[name="title"]').val() == ""){
						$('#titleMessage').html("<font color=blue>title 입력 누락</font>");
						$('#titleMessage').show();
					}
					else if(jQuery.trim(data)=='YES'){
						$('#titleMessage').html("<font color=blue>사용 가능합니다.</font>");
						use = "possible";
						$('#titleMessage').show();
					}else{
						$('#titleMessage').html("<font color=red>이미 사용중인 제목입니다.</font>")
						use = "impossible";
						$('#titleMessage').show();
					}
				}//success
			});//ajax
			
		});//중복체크 click
		
		$("input[name='title']").keydown(function(){

			isCheck = false;
			use="";
			$('#titleMessage').css('display','none');
		}); // keydown
		
		$('#sub').click(function(){ // submit 클릭
			if(use == "impossible"){
				alert('이미 사용중인 제목입니다.');
				return false;
			}else if(isCheck == false){ 
				alert('중복체크 하세요');
				return false;
			} 
		});//click(submit 클릭)
		
	}); // ready
</script>

<body
	onLoad="init(myform,'${movieBean.continent}','${movieBean.nation}')">
	<form:form name="myform" commandName="movieBean" action="insert.mv"
		method="post">
		<h2>영화 정보 등록 화면 (${movieBean.continent } / ${movieBean.nation})</h2>

		<p>
			<label>영화 제목 : </label> 
			<input type="text" name="title" value="${movieBean.title}"> 
			<input type="button" id="title_check" value="중복체크"> 
			<span id="titleMessage"	style="display: none;"></span>
			<form:errors cssClass="err" path="title" />
		</p>

		<p>
			<label>대륙 : </label> <select name="continent" onChange="firstChange()">
				<option value="">대륙 선택하세요</option>
			</select>
			<form:errors cssClass="err" path="continent" />

			<label>나라 : </label> <select name="nation">
				<option value="">나라 선택하세요</option>
			</select>
			<form:errors cssClass="err" path="nation" />
		</p>
		<p>
			<label>장르 : </label>
			<%
			String[] mgenre = { "액션", "스릴러", "코미디", "판타지", "애니메이션" };
			%>
			<c:forEach var="genre" items="<%=mgenre%>">
				<input type="checkbox" name="genre" value="${genre}"
					<c:if test="${movieBean.genre.contains(genre)}">checked</c:if>>${genre}
			</c:forEach>
			<form:errors cssClass="err" path="genre" />
		</p>
		<p>
			<label>여행 타입 : </label>
			<%
			String[] mgrade = { "19", "15", "12", "7" };
			%>
			<c:forEach var="grade" items="<%=mgrade%>">
				<input type="radio" name="grade" value="${grade}"
					<c:if test="${movieBean.grade == grade}">checked</c:if>>${grade}
			</c:forEach>
			<form:errors cssClass="err" path="grade" />
		</p>
		<p>
			<label>출연 배우 : </label> <input type="text" name="actor"
				value="${movieBean.actor}">
			<form:errors cssClass="err" path="actor" />
		</p>

		<p>
			<input type="submit" value="추가하기" id="sub">
		</p>
	</form:form>
</body>