<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
		<link rel="stylesheet" href="asserts/css/index.css">
	</head>
	<body>
	<% 
		if(request.getParameter("error") != null && request.getParameter("error").equals("true")){
			%> <script>alert("ID/PW 를 확인하세요.")</script> <%
		}
	%>
		<div class="container">
			<form class="form-signin" method="post" action="login.jsp">
				<h2 class="form-signin-heading">Sign in</h2>
				<input type="text" class="form-control" placeholder="LOL USER ID" name="id" autofocus>
				<input type="password" class="form-control" placeholder="LOL USER PW" name="pw">
				<!-- <input type="text" class="form-control" placeholder="RIOT API KEY" name="key">
				<label class="checkbox">API Key는 Riot Developer 웹 페이지를 통해 발급받을 수 있습니다.</label> -->
				<button class="btn btn-lg btn-primary btn-block" type="submit">LOGIN</button>
			</form>
		</div> <!-- /container -->
	</body>
</html>