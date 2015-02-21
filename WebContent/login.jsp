<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<jsp:useBean id="user" class="vo.User" scope="session" />
<%@ page import="connection.RiotLoginCert" %>
<% 
	user.setId(request.getParameter("id"));
	user.setPw(request.getParameter("pw"));
%>
<!doctype html>
<html>
	<head></head>
	<body>
	<%
	// ID & PW null check
	if((user.getId() == null || user.getId().length() == 0) || (user.getPw() == null || user.getPw().length() == 0) ){
			response.sendRedirect("index.jsp?error=true");
	} else {
		// TODO : Server Response	
		if(! RiotLoginCert.checkValidAccount(user)) {
			response.sendRedirect("index.jsp?error=true");
		} else {
			session.setAttribute("id", user.getId());
			response.sendRedirect("chat.jsp");
		}
	}
	%>
		
	
	</body>
</html>

