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
        <form method="post" action="insertCountry">
           <div class="container">
            <h3>ADD COUNTRY</h3>
              <div class="content-table">
            <fieldset>
                <label>Country:</label>
                <input type="text" name="country_name" required>
            </fieldset>
            <fieldset>
                <label>Current Infected:</label>
                <input type="text" name="current_infected" required>
            </fieldset>
            <fieldset>
                <label>Current Death:</label>
                <input type="text" name="current_death" required>
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
          	  <button class="btn btn-primary">ADD</button>
        </div>
        </form>
        <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>