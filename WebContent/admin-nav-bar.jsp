<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./static/css/nav-bar-ad-style.css"/>
</head>
<body>
	<div class="nav-bar">
	<nav>
		<ul>
			<li><a href="<%=request.getContextPath()%>/logout">LOGOUT</a></li>
	        <li><a href="<%=request.getContextPath()%>/newProvince">ADD PROVINCE</a></li>
	        <li><a href="<%=request.getContextPath()%>/newCountry">ADD COUNTRY</a></li>
	        <li><a href="<%=request.getContextPath()%>/selectAll" class="active">HOME</a></li>
	    </ul>
    </nav>
    </div>
</body>
</html>