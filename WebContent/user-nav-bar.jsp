<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./static/css/nav-bar-ad-style.css"/>
</head>
<body>
	<div class="nav-bar">
	<nav>
	<ul>		
		<li><a href="<%=request.getContextPath()%>/login">LOGIN</a></li>
		<li><a>CHART</a></li>
		<li><a href="<%=request.getContextPath()%>/home" class="active">HOME</a></li>
	</ul>
    </nav>
    </div>
</body>
</html>