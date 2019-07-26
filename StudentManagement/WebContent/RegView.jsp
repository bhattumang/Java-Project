<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Registration Page</title>
<link rel="stylesheet" type="text/css" href="view.css">

<style type="text/css">
.reg{
width: 95%;
padding: 0% 25%;

}

</style>

</head>
<body>
<div class="bgimage">
<%@ include file="Header.jsp"  %>


<form  action="RegUserCtl" method="post">

<div class="reg">
<h1>Register</h1>
 
  	<%
			String error = (String) request.getAttribute("error");
			if (error != null) {
	%>
				<h4 style="color: Red;"> <%=error%> </h4>
	
	<%}%>
    
    <div class="form-row">
    <div class="form-group col-md-6">
      <label for="validationCustom01">First name</label>
      <input type="text" Name="fname" class="form-control" id="validationCustom01" placeholder="First name" required>
      <div class="valid-feedback">
        Looks good!
      </div>
    </div>
    
    <div class="form-group col-md-6">
      <label for="validationCustom02">Last name</label>
      <input type="text" Name="lname" class="form-control" id="validationCustom02" placeholder="Last name" required>
      <div class="valid-feedback">
        Looks good!
      </div>
    </div>
 	
    
    <div class="form-group col-md-4">
    <label for="validationCustom02">Gender</label>
      <select class="form-control" id="inlineFormCustomSelect">
        <option selected>Gender</option>
        <option name="gender" value="M">Male</option>
        <option name="gender" value="F">Female</option>
        <option name="gender" value="O">Other</option>
      </select>
    </div>
    
    
   
     
    
     
    <div class="form-group col-md-8">
      <label for="inputEmail4">Email</label>
      <input type="email" Name="email" class="form-control" id="inputEmail4" placeholder="Email">
    </div>
    
    <div class="form-group col-md-7">
      <label for="inputPassword4">Password</label>
      <input type="password" Name="pass" class="form-control" id="inputPassword4" placeholder="Password">
    </div>
    
    <div class="form-group col-md-5">
      <label for="validationCustom01">Date Of Birth :</label>
      <input type="text" Name="dob" class="form-control" id="validationCustom01" placeholder="DD/MM/YYYY" required>
      <div class="valid-feedback">
        Looks good!
      </div></div>	
      
 
  
  
  
  <div class="form-group col-md-6">
    <label for="inputAddress">Mobial No.</label>
    <input type="text"  Name="number" class="form-control" id="inputAddress" placeholder="Enter 10 Digit Mobial No">
  </div>
   

    <div class="form-group col-md-6">
      <label for="inputCity">City</label>
      <input type="text" Name="city" class="form-control" id="inputCity">
    </div>
    
    <div class="form-group col-md-5">
      <label for="inputState">State</label>
      <select id="inputState" Name="state"class="form-control">
        <option selected>M.P.</option>
        <option selected>Rajasthan</option>
        <option>...</option>
      </select>
    </div>
    
    <div class="form-group col-md-7">
      <label for="inputZip">Zip</label>
      <input type="text" Name="pincode" class="form-control" id="inputZip">
    </div>

</div>	
  
  <br>
  <button type="submit" value="Sign Up" class="btn btn-primary">Sign Up</button>
 <input class="btn btn-primary" type="reset" value="Reset">
<a class="btn btn-primary" href="LoginView.jsp" role="button">Login</a>

  
  </div>
</form>

<%@ include file="Footer.jsp" %>
	</div>
</body>
</html>