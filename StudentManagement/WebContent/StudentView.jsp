<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Data</title>
<style type="text/css">
.reg{
width: 98%;
padding: 0% 20%;

}
</style>
</head>
<body>
	<%@ include file="Header.jsp"  %>
	<dir class="reg">
	<form action="StudentMngCtl.do" method="post">
	<h3>Student Info</h3>
			
				<%
					String error = (String) request.getAttribute("error");
					if (error != null) {
				%>
				<h4 style="color: Red;"><%=error%></h4>
				<%
					}
				%>
				<%
					String success = (String) request.getAttribute("success");
					if (success != null) {
				%>
				
					<h4 style="color: Blue;"><%=success%></h4>
		
				<%
					}
				%>
	  <div class="form-group">
      <label for="rollno">Roll No :</label>
	  <input type="text" class="form-control" id="email" placeholder="Enter email" name="rollno">
	  
	  <label for="fname">First Name :</label>
	  <input type="text" class="form-control" id="email" placeholder="Enter First Name" name="fname">
	  
	  <label for="lname">Last Name :</label>
	  <input type="text" class="form-control" id="email" placeholder="Enter Last Name" name="lname">
	  
	  <label for="session">Session :</label>
	  <input type="text" class="form-control" id="email" placeholder="Enter Session Years" name="session">
      </div>
    
			<button type="submit" value="Add" name="operation" class="btn btn-default">Add</button>
			<button type="submit" value="Update" name="operation" class="btn btn-default">Update</button>
			<button type="submit" value="Delete" name="operation" class="btn btn-default">Delete</button> 
            <button type="submit" value="Get" name="operation" class="btn btn-default">Get All Record</button>
            <button type="submit" value="Search" name="operation" class="btn btn-default">Search</button>
			<!-- <input type="submit" value="Search" name="operation"> -->
			<input class="btn btn-primary" type="reset" value="Reset">
			
			
			
    
    
    
	</form></dir>
  <%@ include file="Footer.jsp" %>
</body>
</html>