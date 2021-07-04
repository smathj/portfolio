<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	.tbl
	{
		 table-layout : fixed;
		 width: 700px;
		 height: 300px;
		 align-content: center;
		 border-radius: 5px;
	}
	
	#account
	{
	text-align: center; 
	background-color: #FFB900;
	}
	
	#pwd
	{
	text-align: center; 
	background-color: #FFB900;	
	}
	
	#name
	{
	text-align: center; 
	background-color: #FFB900;	
	}
	
	#inAccount
	{
		border:none;
		text-align: center;	
	}
	
	#inPwd
	{
		border:none;
		text-align: center;	
	}
	
	#inName
	{
		border:none;
		text-align: center;	
	}
	
	
</style>
<body>
<div align="center">

<form action="/join.do" method="post">
	<table class="tbl" border="1">
		<tr>
		<td id="account">계정명</td><td><input id="inAccount" type="text" name="account"/></td>
		</tr>
		
		<tr>
		<td id="pwd">패스워드</td><td><input id="inPwd" type="password" name="password"/></td>
		</tr>
		
		<tr>
		<td id="name">이름</td><td><input id="inName" type="text" name="name"/></td>
		</tr>
	</table>
	<br><br>	
		<input type="submit" value="회원가입"/>
</form>



</div>
</body>
</html>