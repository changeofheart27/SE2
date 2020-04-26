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
        <form method="post" action="updateProvince">
            <caption>
                <h3>
                    <c:if test="${vietnam != null}">EDIT PROVINCE</c:if>
                    <c:if test="${vietnam == null}">ADD PROVINCE</c:if>
                </h3>
            </caption>

            <c:if test="${vietnam != null}">
                <input type="hidden" name="id" value="<c:out value='${vietnam.id}' />" />
            </c:if>
            <fieldset>
                <label>ID:</label>
                <input type="text" value="<c:out value='${vietnam.id}' />" name="id" required>
            </fieldset>
            <fieldset>
                <label>Province:</label>
                <input type="text" value="<c:out value='${vietnam.province}' />" name="province_name" required>
            </fieldset>
            <fieldset>
                <label>Current Infected:</label>
                <input type="text" value="<c:out value='${vietnam.infected}' />" name="current_infected" required>
            </fieldset>
            <fieldset>
                <label>Current Death:</label>
                <input type="text" value="<c:out value='${vietnam.death}' />" name="current_death" required>
            </fieldset>
            <fieldset>
                <label>Current Recover:</label>
                <input type="text" value="<c:out value='${vietnam.recover}' />" name="current_recover" required>
            </fieldset>
            <fieldset>
                <label>Date:</label>
                <input type="text" value="<c:out value='${vietnam.day}' />" name="date" required>
            </fieldset>

            <button type="submit">Save</button>
        </form>
</body>
</html>