<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./static/css/nav-bar-ad-style.css"/>
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
</head>
<body>
	<div class="nav-bar">
	<nav>
	<ul style="margin:0">		
		<li><a href="<%=request.getContextPath()%>/login">LOGIN</a></li>
		<li><a href="<%=request.getContextPath()%>/chart">CHART</a></li>
		<li><a href="<%=request.getContextPath()%>/home" class="active">HOME</a></li>
	</ul>
    </nav>
    </div>
    <jsp:include page="scroll-top.jsp"></jsp:include>
</body>
</html>