<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Corona Virus Website</title>
<link rel="stylesheet" type="text/css" href="./static/css/edit-style.css"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" 
integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
	<jsp:include page="admin-nav-bar.jsp"></jsp:include>
        <form method="post" action="updateCountry">
        <div class="container">
          <div class="title">
            <h3><c:if test="${world != null}">EDIT COUNTRY</c:if></h3>
           	<h3><c:if test="${world == null}">ADD COUNTRY</c:if></h3>
           </div>

            <c:if test="${world != null}">
                <input type="hidden" name="id" value="<c:out value='${world.id}' />" />
            </c:if>
            
            <div class="content-table">
            <fieldset>
                <label>ID:</label>
                <input type="hidden" value="<c:out value='${world.id}' />" name="id" required> 
                <input type="text" value="<c:out value='${world.id}' />" disabled>
                <!-- Hidden still sends world.id attribute to response (but is invisible)
                , whereas disabled input DO NOT. (but is visible)-->
            </fieldset>
            <fieldset>
                <label>Country:</label>
                <input type="text" value="<c:out value='${world.countryName}' />" name="country_name" required>
            </fieldset>
            <fieldset>
                <label>Current Infected:</label>
                <input type="text" value="<c:out value='${world.currentInfected}' />" name="current_infected" required>
            </fieldset>
            <fieldset>
                <label>Current Death:</label>
                <input type="text" value="<c:out value='${world.currentDeath}' />" name="current_death" required>
            </fieldset>
            <fieldset>
                <label>Current Recover:</label>
                <input type="text" value="<c:out value='${world.currentRecover}' />" name="current_recover" required>
            </fieldset>
            <fieldset>
                <label>Date:</label>
                <input type="date" value="<c:out value='${world.date}' />" name="date" required>
            </fieldset>
            </div>
            <button class="btn btn-primary"">Save</button>
           
           </div>
        </form>
        <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>