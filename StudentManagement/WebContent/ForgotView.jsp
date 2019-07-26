<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
.reg{
width: 90%;
padding: 0% 20%;

}

</style>
<title>Forgot Password</title>
</head>
<body>
<%@ include file="Header.jsp"  %>
<dir class="reg">
<form action="ForgotCtl" method="post">
  <%
      String error =(String) request.getAttribute("error");
      if(error!= null)
      {   
    	  %>
    	 <h4 style="color:Red;"><%=error %></h4>
    	   <%} %>
    	   
    	<%   
    	String success =(String) request.getAttribute("success");
      if(success!= null)
      {   
    	  %>
        <h4 style="color:Blue;"><%=success %></h4> 
    	   <%} %>
    <div class="form-group">
      <label for="email">Email:</label>
	 <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
    </div>
 <input type="submit" value="Forgot">
 <input type="reset" value="Reset"  >

 </form>
 </dir>
 
  <%@ include file="Footer.jsp" %>
</body>
</html>