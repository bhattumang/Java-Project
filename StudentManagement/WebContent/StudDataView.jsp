<%@page import="com.student.bean.StudentBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
.reg{
width: 95%;
padding: 0% 20%;

}

</style>
<title>Student List here</title>
</head>
<body>

	<%@ include file="Header.jsp"  %>
	<dir class="reg">
	<%ArrayList<StudentBean> al = (ArrayList)request.getAttribute("al"); %>
	<table class="table" align="center">

     <thead class="thead-dark">
     <tr>
        <th scope="col">Roll No</th>
      <th scope="col">First Name</th>
      <th scope="col">Last Name</th>
      <th scope="col">Session</th>
    </tr>
  </thead>
	<%
	   int i=0;
		for (i = 0; i <al.size(); i++) {
	%>
	<%
		StudentBean sb = (StudentBean) al.get(i);
	%>

  <tbody>
    <tr>
      <th scope="row"><%=sb.getRollNo()%></th>
      <td><%=sb.getFname()%></td>
      <td><%=sb.getLname()%></td>
      <td><%=sb.getSession()%></td>
    </tr>
	
	<%
		}
	%>
</table>
                
  <ul class="pager">
  <% if(i>9) {%>
    <li><a href="#">Previous</a></li>   <%} %>
    <li><a href="#">Next</a></li>
  </ul>
</div>


	  <%@ include file="Footer.jsp" %>
</body>
</html>