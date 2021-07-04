<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="AjaxTest2.do" method="post" id="myForm">
<label>아이디</label><input type="text" id="id" name="id"/>
<button type="submit">컨트롤러 전송</button>

</form>


</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$("#myForm").submit(function(){
	
	// 입력한 아이디 읽어서 변수에 담기 
	var id = $("#id").val();								//2번행에 입력한 id의 value값을 var id 에 담기

	// ajax을 이용해서 사용가능한지 여부를 응답받는다.
	$.ajax({
			url			 		:	"AjaxTest3.do",
			method			:	"GET",
			data				:	{inputId:id},
			success		:	function(data){
													alert("AJAX 성공");
			},
			error			: function(data){
													alert("AJAX 실패");
			}
	});
});


</script>
</html>