<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Password </title>
</head>
<body>
<%@ include file="Header.jsp"  %>
<%
   String pass1=(String)request.getAttribute("pass");
%>
<dir align="center">
<h1>Your Password is <%=pass1 %></h1>
<a class="btn btn-primary" href="LoginView.jsp" role="button">Login</a>
</dir>
   <%@ include file="Footer.jsp" %>
</body>
</html>