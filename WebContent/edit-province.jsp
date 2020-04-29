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
        <form method="post" action="updateProvince">
        <div class="container">
        <div class="title">
            <c:if test="${vietnam != null}">EDIT PROVINCE</c:if>
            <c:if test="${vietnam == null}">ADD PROVINCE</c:if>>

            <c:if test="${vietnam != null}">
                <input type="hidden" name="id" value="<c:out value='${vietnam.id}' />" />
            </c:if>
        </div>    
        <div class="field-name">
            <fieldset>
                <label>ID:</label>
                <input type="hidden" value="<c:out value='${vietnam.id}' />" name="id" required>
                <input type="text" value="<c:out value='${vietnam.id}' />" disabled>
            </fieldset>
            <fieldset>
                <label>Province:</label>
                <input type="text" value="<c:out value='${vietnam.provinceName}' />" name="province_name" required>
            </fieldset>
            <fieldset>
                <label>Current Infected:</label>
                <input type="text" value="<c:out value='${vietnam.currentInfected}' />" name="current_infected" required>
            </fieldset>
            <fieldset>
                <label>Current Death:</label>
                <input type="text" value="<c:out value='${vietnam.currentDeath}' />" name="current_death" required>
            </fieldset>
            <fieldset>
                <label>Current Recover:</label>
                <input type="text" value="<c:out value='${vietnam.currentRecover}' />" name="current_recover" required>
            </fieldset>
            <fieldset>
                <label>Date:</label>
                <input type="date" value="<c:out value='${vietnam.date}' />" name="date" required>
            </fieldset>
		</div>
		</div>
		<div id="button">
            <button type="submit">Save</button>
            </div>
        </form>
</body>
</html>