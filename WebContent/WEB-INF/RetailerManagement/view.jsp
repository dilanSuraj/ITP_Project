<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
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

<!--Scrollspy-->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<title>Sumith Tyres pvt Ltd</title>
</head>

<body>


	<!-- start of the the navigation header-->

	<nav class="navbar fixed-top navbar-expand-lg navbar-dark"
		style="background-color: #003399; color: white">
		<a class="navbar-brand " href="#" style="padding-right: 3%"> <img
			class="logo" src="Images/logo.png" alt="Home"></a>
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
					<li class="nav-item "><a class="nav-link" href="#"
						style="color: white"> <span class="fa fa-home "
							style="font-size: 18px"></span> Home
					</a></li>

					<li class="nav-item"><a class="nav-link" href="#"
						style="color: white"><span class="fa fa-history "
							style="font-size: 18px"></span> Order History</a></li>

					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><span
							class="fa fa-sitemap " style="font-size: 18px"></span> Items </a>
						<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
							<a class="dropdown-item" href="#" style="color: black">Tyres</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="#" style="color: black">Battery</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="#" style="color: black">Alloy
								Wheel</a>
						</div></li>

					<li class="nav-item"><a class="nav-link" href="#"
						style="color: white"><span class="fa fa-shopping-cart "
							style="font-size: 18px"></span> Cart</a></li>

					<li class="nav-item"><a class="nav-link " href="#"
						style="color: white"><span class="fa fa-user-plus"
							style="font-size: 18px"></span> Profile Settings</a></li>

					<li class="nav-item"><a class="nav-link" href="#"
						style="color: white"><span class="fa fa-money"
							style="font-size: 18px"></span> Payment</a></li>
				</div>

				<!-- end of side bar links to nav bar -->



				<li class="nav-item"><a href="#" class="admin-name">Admin
						Name</a></li>




				<li class="nav-item">
					<button type="button" class="btn btn-dark btn-sm ">
						<span class="fa fa-key"></span> Logout
					</button>
				</li>



			</ul>
		</div>

	</nav>
	<!-- end of the navigation header-->

	<!-- side bar starts -->

	<!-- only visibale in 10'0 inch or above screens-->
	<div class="col-md-2 position-fixed d-none d-md-block"
		style="background-color: #003399; height: 100%; padding-top: 60px;">
		<nav class="navbar  navbar-expand-lg navbar-dark"
			style="padding-top: 30px; padding-left: 0%">


			<ul class="nav flex-column sidbar-items">
				<li></li>

				<li class="nav-item active"><a class="nav-link" href="#"> <span
						class="fa fa-home " style="font-size: 18px"></span> Home
				</a></li>

				<li class="nav-item"><a class="nav-link" href="#"><span
						class="fa fa-history " style="font-size: 18px"></span> Order
						History</a></li>

				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><span
						class="fa fa-sitemap " style="font-size: 18px"></span> Items </a>
					<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
						<a class="dropdown-item" href="#" style="color: black">Tyres</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#" style="color: black">Battery</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#" style="color: black">Alloy
							Wheel</a>
					</div></li>

				<li class="nav-item"><a class="nav-link " href="#"><span
						class="fa fa-shopping-cart" style="font-size: 18px"></span> Cart</a></li>
				<li class="nav-item"><a class="nav-link " href="#"><span
						class="fa fa-user-plus" style="font-size: 18px"></span> Profile
						Settings</a></li>

				<li class="nav-item"><a class="nav-link " href="#"><span
						class="fa fa-money" style="font-size: 18px"></span> Payment</a></li>
			</ul>

		</nav>
	</div>

	<!--side bar end-->

	<div class="row justify-content-end ">
		<div class="col-md-10"
			style="padding-top: 90px; padding-left: 40px; padding-right: 40px">
			<!--center edit start -->

			<!-- forms starts -->

			<div class="col-md-12">
				<div class="card mb-3">
					<div class="card-header" style="color: #003399">
						<h5>
							<span class="fa fa-pencil"></span> Update Profile
						</h5>
					</div>
					<div class="card-body">

						<form:form mothod="post" action="Update_Retailer_Post1"
							modelAttribute="Retailer">


							<form:input type="hidden" 
										path="retailer_ID"  />

							<div class="form-column">
								<div class="form-group col-md-12">
									<label for="inputEmail4"><b>Contact Name</b></label>
									<form:input type="text" class="form-control" id="inputFirstl4"
										path="retailer_name" required="True" />
								</div>
								<div class="form-group col-md-12">
									<label for="inputEmail4"><b>Telephone Number</b></label>
									<form:input type="text" class="form-control" id="inputFirstl4"
										path="retailer_contactno" required="True" />
								</div>
								<div class="form-group col-md-12">
									<label for="inputPassword4"><b>Registered Number</b></label>
									<form:input type="text" class="form-control" id="inputLast4"
										path="retailer_regno" required="True" />
								</div>
								<div class="form-group col-md-12">
									<label for="inputEmail4"><b>Shop Address</b></label>
									<form:input type="text" class="form-control" id="inputFirstl4"
										path="retailer_address" required="True" />
								</div>
								<div class="form-group col-md-12">
									<label for="inputEmail4"><b>Username</b></label>
									<form:input type="text" class="form-control" id="inputFirstl4"
										path="retailer_username" required="True" />
								</div>
								<div class="form-group col-md-12">
									<label for="inputEmail4"><b>Password</b></label>
									<form:input type="text" class="form-control" id="inputFirstl4"
										path="retailer_password" required="True" />
								</div>
								<div class="form-group col-md-12">
									<label for="inputState"><b>Province</b></label>
									<form:input type="text" class="form-control" id="inputState"
										path="retailer_province" required="True" />

								</div>
							</div>

							<button type="submit" class="btn btn-primary">Update</button>
							</br>
							
						</form:form>
					</div>
				</div>
			</div>
			<!-- forms ends-->


			<!-- Bootstrap tooltips -->
			<script type="text/javascript" src="js/popper.min.js"></script>
			<!-- Bootstrap core JavaScript -->
			<script type="text/javascript" src="js/bootstrap.min.js"></script>
			<!-- MDB core JavaScript -->
			<script src="https://maps.googleapis.com/maps/api/js?callback=myMap"></script>

			<script type="text/javascript" src="js/mdb.min.js"></script>
</body>
</html>
