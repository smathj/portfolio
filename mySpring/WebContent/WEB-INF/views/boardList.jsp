<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.tbl 
	{
		border-radius: 10px;
		width: 1200px;
		height: 500px;
		table-layout: fixed;

	}
	
	.tr
	{
		background-color: #FFB900;
		border-radius: 10px;
	}
	.tr2
	{
		background-color: #F0FFF0	;
		border-radius: 10px;
	}
	
	#link
	{
		text-decoration: none;
		color: black;
	}
	
	#b1
	{
		text-decoration: none;
		color: black;
	}
	
	#b2
	{
		text-decoration: none;
		color: black;
	}
	
	#s1
	{
		background-color: #FA8C8C;
		border-radius: 20px;
		border-style: solid;
		padding-right: 10px;
		padding-left: 10px;
	}
	
	#s2
	{
		background-color: #FA8C8C;
		border-radius: 20px;
		border-style: solid;
		padding-right: 10px;
		padding-left: 10px;
	}
	
	.mydiv
	{
		width: 1300px;
		align-content: center;
		padding-left: 300px;
	}
	
	#no
	{
		text-align: center;
	}
	
	#reg
	{
		text-align: center;	
	}
	
	#writter
	{
		text-align: center;	
	}
	
</style>

</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
/* 
function test(){
	console.log("테스트 함수 작동");
	
	var searchType = $("#searchType").val();
	alert(searchType);
	var keyword = $("#keyword").val(); 
	alert(keyword);
	//
	var form = {
			"searchType" : searchType,
			"keyword" : keyword
	};
			

	$.ajax({
        type     : 'get'
        , async  : true
        , url    : '/searchTest.do'
        , contentType: 'application/x-www-form-urlencoded; charset=UTF-8'
       	, data   : form
        , success: function (data) {      
        	if(data == "success"){
        		alert("성공.");
        		location.reload();
        	} else if(data == "fail"){
        		alert("실패.");
        		location.reload();
        	}	
        }
        , error  : function (data, status, err) {
            alert('서버와의 통신이 실패했습니다.');
        }
    });
	
}

 */

</script>
<body>
<div class="mydiv">
<h1 style="text-align: center">게시글 리스트</h1>
<hr>

<form action="/boardList.do" method="get">
<select name="searchType">
	<option name="title" value="title">제목</option>
	<option name="contents" value="contents">내용</option>
</select>
<input name="keyword" id="keyword" type="text" placeholder="검색어를 입력해주세요">
<input type="submit" value="검색"/>
</form>

<hr>
<form>
	<table class="tbl" border="1">
		<tr class="tr">
			<th>글번호</th>	
			<th>제목</th>	
			<th>내용</th>	
			<th>작성자</th>	
			<th>등록일</th>	
		</tr>
	
		<c:forEach var="vo" items="${viewAll }">
		<tr class="tr2">
			<td id="no">${vo.bno }</td>
			<td><a id="link" href="boardUpdatePage.do?bno=${vo.bno }">${vo.title }</a></td>
			<c:choose>
				<c:when test="${fn:length(vo.contents) > 17 }">
					<td><c:out value="${fn:substring(vo.contents,0,16)}"/>...</td>
					<!-- <td>${vo.contents }</td> -->
				</c:when>	
				<c:otherwise>
						<td>${vo.contents }</td>
				</c:otherwise>
			</c:choose>
			<td id="writter">${vo.writter }</td>
			<td id="reg">${vo.regdate }</td>
		</tr>
		</c:forEach>
	</table>
</form>
<br/><br/><br/>
<!-- 페이징 시작 -->

	<div style="display: block; text-align: center;">		
		<a style="text-decoration: none;" href="/boardList.do?nowPage=1&cntPerPage=${paging.cntPerPage}">[처음]&nbsp;</a>
		<c:if test="${paging.startPage != 1 }">
			<a style="text-decoration: none;" href="/boardList.do?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}">[이전]</a>
		</c:if>
		<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
			<c:choose>
				<c:when test="${p == paging.nowPage }">
					<b>${p }</b>
				</c:when>
				<c:when test="${p != paging.nowPage }">
					<a style="text-decoration: none;" href="/boardList.do?nowPage=${p }&cntPerPage=${paging.cntPerPage}">${p }</a>
				</c:when>
			</c:choose>
		</c:forEach>
		<c:if test="${paging.endPage != paging.lastPage}">
			<a style="text-decoration: none;"  href="/boardList.do?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}">[다음]</a>
		</c:if>
		<a style="text-decoration: none;"  href="/boardList.do?nowPage=${paging.lastPage }&cntPerPage=${paging.cntPerPage}">&nbsp;[끝]</a>
	</div>
	
<div id="outter">
	<div style="float: right;">
		<select id="cntPerPage" name="sel" onchange="selChange()">
			<option value="5"
				<c:if test="${paging.cntPerPage == 5}">selected</c:if>>5줄 보기</option>
			<option value="10"
				<c:if test="${paging.cntPerPage == 10}">selected</c:if>>10줄 보기</option>
			<option value="15"
				<c:if test="${paging.cntPerPage == 15}">selected</c:if>>15줄 보기</option>
			<option value="20"
				<c:if test="${paging.cntPerPage == 20}">selected</c:if>>20줄 보기</option>
		</select>
	</div> <!-- 옵션선택 끝 -->	
<hr>
<br/>
	<span id="s1">
		<a id="b1" href="boardPage.do">글 등록  </a>
	</span><br/><br/>
	<span id="s2">
		<a id="b2" href="logout.do">로그 아웃  </a>
	</span><br/><br/>
	</div>
</div>





<script>
	function selChange() {
		var sel = document.getElementById('cntPerPage').value;
		location.href="boardList.do?nowPage=${paging.nowPage}&cntPerPage="+sel;
	}	

</script>
</body>
</html>