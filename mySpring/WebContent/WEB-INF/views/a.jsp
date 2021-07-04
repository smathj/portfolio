<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<table border="1">
			<tr>
			<th>data1의 값</th>
			<th>data2의 값</th>
			<th>data3의 값</th>
			</tr>
	<c:forEach var="select_list" items="${list}">
			<tr>
			<td>${select_list.data1 }</td>
			<td>${select_list.data2 }</td>
			<td>${select_list.data3 }</td>
			</tr>
	</c:forEach>
		</table>
			
			
		
		
	
</body>
</html>