<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Corona Virus Website</title>
<link rel="stylesheet" type="text/css" href="./static/css/edit-style.css"/>
</head>
<body>
	<jsp:include page="admin-nav-bar.jsp"></jsp:include>
        <form method="post" action="insertProvince">
        <div class="container">
        <div class="title">
            <h3>ADD PROVINCE</h3>
        </div>  
            <div class="field-name">
            <fieldset>
                <label>Province:</label>
                <input type="text" name="province_name" required>
            </fieldset>
            <fieldset>
                <label>Current Infected:</label>
                <input type="text" name="current_infected" required>
            </fieldset>
            <fieldset>
                <label>Current Death:</label>
                <input type="text" name="current_infected" required>
            </fieldset>
            <fieldset>
                <label>Current Recover:</label>
                <input type="text" name="current_recover" required>
            </fieldset>
            <fieldset>
                <label>Date:</label>
                <input type="date" name="date" required>
            </fieldset>
       </div>
		</div>
		<div id="button">
            <button type="submit">ADD</button>
            </div>
        </form>
</body>
</html>