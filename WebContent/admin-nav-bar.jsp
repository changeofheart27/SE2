<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./static/css/nav-bar-ad-style.css"/>
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
</head>
<body>
	<div class="nav-bar">
	<nav>
		<ul style="margin:0">
			<li><a href="<%=request.getContextPath()%>/logout">LOGOUT</a></li>
	        <li><a href="<%=request.getContextPath()%>/newProvince">ADD PROVINCE</a></li>
	        <li><a href="<%=request.getContextPath()%>/newCountry">ADD COUNTRY</a></li>
	        <li><a href="<%=request.getContextPath()%>/selectAll" class="active">HOME</a></li>
	    </ul>
    </nav>
    </div>
    <jsp:include page="scroll-top.jsp"></jsp:include>
</body>
</html>