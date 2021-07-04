<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<style>

	#id
	{
		
	
	}
	
	#pwd
	{
	}	

	#joinLink
	{
		text-decoration: none;
		color: black;	
	}


	#joinSpan
	{
		background-color: #FA8C8C;
		border-style :solid;
		border-radius : 10px;
		padding-left: 10px;
		padding-right: 10px;
		
	}
	
	#submitButton
	{
		background-color: #FA8C8C;
		border-style :solid;
		border-radius : 10px;
		padding-left: 10px;
		padding-right: 10px;	
	}
	
</style>

</head>
<body>
<div class="mydiv" align="center">
 	<h1>로그인</h1>
 	<hr>
<!--  	
 	<form action="/login.do" method="post">
	 	<table border="1"> 
		 	<tr>
		 	<td align="center">아이디</td><td><input type="text" name="name"/><td>
		 	</tr>
			<tr>	 	
		 	<td align="center">패스워드</td><td><input type="password" name="name"/><td>
		 	</tr>
		 	<tr>
		 	<td><input type="submit" value="로그인"/></td>
		 	<td><a href="joinPage.do" >회원가입</a></td>
		 	</tr>
	 	</table>
 	</form>
 	 -->

 	 
<form action="/login.do" method="post"> 	
	 		<input id="id" type="text" name="account" placeholder="아이디"/><br/>
	 		<input id="pwd" type="password" name="password" placeholder="패스워드"/><br/><br/>
 			<input id="submitButton" type="submit" value="로그인"><br/><br/>
			<span id="joinSpan"><a  id="joinLink" href="/joinPage.do" >회원가입</a></span>
</form> 	
<br/>
 	
</div>
 
 
 

	<hr>
	
	<h3>기능 테스트</h3> 
	<a href='/input_data.do'>DB 입력 테스트</a><br/>
	<a href='/read_data.do'>DB 출력 테스트</a><br/>
	<a href='/excel/download'>액셀  다운로드 테스트</a><br/>
	<a href='/ajaxPage1.do'>ajaxPage1.do 호출</a><br/>
	<a href="/ajaxPage2.do">ajaxPage1.do 호출2</a>
	<hr>
	<a href="/ajaxTest1.do">ajaxTest1.do 호출</a>
	
	
	
	
	
</body>
</html>