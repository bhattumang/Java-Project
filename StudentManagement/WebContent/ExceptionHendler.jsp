<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.StringWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exception Handler</title>
</head>
<body>
<font color="red"><%=exception.getMessage() %></font>

<%
     StringWriter sw= new StringWriter();
     PrintWriter pw= new PrintWriter(sw);
     exception.printStackTrace(pw);
     out.print(sw);
     sw.close();
     pw.checkError();
%>
</body>
</html>