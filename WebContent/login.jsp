<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Administrator Login Form</title> 
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="./static/css/style.css"/>
</head>
<body>
	
	<div class="loginBox">
		
		<h2>Administrator</h2>
		<form action="verifyLogin" method="post">
			<p>User Name</p>
			<input type="text" name="username" placeholder="Enter username" required>
			<p>Password</p>
			<input type="password" name="password" placeholder="Enter password" required>
			<input type="submit" value="Sign In">
		</form>
		
		<h3>${param.error}</h3>
	</div>
	
</body>
</html>

<!-- 
<img src="images/image-ad.png"/>
<img src="<%=request.getContextPath()%>/images/image-ad.png"/>
class="user" -->