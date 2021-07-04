<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 등록</title>

<style>
.mydiv
{

}


#title
{
	background-color: #FA8C8C;
	width: 60px; 
	border-radius: 10px;
}

#contents
{
	background-color: #FA8C8C;
	border-radius: 10px;
	
}

#reg
{
	background-color: #8FBC8F;
	border-radius: 10px;
	
}

table 
{
 table-layout : fixed;
 width: 580px;
 height: 280px;
 align-content: center;
 border-radius: 5px;
}

#text
{
	width: 497px;
	padding: 0px;
	border-radius: 10px;
}

#titleIn
{
	width: 497px;
	padding: 0px;
	border-radius: 10px;
}

#tr1
{
	border-radius: 10px;
}
#tr2
{
	border-radius: 10px;
}
#tr3
{
	border-radius: 10px;
}

</style>


</head>
<body>
<div align="center">
<h1>글 등록</h1>
<hr/>
<div class="mydiv">	
	<form action="boardInsert.do" method="post" >
		<table class="tbl" border="1">
			
			<tr id="tr1">
				<td id="title">&nbsp;&nbsp;&nbsp;제목</td>
				<td><input id="titleIn" type="text" name="title" size="30"/></td>
			</tr>
			
			<tr id="tr2">
				<td id="contents">&nbsp;&nbsp;&nbsp;내용</td>
				<td><textarea id="text" name="contents" cols="40" rows="10"></textarea></td>
			</tr>
			
			<tr id="tr3">
				<td id="reg" colspan="2" style="text-align: center"><input type="submit" value="글 등록"/></td>
			</tr>
		</table>
	</form>
<hr/>
</div>	
</div>
</body>
</html>