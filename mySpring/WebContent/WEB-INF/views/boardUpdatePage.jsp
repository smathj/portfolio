<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
.tbl {
	table-layout: fixed;
	width: 700px;
	height: 300px;
	align-content: center;
	border-radius: 5px;
}

#b1 {
	text-decoration: none;
	color: black;
}

#s1 {
	background-color: #FA8C8C;
	border-radius: 20px;
	border-style: solid;
	padding-right: 10px;
	padding-left: 10px;
}
</style>
<body>
	<div align="center">
		<h1>게시글 읽기</h1>
		<hr>
		<form action="/boardUpdate.do" method="post">
			<table class="tbl" border="1">
				<c:forEach var="vo" items="${oneList}">
					<tr>
						<td style="text-align: center; background-color: #FFB900;">글번호</td>
						<td style="text-align: center;">
						<input style="text-align: center;" type="text" name="bno" value="${vo.bno }" readonly="readonly"/></td>
					</tr>
					<tr>
						<td style="text-align: center; background-color: #FFB900;">제목</td>
						<td style="text-align: center;">
						<input style="text-align: center;" id="title" type="text" name="title" value="${vo.title }"></td>
					</tr>
					<tr>
						<td style="text-align: center; background-color: #FFB900;">내용</td>
						<td style="text-align: center;">
						<input style="text-align: center;" name="contents"  type="text" value="${vo.contents }"></td>
					</tr>
					<tr>
						<td style="text-align: center; background-color: #FFB900;">작성자</td>
						<td style="text-align: center;">
						<input style="text-align: center;" name="writer" type="text" name="contents" value="${vo.writter }" readonly="readonly"></td>
					</tr>
					<tr>
						<td style="text-align: center; background-color: #FFB900;">등록일</td>
						<td style="text-align: center;">
						<input style="text-align: center;" type="text" name="regdate" value="${vo.regdate }" readonly="readonly"/></td>
					</tr>
					<tr>
						<td style="text-align: center;" colspan="2"><span id="s1"><a id="b1" href="/boardDelete.do?bno=${vo.bno}">삭제하기</a></span></td>
					</tr>
				</c:forEach>
			</table>
			<br />
			<br /> <input type="submit" value="수정하기" /><br />
			<br />
			<br />
		</form>
		<hr>
		<!-- img태그의 src 경로는 byte이미지 가져오는 컨트롤러 호출(/getByteImage) -->
		<img alt="" src="/getByteImage" />
	</div>
</body>
</html>