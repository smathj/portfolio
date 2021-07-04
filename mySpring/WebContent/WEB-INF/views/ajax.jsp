<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기본 aJax</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script>

/* 
$('#btn1').on('click', function(){
     var form = {
             name  : "수달",
             age		: 5
   			  };
   			  
     $.ajax({
         type		: 'post',
         url			: 'ajax.do',
         data		: form,
         success: function(data){
             					$('#result').text(data);
        				 					  },
         error		: function(){
             					alert("기본 aJax 실패");
        				 					  }
    		 });
 });

 */
 $.ajax({
		url:"ajax.do",
		type:"post",
		contentType : "application/json; charset=utf-8",
		dataType : "json",
		success : function(data){				// data 는 Map 타입이라서 data.msg , data.A , data.B 형식으로 뽑아낼수있다.
			console.log(data)
			
			$("#test1").append("<h1>test1</h1>")
			$("#test2").append("<h1>"+data.msg+"</h1>")
			$("#test3").append("<h1>"+data.A+"</h1>")
			$("#test4").append("<h1>"+data.B+"</h1>")
			$("#test5").append("<h1>"+$("#test1").html()+"</h1>")	// test1 id값을 갖은 태그 쌍 사이에 존재하는 글자 가져오기
				
		}
 })
 
</script>
</head>
<body>
<!-- 
	<button id="btn1">기본 aJax</button>
	<div id="result"></div>
 -->
 
 	<ul>
 		<li id="test1"></li>
 		<li id="test2"></li>
 		<li id="test3"></li>
 		<li id="test4"></li>
 		<li id="test5"></li>
 	</ul>
 	
</body>
</html>