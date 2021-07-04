<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form>
		아이디 : <input type="text" id="name"/>
		비밀번호 : <input type="password" id="pwd"/>
		<button onclick="send()">컨트롤러로 보내기</button>
	</form>

</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>

function send(){
	var name = $("#name").val();
	var pwd = $("#pwd").val();
	
	var form = {
			"name" : name,
			"pwd" : pwd
			
	};
	$.ajax({
        type     : 'post'
        , async  : true
        , url    : '/check.do'
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



</script>



</html>