<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="controller.MessageController" %>    
<%@ page import="vo.User" %>    
<%@ page import="vo.Message" %>    
<%
	System.out.println(session.getAttribute("id"));
	if(session.getAttribute("id") == null) {
		response.sendError(2, "파라미터 에러");
	} else {
		// TODO : 세션에서 로그인 정보를 가져와서 메세지 타겟에게 날림
		// 현재 테스트는 아이디 비번 명시해서 send
		String id = request.getParameter("id");
		String chat = request.getParameter("chat");
		
		User user = new User();
		user.setId((String)session.getAttribute("id"));
		user.setPw((String)session.getAttribute("pw"));
		
		Message msg = new Message();
		msg.setTargetId((String)request.getParameter("id"));
		msg.setChat((String)request.getParameter("chat"));
		
		System.out.println(request.getParameter("id") + request.getParameter("chat"));
		
		MessageController ctrl = new MessageController();
		if(ctrl.sendMessageToOneFriend(user, msg) == null){
			response.sendError(2, "ID 에러");
		} else {
			return;
		}
	}
%>
