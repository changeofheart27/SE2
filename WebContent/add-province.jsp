<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Corona Virus Website</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<jsp:include page="nav-bar.jsp"></jsp:include>
        <form method="post" action="insertProvince">
            <h3>ADD PROVINCE</h3>
            <fieldset>
                <label>ID:</label>
                <input type="text" name="id" required>
            </fieldset>
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
                <input type="text" name="date" required>
            </fieldset>
            <button type="submit">ADD</button>
        </form>
</body>
</html>