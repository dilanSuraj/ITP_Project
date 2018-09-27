<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>


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

	<%@ include
		file="/WEB-INF/PageSegments/Finance_Management/_navigationheader.jsp"%>
	<!-- end of the navigation header-->

	<!-- side bar starts -->
	<div class="col-md-2 position-fixed d-none d-md-block"
		style="background-color: #003399; height: 100%; padding-top: 60px;">
		<nav class="navbar  navbar-expand-lg navbar-dark"
			style="padding-top: 30px; padding-left: 0%">


			<ul class="nav flex-column sidbar-items">
				<li></li>

				<li class="nav-item active"><a class="nav-link"
					href="StockView"> <span class="fa fa-pencil-square-o "
						style="font-size: 18px"></span> Home
				</a></li>





				<li class="nav-item"><a class="nav-link" href="StockView">
						<span class="fa fa-eye" style="font-size: 18px"> </span> Stock
						View
				</a></li>


				<li class="nav-item"><a class="nav-link" href="StoreView"><span
						class="fa fa-eye" style="font-size: 18px"></span> Store View</a></li>

				<li class="nav-item"><a class="nav-link" href="ItemView"><span
						class="fa fa-eye" style="font-size: 18px"></span> Item View</a></li>
				<li class="nav-item"><a class="nav-link" href="InsertStock"><span
						class="fa fa-plus-square" style="font-size: 18px"></span> Insert
						New Stock</a></li>

				<li class="nav-item"><a class="nav-link" href="InsertStock"><span
						class="fa fa-plus-square" style="font-size: 18px"></span> Insert
						New Store</a></li>
				<li class="nav-item"><a class="nav-link" href="InsertItem"><span
						class="fa fa-plus-square" style="font-size: 18px"></span> Insert
						New Item</a></li>

				<li class="nav-item"><a class="nav-link" href="orderNewItem"><span
						class="fa fa-plus-square" style="font-size: 18px"></span> Order
						New Item</a></li>

				<li class="nav-item"><a class="nav-link" href="SupplierOrders"><span
						class="fa fa-plus-square" style="font-size: 18px"></span> Supplier
						Orders</a></li>

			</ul>

		</nav>
	</div>


</body>
</html>