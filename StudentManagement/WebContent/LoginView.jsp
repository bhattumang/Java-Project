<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" type="text/css" href="view.css">
<style type="text/css">
.reg{
width: 90%;
padding: 0% 20%;

}

</style>
</head>
<body>
		<div class="bgimage">
			<%@ include file="Header.jsp"  %>
			<br>
<div class="container">
  
  
  <form action="LoginCtl" method="post">
  <div class="reg">
  <h2>Login form</h2>
	<%
							String error = (String) request.getAttribute("error");
							if (error != null) {
	%>
	<th colspan="2"><h4 style="color: Red;"><%=error%></h4></th>
						
						<%
							}
						%>
						<%
							String success = (String) request.getAttribute("success");
							if (success != null) {
						%>
						<th colspan="2">
							<h4 style="color: Blue;"><%=success%></h4>
				
						<%
							}
						%>
						
<div class="form-group">
      <label for="email">Email:</label>
	 <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
    </div>
<div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pass">
    </div>
	<div class="checkbox">
      <label><input type="checkbox" name="remember"> Remember me</label>
    </div>
    <button type="submit" class="btn btn-default">Login</button>
    <input class="btn btn-primary" type="reset" value="Reset">
    <a class="btn btn-primary" href="ForgotView.jsp" role="button">Forgot Password</a>
    <a class="btn btn-primary" href="RegView.jsp" role="button">Register</a>
    </div>
  </form>

 <%@ include file="Footer.jsp" %>
</div>
</body>
</html>