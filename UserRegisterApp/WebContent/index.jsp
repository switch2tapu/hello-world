<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/style.css">
<title>Welcome to Registration Page</title>
<script type="text/javascript">
function validate(){
var username ="";
var 
	
}

</script>
</head>


<body bgcolor="#B6E6FA">

<form action="./RegisterController" method= "post" ><br>
<div id="login-box">
  <div class="left">
    <h1>Sign up</h1>
    <input type="text" name="username" placeholder="Username" />
	<input type="text" name="firstname" placeholder="Firstname"  />
    <input type="text" name="emailid" placeholder="E-mail" />
    <center><input type="password" name="password" placeholder="Password" /><input type="submit" value="SignUp"></center>
</div>
</form>
<div class="right">

    <form action ="Login" method ="post">
    
    <span class="loginwith">Sign in <br /></span>
    <input type="text" name="username" placeholder="Username" />
    <input type="password" name="password" placeholder="Password"  />
    <center><input type="submit" value="Signin"></center>
    </div>
  <div class="or">OR</div>
</div>

</form>


</body>
</html>