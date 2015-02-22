<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>LOL CHAT v.0.1</title>
	<script src="asserts/lib/js/jquery-2.1.3.min.js"></script>
	<script src="asserts/lib/js/jquery-migrate-1.2.1.min.js"></script>
	<script src="asserts/lib/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="asserts/lib/css/common.css">
	<link rel="stylesheet" href="asserts/lib/css/bootstrap.min.css">
	<link rel="stylesheet" href="asserts/lib/css/bootstrap-theme.min.css">
	<script>
		function sendMessage(){
			$.ajax({
				type: 'POST',
				url: 'do/sendMessage.jsp',
				data: {id: 'sum1243410@pvp.net', chat: '안녕 ajax 메세지전송테스트 !!123@#$'},
				dataType: 'json'
			}).done(function(data){
				$('p').append('done:  ' + data);
			}).fail(function(data){
				alert(data);
				$('p').append('fail : ' + data);
			}).always(function(data){
				$('p').append('always:  ' + data);
			});
		};		
	</script>

<title>Insert title here</title>
</head>
<body>
	<p>
	</p>
	<!-- Ajax 메세지 전송 테스트 -->
	<button type="button" onclick="sendMessage()">Message Send!</button>
</body>
</html>