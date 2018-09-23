<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

<title>Delete Retailer</title>
</head>

<body>


	<!-- start of the the navigation header-->

	<nav class="navbar fixed-top navbar-expand-lg navbar-dark"
		style="background-color: #003399; color: white">
		<a class="navbar-brand " href="#" style="padding-right: 3%"> <img
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
					<li class="nav-item "><a class="nav-link" href="#"
						style="color: white"> <span class="fa fa-pencil-square-o "
							style="font-size: 18px"></span> Home
					</a></li>

					<li class="nav-item"><a class="nav-link"
						href="Add_Retailer_ADMIN" style="color: white"><span
							class="fa fa-plus " style="font-size: 18px"></span> Add Retailer</a>
					</li>

					<li class="nav-item"><a class="nav-link "
						href="Update_Retailer_ADMIN" style="color: white"><span
							class="fa fa-clone" style="font-size: 18px"></span> Update/Delete
							Retailer Profile</a></li>

					<li class="nav-item"><a class="nav-link "
						href="viewFile" style="color: white"><span
							class="fa fa-database" style="font-size: 18px"></span> Delete Requests
							</a></li>


				</div>

				<!-- end of side bar links to nav bar -->



				<li class="nav-item"><a href="#" class="admin-name">Eshan
						A.M.N</a></li>




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

				<li class="nav-item active"><a class="nav-link" href="Retailer"> <span
						class="fa fa-pencil-square-o " style="font-size: 18px"></span>
						Home
				</a></li>

				<li class="nav-item"><a class="nav-link"
					href="Add_Retailer_ADMIN"><span class="fa fa-plus "
						style="font-size: 18px"></span> Add Retailer</a></li>

				<li class="nav-item"><a class="nav-link "
					href="Update_Retailer_ADMIN"><span class="fa fa-clone"
						style="font-size: 18px"></span> Update/Delete Retailer Profile</a></li>
						
				<li class="nav-item"><a class="nav-link "
						href="viewFile" style="color: white"><span
							class="fa fa-database" style="font-size: 18px"></span> Delete Requests
							</a></li>
			</ul>

		</nav>
	</div>

	<!--side bar end-->

	<div class="row justify-content-end ">
		<div class="col-md-10"
			style="padding-top: 0px; padding-left: 0px; padding-right: 0px">
			<!--center edit start -->
			<!-- side bar starts -->
			<div class="row justify-content-end ">
				<div class="col-md-11"
					style="padding-top: 90px; padding-left: 0px; padding-right: 0px">
					<!--center edit start -->
					<div class="row">
						<!-- data table start -->
						<div class="col-md-12">
							<div class="card mb-3">
								<div class="card-header" style="color: #003399">
									<h5>
										<span class="fa fa-group"></span> Retailers
									</h5>
								</div>
								<div class="card-body">

									<script>
										$(document).ready(function() {
											$('#example').DataTable();
										});
									</script>

									<table id="example" class="table table-striped table-bordered"
										style="width: 100%">
										<thead>
											<tr>
												<th>Contact Name</th>
												<th>Telephone Number</th>
												<th>Registered Number</th>
												<th>Shop Address</th>
												<th>Username</th>
												<th>province</th>
												<th>Edit</th>
												<th>Delete</th>

											</tr>
										</thead>
										<tbody>

											<c:forEach var="retailerlist" items="${retailerList}"
												varStatus="status">
												<tr>

													<td>${retailerlist.getRetailer_name()}</td>
													<td>${retailerlist.getRetailer_contactno()}</td>
													<td>${retailerlist.getRetailer_regno()}</td>
													<td>${retailerlist.getRetailer_address()}</td>
													<td>${retailerlist.getRetailer_username()}</td>
													<td>${retailerlist.getRetailer_province()}</td>
													<td><a
														href="<c:url value='/Update_Retailer_Get1?id=${retailerlist.getRetailer_ID()}'/>">
															<button type="button" class="btn btn-success">Edit</button>
													</a></td>
													<td><a
														href="<c:url value='/DeleteRetailer?id=${retailerlist.getRetailer_ID()}'/>">
															<button type="button" class="btn btn-danger">Delete</button>
													</a></td>
												</tr>
											</c:forEach>
										</tbody>
										<tfoot>
											<tr>
												<th>Contact Name</th>
												<th>Telephone Number</th>
												<th>Registered Number</th>
												<th>Shop Address</th>
												<th>Username</th>
												<th>province</th>
												<th>Edit</th>
												<th>Delete</th>

											</tr>
										</tfoot>
									</table>
								</div>
							</div>

							<!-- data table end -->
						</div>
						<!-- /.content-wrapper-->

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