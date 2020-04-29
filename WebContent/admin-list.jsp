<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Corona Virus Website</title>
<link rel="stylesheet" type="text/css" href="./static/css/list-style.css"/>
</head>
<body>
	<jsp:include page="admin-nav-bar.jsp"></jsp:include>
	<div class="virus-table">
        <h2>Vietnam Table</h2>
        <div class="virus-column">
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Province</th> 
                    <th>Current Infected</th>
                    <th>Current Death</th>
                    <th>Current Recover</th>
                    <th>Date</th>
                    <th>Options</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="vietnam" items="${listVietnam}">
                <tr>
                    <td><c:out value="${vietnam.id}"/></td>
                    <td><c:out value="${vietnam.provinceName}"/></td>
                    <td><c:out value="${vietnam.currentInfected}"/></td>
                    <td><c:out value="${vietnam.currentDeath}"/></td>
                    <td><c:out value="${vietnam.currentRecover}"/></td>
                    <td><c:out value="${vietnam.date}"/></td>
                    <td>
                        <a href="editProvince?id=<c:out value='${vietnam.id}'/>">Edit</a>
                        <a href="deleteProvince?id=<c:out value='${vietnam.id}'/>">Delete</a>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
        </div>
      </div>
      
      <div class="virus-table">
        <h2>World Table</h2>
        <div class="virus-column">
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Country</th> 
                    <th>Current Infected</th>
                    <th>Current Death</th>
                    <th>Current Recover</th>
                    <th>Date</th>
                    <th>Options</th>
                </tr>
             </div>   
            </thead>
            <tbody>
                <c:forEach var="world" items="${listWorld}">
                <tr>
                    <td><c:out value="${world.id}"/></td>
                    <td><c:out value="${world.countryName}"/></td>
                    <td><c:out value="${world.currentInfected}"/></td>
                    <td><c:out value="${world.currentDeath}"/></td>
                    <td><c:out value="${world.currentRecover}"/></td>
                    <td><c:out value="${world.date}"/></td>
                    <td>
                        <a href="editCountry?id=<c:out value='${world.id}'/>">Edit</a>
                        <a href="deleteCountry?id=<c:out value='${world.id}'/>">Delete</a>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
        </div>
      </div>
</body>
</html>