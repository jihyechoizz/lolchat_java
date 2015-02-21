<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="user" class="vo.User" scope="session" />
<jsp:setProperty name="user" property="*" />
<!doctype html>
<html>
	<head></head>
	<body>
	<%
	// ID & PW null check
	if((user.getId() == null || user.getId().length() == 0) || (user.getPw() == null || user.getPw().length() == 0) ){
		%>	
		<script>
			alert("Check ID & PW");
		</script>
		<%
			response.flushBuffer();
			response.sendRedirect("index.jsp");
	} else {
		// TODO : Server Response		
	
	}
	%>
		
	
	</body>
</html>

