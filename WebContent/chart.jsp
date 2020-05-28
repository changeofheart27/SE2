<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Google Chart Servlet</title>
<link rel="stylesheet" type="text/css"
	href="./static/css/nav-bar-ad-style.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">

	//Load Charts and the corechart package
    google.load('visualization', {'packages' : [ 'corechart' ]});
	//Draw the Pie Chart
    google.setOnLoadCallback(drawPieChart);
	//Draw the Bar Chart
    google.charts.setOnLoadCallback(drawBarChart);
    
    function drawPieChart() {
        var data = google.visualization.arrayToDataTable([
        	['Country Name', 'Current Infected'],
        	<c:forEach var="worldChart" items="${listWorld}">
            	['${worldChart.countryName}', ${worldChart.currentInfected}],
          	</c:forEach>
           	]);
        
        var options = {
            title: 'Top 5 Most Infected Countries in the World',
            width: 600,
            height: 400
        };
        
        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.PieChart(document.getElementById('piechart'));
        chart.draw(data, options);
    }
    
    function drawBarChart() {
		var data = google.visualization.arrayToDataTable([
	        ['Date', 'Current Infected', 'Current Death', 'Current Recover' ],
	        <c:forEach var="vietnamChart" items="${listVietnam}">
	        ['${vietnamChart.date}', ${vietnamChart.currentInfected},
	        	${vietnamChart.currentDeath}, ${vietnamChart.currentRecover}],
	        </c:forEach>
	      ]);

	      var options = {
	        width: 600,
	        height: 400,
	        legend: { position: 'top', maxLines: 3 },
	        bar: { groupWidth: '75%' },
	        isStacked: true,
	      };

	      var chart = new google.visualization.ColumnChart(document.getElementById('barchart'));
	      chart.draw(data, options);
	    }
</script>
</head>
<body>
	<jsp:include page="user-nav-bar.jsp"></jsp:include>
	<div class="container">
		<h3 class="text-center">Charts</h3>
		<table class="columns">
			<tr>
				<td><div id="piechart" style="border: 1px solid #ccc"></div></td>
				<td><div id="barchart" style="border: 1px solid #ccc"></div></td>
			</tr>
		</table>

	</div>
</body>
</html>