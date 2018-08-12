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


<link href="Styles/css/customText.css" rel="stylesheet">
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

	<!-- start of the the navigation header-->

    <%@ include file="/WEB-INF/PageSegments/_navigationheader.jsp" %>
	<!-- end of the navigation header-->

	<!-- side bar starts -->

	<!-- only visibale in 10'0 inch or above screens-->
	<%@ include file="/WEB-INF/PageSegments/_sidebar.jsp" %>

	<!--side bar end-->
    <%@ include file="/WEB-INF/PageSegments/_cards.jsp" %>

			<!--top 4 cards end-->
			<!--top 4 cards end-->

			<!-- topic bar starts-->

			<ol class="breadcrumb" style="margin-top: 10px; margin-bottom: 10px">
				</li>
			</ol>

			<!-- topic bar end-->
			   <!--graph start -->
     <div class="col-md-12">
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

         <div class="card mb-3" >
             <div class="card-header" style="color: #003399" >
                 <h5><span class="fa fa-spinner"></span> Profit Analysis</h5></div>
             <div class="card-body">
                 <!-- Blue -->
                 <h6>Progress Bar 1</h6>
                 <div class="progress">
                     <div class="progress-bar" style="width:10%"></div>
                 </div>
                 <br>
                 <!-- Green -->
                 <h6>Progress Bar 2</h6>
                 <div class="progress">
                     <div class="progress-bar bg-success" style="width:20%"></div>
                 <br>
                 <!-- Turquoise -->
                 <h6>Progress Bar 3</h6>
                 <div class="progress">
                     <div class="progress-bar bg-info" style="width:30%"></div>
                 <br>
                 <!-- Orange -->
                 <h6>Progress Bar 4</h6>
                 <div class="progress">
                     <div class="progress-bar bg-warning" style="width:40%"></div>
                 <br>

                 <!-- Red -->
                 <h6>Progress Bar 5</h6>
                 <div class="progress">
                     <div class="progress-bar bg-danger" style="width:50%"></div>
                 </div>
                 <br>

                 <!-- White -->
                 <h6>Progress Bar 6</h6>
                 <div class="progress border">
                     <div class="progress-bar bg-white" style="width:60%"></div>


                 <!-- Grey -->
                 <h6>Progress Bar 6</h6>
                 <div class="progress">
                     <div class="progress-bar bg-secondary" style="width:70%"></div>
                 <br>

                 <!-- Light Grey -->
                 <h6>Progress Bar 7</h6>
                 <div class="progress border">
                     <div class="progress-bar bg-light" style="width:80%"></div>
                 <br>
                 <!-- Dark Grey -->
                 <h6>Progress Bar 8</h6>
                 <div class="progress">
                     <div class="progress-bar bg-dark" style="width:90%"></div>


             </div>
           
         </div>
     </div>
     <!-- progress bars end -->
     
     
	</div>
	</div>
	<!-- Bootstrap tooltips -->
	<script type="text/javascript" src="Styles/js/popper.min.js"></script>
	<!-- Bootstrap core JavaScript -->
	<script type="text/javascript" src="Styles/js/bootstrap.min.js"></script>
	<!-- MDB core JavaScript -->
	<script src="https://maps.googleapis.com/maps/api/js?callback=myMap"></script>

	<script type="text/javascript" src="Styles/js/mdb.min.js"></script>



</body>
</html>

