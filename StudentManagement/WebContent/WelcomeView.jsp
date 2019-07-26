<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Page</title>
<link rel="stylesheet" type="text/css" href="view.css">
</head>
<body>
<div class="bgimage">
 <%@ include file="Header.jsp"  %>

<%
   String fname = (String) session.getAttribute("fname");
   String lname = (String) session.getAttribute("lname");
%>

  <h1 align="center" >Welcome <%=fname %></h1>
  
  <ul class="nav justify-content-center">
  <li class="nav-item">
    <a class="nav-link active" href="#">Active</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="#">Link</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="#">Link</a>
  </li>
  <li class="nav-item">
    <a class="nav-link disabled" href="#">Disabled</a>
  </li>
</ul>
  
   <%@ include file="Footer.jsp" %>
   </div>
</body>
</html>