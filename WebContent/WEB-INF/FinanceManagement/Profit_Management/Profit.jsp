<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
<link rel="stylesheet" href="Styles/css/dataTables.bootstrap4.min.css">

<title>Sumith Tyres pvt Ltd</title>
</head>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
    
    <style type="text/css">
        .labels {
            font-size: smaller;
        }
    </style>

 <script type="text/javascript">
        $(document).ready(
            function () {
                var source = {
                    datatype: "json",
                    datafields: [{
                        name: 'year',
                        type: 'int'
                    }, {
                        name: 'income',
                        type: 'double'
                    }],
                    url: '$/Profit',
                    type: 'POST',
                    async: true
                };
                var dataAdapter = new $.jqx.dataAdapter(source);
                var settings = {
                    title: "Availability of Products",
                    description: "in Category 1",
                    padding: {
                        left: 5,
                        top: 5,
                        right: 15,
                        bottom: 5
                    },
                    titlePadding: {
                        left: 90,
                        top: 0,
                        right: 0,
                        bottom: 10
                    },
                    source: dataAdapter,
                    xAxis: {
                        dataField: 'year',
                        displayText: 'Year',
                        gridLines: {
                            visible: true
                        },
                        valuesOnTicks: false,
                        type: 'basic',
                        labels: {
                            class: 'labels',
                            angle: 90,
                            formatFunction: function (value) {
                                return value.replace(/\?/g, '');
                            }
                        },
                        flip: false
                    },
                    colorScheme: 'scheme01',
                    seriesGroups: [{
                        type: 'column',
                        columnsGapPercent: 30,
                        seriesGapPercent: 0,
                        orientation: 'horizontal',
                        valueAxis: {
                            minValue: 0,
                            unitInterval: 10,
                            description: 'income',
                            flip: true
                        },
                        series: [{
                            dataField: 'income',
                            displayText: 'income'
                        }]
                    }]
                };
                $('#chartContainer').jqxChart(settings);
            });
    </script>
<body>


	<!-- start of the the navigation header-->

	<%@ include
		file="/WEB-INF/PageSegments/Finance_Management/_navigationheader.jsp"%>
	<!-- end of the navigation header-->

	<!-- side bar starts -->

	<!-- only visibale in 10'0 inch or above screens-->
	<%@ include
		file="/WEB-INF/PageSegments/Finance_Management/_sidebar.jsp"%>

	<!--side bar end-->
	<%@ include file="/WEB-INF/PageSegments/Finance_Management/_cards.jsp"%>

	<!-- topic bar starts-->

	<ol class="breadcrumb" style="margin-top: 10px; margin-bottom: 10px">
		<li class="breadcrumb-item"><a href="#" style="color: #003399">Profit</a>
		</li>
	</ol>

	<!-- topic bar end-->
	<!--graph start -->
	<div class="col-md-12">
		<div class="card mb-3">
			<div class="card-header" style="color: #003399">
				<h5>
					<span class="fa fa fa-area-chart"></span> Sales VS Expenses
				</h5>
			</div>
			<div class="card-body">
				<div id="chartContainer" style="width: 100%; height: 400px;"></div>

				

			</div>

		</div>
	</div>
	<!--end of the graph  -->


	<!-- progress bars starts-->

	<div class="col-md-12">
		<div class="card mb-3">
			<div class="card-header" style="color: #003399">
				<h5>
					<span class="fa fa-spinner"></span> Profit Analysis
				</h5>
			</div>
			<div class="card-body">
				<div class="row">
					<!-- Blue -->
					<div class="col-md-6">
						<h6>Progress Bar 1</h6>
						<div class="progress">
							<div class="progress-bar" style="width: 10%"></div>
						</div>
					</div>
					<br>
					<!-- Green -->
					<div class="col-md-6">
						<h6>Progress Bar 2</h6>
						<div class="progress">
							<div class="progress-bar bg-success" style="width: 20%"></div>
						</div>
					</div>
					<br>
					<!-- Turquoise -->
					<div class="col-md-6">
						<h6>Progress Bar 3</h6>
						<div class="progress">
							<div class="progress-bar bg-info" style="width: 30%"></div>
						</div>
					</div>
					<br>
					<!-- Orange -->
					<div class="col-md-6">
						<h6>Progress Bar 4</h6>
						<div class="progress">
							<div class="progress-bar bg-warning" style="width: 40%"></div>
						</div>
					</div>
					<br>

					<!-- Red -->
					<div class="col-md-6">
						<h6>Progress Bar 5</h6>
						<div class="progress">
							<div class="progress-bar bg-danger" style="width: 50%"></div>
						</div>
					</div>
					<br>

					<!-- White -->
					<div class="col-md-6">
						<h6>Progress Bar 6</h6>
						<div class="progress border">
							<div class="progress-bar bg-white" style="width: 60%"></div>
						</div>
					</div>


					<!-- Grey -->
					<div class="col-md-6">
						<h6>Progress Bar 6</h6>
						<div class="progress">
							<div class="progress-bar bg-secondary" style="width: 70%"></div>
						</div>
					</div>
					<br>

					<!-- Light Grey -->
					<div class="col-md-6">
						<h6>Progress Bar 7</h6>
						<div class="progress border">
							<div class="progress-bar bg-light" style="width: 80%"></div>
						</div>
					</div>
					<br>
					<!-- Dark Grey -->
					<div class="col-md-6">
						<h6>Progress Bar 8</h6>
						<div class="progress">
							<div class="progress-bar bg-dark" style="width: 90%"></div>
						</div>
					</div>


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

