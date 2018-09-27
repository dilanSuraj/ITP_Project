<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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

<!-- font awesome icon pack-->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<title>Sumith Tyres pvt Ltd</title>

</head>
<body>

	<c:if test="${empty retailer}">
		<c:redirect url="login" />
	</c:if>

	<!-- start of the the navigation header-->

	<nav class="navbar fixed-top navbar-expand-lg navbar-dark"
		style="background-color: #003399;color: white"> <a
		class="navbar-brand " href="#" style="padding-right: 3%"> <img
		class="logo" src="Styles/Images/logo.png" alt="Home"></a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNav" aria-controls="navbarNav"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="navbar-collapse collapse w-100 order-3 dual-collapse2"
		id="navbarNav">
		<ul class="navbar-nav ml-auto navbar-icons">

			<!-- side bar items to navigation bar only for the screen sizes below  7'0 tab-->
			<!-- you need to give the same links in the side bar to this links -->

			<div class="d-block d-md-none">
				<li class="nav-item "><a class="nav-link" href="Retailer"
					style="color: white"> <span class="fa fa-home "
						style="font-size: 18px"></span> Home
				</a></li>

				<li class="nav-item"><a class="nav-link" href="RetailerCart"
					style="color: white"><span class="fa fa-history "
						style="font-size: 18px"></span> Order History</a></li>

				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><span
						class="fa fa-sitemap " style="font-size: 18px"></span> Items </a>
					<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
						<a class="dropdown-item" href="tyers" style="color: black">Tyres</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="alloywheel" style="color: black">Battery</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="batteries" style="color: black">Alloy
							Wheel</a>
					</div></li>


				<li class="nav-item"><a class="nav-link" href="RetailerCart"
					style="color: white"><span class="fa fa-shopping-cart "
						style="font-size: 18px"></span> Cart</a></li>

				<li class="nav-item"><a class="nav-link " href="update_GET"
					style="color: white"><span class="fa fa-user-plus"
						style="font-size: 18px"></span> Profile Settings</a></li>

				<li class="nav-item"><a class="nav-link" href="#"
					style="color: white"><span class="fa fa-money"
						style="font-size: 18px"></span> Payment</a></li>
			</div>

			<!-- end of side bar links to nav bar -->



			<li class="nav-item"><a href="update_GET" class="admin-name">Eshan
					A.M.N</a></li>




			<li class="nav-item"><a href="login" button type="button"
				class="btn btn-dark btn-sm "> <span class="fa fa-key"></span>
					Logout
			</a></li>



		</ul>
	</div>

	</nav>
	<!-- end of the navigation header-->

	<!-- side bar starts -->

	<!-- only visibale in 10'0 inch or above screens-->
	<div class="col-md-2 position-fixed d-none d-md-block"
		style="background-color: #003399; height: 100%; padding-top: 60px;">
		<nav class="navbar  navbar-expand-lg navbar-dark"
			style="padding-top: 30px;padding-left:0%">


		<ul class="nav flex-column sidbar-items">
			<li></li>

			<li class="nav-item active"><a class="nav-link" href="Retailer">
					<span class="fa fa-home " style="font-size: 18px"></span> Home
			</a></li>

			<li class="nav-item"><a class="nav-link"
				href="RetailerOrderHistory"><span class="fa fa-history "
					style="font-size: 18px"></span> Order History</a></li>

			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" role="button"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i
					class="fa fa-hand-o-down" aria-hidden="true"></i> Items </a>
				<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
					<a class="dropdown-item" href="tyers" style="color: black">Tyres</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#" style="color: black">Battery</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="alloywheel" style="color: black">Alloy
						Wheel</a>
				</div></li>

			<li class="nav-item"><a class="nav-link " href="RetailerCart"><span
					class="fa fa-shopping-cart" style="font-size: 18px"></span> Cart</a></li>
			<li class="nav-item"><a class="nav-link " href="update_GET"><span
					class="fa fa-user-plus" style="font-size: 18px"></span> Profile
					Settings</a></li>

			<li class="nav-item"><a class="nav-link " href="#"><span
					class="fa fa-money" style="font-size: 18px"></span> Payment</a></li>
		</ul>

		</nav>
	</div>
	<!-- Bootstrap tooltips -->
	<script type="text/javascript" src="Styles/js/popper.min.js"></script>
	<!-- Bootstrap core JavaScript -->
	<script type="text/javascript" src="Styles/js/bootstrap.min.js"></script>
	<!-- MDB core JavaScript -->
	<script src="https://maps.googleapis.com/maps/api/js?callback=myMap"></script>

	<script type="text/javascript" src="Styles/js/mdb.min.js"></script>
	<!--side bar end-->
</body>
</html>