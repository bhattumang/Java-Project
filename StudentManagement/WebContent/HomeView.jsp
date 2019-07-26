<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
<link rel="stylesheet" type="text/css" href=view.css>
</head>
<body>
	<div class="bgimage">
		<%@ include file="Header.jsp"  %>
		
			<div class="text">
				<h1>Student Management System</h1>
				<h4>Secure Management Web Application</h4>
				<br>
	<button type="button" class="btn btn-primary btn-lg" onclick="window.location.href = 'LoginView.jsp';">Login</button>
     <button type="button" class="btn btn-secondary btn-lg" onclick="window.location.href = 'RegView.jsp';">Register</button>
</div>
		
		<%@ include file="Footer.jsp" %>
	</div>
</body>
</html>