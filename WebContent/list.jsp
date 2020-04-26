<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Corona Virus Website</title>
<link rel="stylesheet" href="list-style.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<jsp:include page="nav-bar.jsp"></jsp:include>
        <h2>Vietnam Table</h2>
        <table width="500">
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
                    <td><c:out value="${vietnam.province}"/></td>
                    <td><c:out value="${vietnam.infected}"/></td>
                    <td><c:out value="${vietnam.death}"/></td>
                    <td><c:out value="${vietnam.recover}"/></td>
                    <td><c:out value="${vietnam.day}"/></td>
                    <td>
                        <a href="editProvince?id=<c:out value='${vietnam.id}'/>">Edit</a>
                        <a href="deleteProvince?id=<c:out value='${vietnam.id}'/>">Delete</a>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
        
        <h2>World Table</h2>
        <table width="500">
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
            </thead>
            <tbody>
                <c:forEach var="world" items="${listWorld}">
                <tr>
                    <td><c:out value="${world.id}"/></td>
                    <td><c:out value="${world.country}"/></td>
                    <td><c:out value="${world.infected}"/></td>
                    <td><c:out value="${world.death}"/></td>
                    <td><c:out value="${world.recover}"/></td>
                    <td><c:out value="${world.day}"/></td>
                    <td>
                        <a href="editCountry?id=<c:out value='${world.id}'/>">Edit</a>
                        <a href="deleteCountry?id=<c:out value='${world.id}'/>">Delete</a>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
</body>
</html>