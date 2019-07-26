<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="view.css">
<style type="text/css">
.logout
{
	float: right;
}
</style>

</head>
<body>
		<%
			String email = (String) session.getAttribute("email");
			String pass = (String) session.getAttribute("pass");
			Integer count = null;
			count = (Integer) session.getAttribute("count");
			%>
	
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="HomeView.jsp">SMS</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
      <% if (email == null) { %>
        <a class="nav-link" href="HomeView.jsp">Home <span class="sr-only">(current)</span></a>
        <%} %>
    
     <% if (email != null) { %>
       </li>
      <li class="nav-item">
        <a class="nav-link" href="StudentView.jsp">Student Info</a>
      </li>
    </ul>
 <div class="logout">
<a href="LogOutCtl.do" class="btn btn-info btn-lg" >
  <span class="glyphicon glyphicon-log-out" ></span> Log out
   </a>
  </div>  
  <%} %>
  </div>
</nav>
	

</body>
</html>