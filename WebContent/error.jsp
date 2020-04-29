<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Corona Virus Website</title>
</head>
<body>
	<jsp:include page="user-nav-bar.jsp"></jsp:include>
	<h2>Error Page:</h2>
	<h3>${param.error}</h3>
	
	<a href="<%=request.getContextPath()%>/"><button id="back">Go back to home page</button></a>
</body>
</html>