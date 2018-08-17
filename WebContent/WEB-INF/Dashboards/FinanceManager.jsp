<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">


<!-- Bootstrap CSS -->
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">

<!-- Bootstrap core CSS -->
<link href="Styles/css/bootstrap.min.css" rel="stylesheet">

<!-- Your custom styles -->
<link rel="stylesheet" href="Styles/css/dashboardStyleSheet.css">
<link href="Styles/css/customeText.css" rel="stylesheet">
<!-- font awesome icon pack-->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<!--java scrip file for google charts-->
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>

<!--google maps library -->
<script
	src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY&callback=myMap"></script>
	
	
<!--data table files -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<script type="text/javascript" src="Styles/js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="Styles/js/jquery.dataTables.min.js"></script>
<script type="text/javascript"
	src="Styles/js/dataTables.bootstrap4.min.js"></script>
<link rel="stylesheet" href="Styles/css/dataTables.bootstrap4.min.css">

<title>Sumith Tyres pvt Ltd</title>
</head>

<body>


	<!-- start of the the navigation header-->

    <%@ include file="/WEB-INF/PageSegments/Finance_Management/_navigationheader.jsp" %>
	<!-- end of the navigation header-->

	<!-- side bar starts -->

	<!-- only visibale in 10'0 inch or above screens-->
	<%@ include file="/WEB-INF/PageSegments/Finance_Management/_sidebar.jsp" %>

	<!--side bar end-->
    <%@ include file="/WEB-INF/PageSegments/Finance_Management/_cards.jsp" %>
    <div class="row">
   <div class="col-md-6">
         <div class="card mb-3" >
             <div class="card-header" style="color: #003399" >
                 <h5><span class="fa fa fa-area-chart"></span> Sales VS Expenses</h5></div>
             <div class="card-body">
                 <div id="chart_div" style="width: 100%; height: 400px;"></div>

                     <script type="text/javascript">
                     google.charts.load('current', {'packages':['corechart']});
                     google.charts.setOnLoadCallback(drawChart);

                     function drawChart() {
                         var data = google.visualization.arrayToDataTable([
                             ['Year', 'Sales', 'Expenses'],
                             ['2013',  1000,      400],
                             ['2014',  1170,      460],
                             ['2015',  660,       1120],
                             ['2016',  1030,      540]
                         ]);

                         var options = {
                             title: 'Company Performance',
                             hAxis: {title: 'Year',  titleTextStyle: {color: '#003399'}},
                             vAxis: {minValue: 0}
                         };

                         var chart = new google.visualization.AreaChart(document.getElementById('chart_div'));
                         chart.draw(data, options);
                     }
                 </script>

             </div>
            
         </div>
     </div>
     <!--end of the graph  -->	
     
     
     <!-- progress bars starts-->

     <!-- bar charts starts -->
     <div class="col-md-6">
         <div class="card mb-3" >
             <div class="card-header" style="color: #003399" >
                 <h5><span class="fa  fa-bar-chart"></span> Profit Analysis</h5></div>
             <div class="card-body">
                 <script type="text/javascript">
                     google.charts.load("current", {packages:['corechart']});
                     google.charts.setOnLoadCallback(drawChart);
                     function drawChart() {
                         var data = google.visualization.arrayToDataTable([
                             ["Year", "Profit Percentage", { role: "style" } ],
                             ["2014", 8.94, "#b87333"],
                             ["2015", 10.49, "silver"],
                             ["2016", 19.30, "gold"],
                             ["2017", 21.45, "color: #e5e4e2"]
                         ]);

                         var view = new google.visualization.DataView(data);
                         view.setColumns([0, 1,
                             { calc: "stringify",
                                 sourceColumn: 1,
                                 type: "string",
                                 role: "annotation" },
                             2]);

                         var options = {
                             title: "Profit of the latest years",
                             width: 500,
                             height: 300,
                             bar: {groupWidth: "95%"},
                             legend: { position: "none" },
                         };
                         var chart = new google.visualization.ColumnChart(document.getElementById("columnchart_values"));
                         chart.draw(view, options);
                     }
                 </script>
                 <div id="columnchart_values" style="width: 100%; height:100%;"></div>
                 <!-- for more type of charts go to this link :https://developers.google.com/chart/interactive/docs/gallery/table-->
             </div>
            
         </div>
     </div>
     <!-- bar charts ends -->

     </div>
  
     
     <!-- progress bars starts-->

     
     <!-- progress bars end -->
	<!-- Bootstrap tooltips -->
	<script type="text/javascript" src="Styles/js/popper.min.js"></script>
	<!-- Bootstrap core JavaScript -->
	<script type="text/javascript" src="Styles/js/bootstrap.min.js"></script>
	<!-- MDB core JavaScript -->
	<script src="https://maps.googleapis.com/maps/api/js?callback=myMap"></script>

	<script type="text/javascript" src="Styles/js/mdb.min.js"></script>
</body>
</html>

