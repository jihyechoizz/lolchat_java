<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title> ~ 님 환영합니다 </title>
		<script src="asserts/lib/js/jquery-2.1.3.min.js"></script>
		<script src="asserts/lib/js/jquery-migrate-1.2.1.min.js"></script>
		<script src="asserts/lib/js/bootstrap.min.js"></script>
		<script src="asserts/js/chat.js"></script>
		<link rel="stylesheet" href="asserts/lib/css/common.css">
		<link rel="stylesheet" href="asserts/lib/css/bootstrap.min.css">
		<link rel="stylesheet" href="asserts/lib/css/bootstrap-theme.min.css">
		<link rel="stylesheet" href="asserts/css/chat.css">
	</head>
	<body>
		<div class="container">
			<div class="collapse navbar-collapse">
				<a href="#"><span class="glyphicon glyphicon-cog pull-right"></span></a>
			</div>
		</div>
		<div class="container">
			<div class="col-sm-3">
				<div class="nav-header">
					친구목록
					<a href="#"><span class="glyphicon glyphicon-repeat pull-right"></span></a>
				</div>
				<div class="contents_list" id="friend_list">
					<div class="friends"> <!-- id에는 소환사 고유id 들어갈 예정 -->
						<a href="#">소환사아이디</a>
					</div>
					<div class="friends"> <!-- id에는 소환사 고유id 들어갈 예정 -->
						<a href="#">소환사아이디</a>
					</div>
					<div class="friends"> <!-- id에는 소환사 고유id 들어갈 예정 -->
						<a href="#">소환사아이디</a>
					</div>
					<div class="friends"> <!-- id에는 소환사 고유id 들어갈 예정 -->
						<a href="#">소환사아이디</a>
					</div>
					<div class="friends"> <!-- id에는 소환사 고유id 들어갈 예정 -->
						<a href="#">소환사아이디</a>
					</div>
					<div class="friends"> <!-- id에는 소환사 고유id 들어갈 예정 -->
						<a href="#">소환사아이디</a>
					</div>
					<div class="friends"> <!-- id에는 소환사 고유id 들어갈 예정 -->
						<a href="#">소환사아이디</a>
					</div>
					<div class="friends"> <!-- id에는 소환사 고유id 들어갈 예정 -->
						<a href="#">소환사아이디</a>
					</div>
					<div class="friends"> <!-- id에는 소환사 고유id 들어갈 예정 -->
						<a href="#">소환사아이디</a>
					</div>
					<div class="friends"> <!-- id에는 소환사 고유id 들어갈 예정 -->
						<a href="#">소환사아이디</a>
					</div>
					<div class="friends"> <!-- id에는 소환사 고유id 들어갈 예정 -->
						<a href="#">소환사아이디</a>
					</div>
					<div class="friends"> <!-- id에는 소환사 고유id 들어갈 예정 -->
						<a href="#">소환사아이디</a>
					</div>
					<div class="friends"> <!-- id에는 소환사 고유id 들어갈 예정 -->
						<a href="#">소환사아이디</a>
					</div>
					<div class="friends"> <!-- id에는 소환사 고유id 들어갈 예정 -->
						<a href="#">소환사아이디</a>
					</div>
					<div class="friends"> <!-- id에는 소환사 고유id 들어갈 예정 -->
						<a href="#">소환사아이디</a>
					</div>
					<div class="friends"> <!-- id에는 소환사 고유id 들어갈 예정 -->
						<a href="#">소환사아이디</a>
					</div>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="nav-header">
					~ 님과 채팅 중
				</div>
				<div class="chat" id="chat">
					<%@ include file="chatting.jsp" %>
				</div>
				<!-- <div>
					<input type="text" name="context" id="context">
					<button type="button" class="btn btn-primary">전 송</button>
				</div> -->
			</div>
			<div class="col-sm-3">
				<div class="nav-header">
					채팅목록
					<a href="#"><span class="glyphicon glyphicon-repeat pull-right"></span></a>
				</div>
				<div class="contents_list" id="chatting_list">
					<div class="chats"> <!-- id에는 소환사 고유id 들어갈 예정 -->
						<a href="#">'소환사아이디' 님과의 채팅</a>
					</div>
					<div class="chats"> <!-- id에는 소환사 고유id 들어갈 예정 -->
						<a href="#">'소환사아이디' 님과의 채팅</a>
					</div>
					<div class="chats"> <!-- id에는 소환사 고유id 들어갈 예정 -->
						<a href="#">'소환사아이디' 님과의 채팅</a>
					</div>
					<div class="chats"> <!-- id에는 소환사 고유id 들어갈 예정 -->
						<a href="#">'소환사아이디' 님과의 채팅</a>
						<span class="glyphicon glyphicon-star pull-right"></span>
					</div>
					<div class="chats"> <!-- id에는 소환사 고유id 들어갈 예정 -->
						<a href="#">'소환사아이디' 님과의 채팅</a>
					</div>
					<div class="chats"> <!-- id에는 소환사 고유id 들어갈 예정 -->
						<a href="#">'소환사아이디' 님과의 채팅</a>
					</div>
					<div class="chats"> <!-- id에는 소환사 고유id 들어갈 예정 -->
						<a href="#">'소환사아이디' 님과의 채팅</a>
					</div>
					<div class="chats"> <!-- id에는 소환사 고유id 들어갈 예정 -->
						<a href="#">'소환사아이디' 님과의 채팅</a>
					</div>
					<div class="chats"> <!-- id에는 소환사 고유id 들어갈 예정 -->
						<a href="#">'소환사아이디' 님과의 채팅</a>
						<span class="glyphicon glyphicon-star pull-right"></span>
					</div>
					<div class="chats"> <!-- id에는 소환사 고유id 들어갈 예정 -->
						<a href="#">'소환사아이디' 님과의 채팅</a>
						<span class="glyphicon glyphicon-star pull-right"></span>
					</div>
					<div class="chats"> <!-- id에는 소환사 고유id 들어갈 예정 -->
						<a href="#">'소환사아이디' 님과의 채팅</a>
					</div>
					<div class="chats"> <!-- id에는 소환사 고유id 들어갈 예정 -->
						<a href="#">'소환사아이디' 님과의 채팅</a>
					</div>
					<div class="chats"> <!-- id에는 소환사 고유id 들어갈 예정 -->
						<a href="#">'소환사아이디' 님과의 채팅</a>
					</div>
					<div class="chats"> <!-- id에는 소환사 고유id 들어갈 예정 -->
						<a href="#">'소환사아이디' 님과의 채팅</a>
					</div>
					<div class="chats"> <!-- id에는 소환사 고유id 들어갈 예정 -->
						<a href="#">'소환사아이디' 님과의 채팅</a>
					</div>
					<div class="chats"> <!-- id에는 소환사 고유id 들어갈 예정 -->
						<a href="#">'소환사아이디' 님과의 채팅</a>
					</div>
				</div>
			</div>
		</div> <!-- /container -->
	</body>
</html>