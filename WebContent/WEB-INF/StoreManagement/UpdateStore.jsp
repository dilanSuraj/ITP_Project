<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

	<!--side bar start-->

	<%@include file="/WEB-INF/StockManagement/StoreDashboardNavBar.jsp"%>
	<!--side bar end-->

	<div class="row justify-content-end ">
		<div class="col-md-10"
			style="padding-top: 90px; padding-left: 40px; padding-right: 40px">
			<!--center edit start -->

			<!-- top 4 cards starts -->
			<div class="row">
				<div class="col-xl-3 col-sm-6 mb-3">
					<div class="card text-white  o-hidden h-100"
						style="background-color: #003399">
						<div class="card-body">
							<div class="card-body-icon">
								<i class="fa fa-truck"></i>
							</div>
							<div class="mr-5">Available Stores</div>
						</div>
						<a class="card-footer text-white clearfix small z-1" href="#">
							<span class="float-left">View Details</span> <span
							class="float-right"> <i class="fa fa-angle-right"></i>
						</span>
						</a>
					</div>
				</div>
				<div class="col-xl-3 col-sm-6 mb-3">
					<div class="card text-white bg-warning o-hidden h-100">
						<div class="card-body">
							<div class="card-body-icon">
								<i class="fa fa-fw fa-list"></i>
							</div>
							<div class="mr-5">Out of Store</div>
						</div>
						<a class="card-footer text-white clearfix small z-1" href="#">
							<span class="float-left">View Details</span> <span
							class="float-right"> <i class="fa fa-angle-right"></i>
						</span>
						</a>
					</div>
				</div>
				<div class="col-xl-3 col-sm-6 mb-3">
					<div class="card text-white bg-success o-hidden h-100">
						<div class="card-body">
							<div class="card-body-icon">
								<i class="fa fa-trash-o"></i>
							</div>
							<div class="mr-5">Damaged Store</div>
						</div>
						<a class="card-footer text-white clearfix small z-1" href="#">
							<span class="float-left">View Details</span> <span
							class="float-right"> <i class="fa fa-angle-right"></i>
						</span>
						</a>
					</div>
				</div>
				<div class="col-xl-3 col-sm-6 mb-3">
					<div class="card text-white bg-danger o-hidden h-100">
						<div class="card-body">
							<div class="card-body-icon">
								<i class="fa fa-fw fa-support"></i>
							</div>
							<div class="mr-5">Company</div>
						</div>
						<a class="card-footer text-white clearfix small z-1" href="#">
							<span class="float-left">View Details</span> <span
							class="float-right"> <i class="fa fa-angle-right"></i>
						</span>
						</a>
					</div>
				</div>
			</div>
			<!--top 4 cards end-->

			<!-- topic bar starts-->



			<!-- topic bar end-->


			<!-- start icons -->

			<!-- cards starts-->
			<div class="col-md-12">
				<div class="card mb-3">
					<div class="card-header" style="color: #003399">
						<h5>
							<span class="fa fa-refresh"></span>Update Store
						</h5>
					</div>
					<div class="card-body">

						<div class="card-deck">

							<!-- data table start -->


							<div class="col-md-12">
								<div class="card mb-3">
									<!--    <div class="card-header" style="color: #003399" >
                 <h5><span class="fa fa-image"></span> Cards </h5></div>
             <div class="card-body"> 
          -->
									<script>
										$(document).ready(function() {
											$('#example').DataTable();
										});
									</script>

									<table id="example" class="table table-striped table-bordered"
										style="width: 100%">
										<table id="example" class="table table-striped table-bordered"
											style="width: 100%">

											<form:form method="post" action="UpdateStore_Post"
												modelAttribute="store">



												<div class="form-group">
													<!--  -->

													<h3>
														<small> ${store.getStore_name()} </small>
													</h3>

													<form:input type="hidden" path="store_ID" />

													<!-- 
													<label for="inputAddress">Stock Store Name</label>
													<form:select
														id="Store" class="form-control" path="store_ID">
														<option selected>Choose Item...</option>
														<c:forEach var="storeList" items="${storeList}"
															varStatus="loopCounter">
															<option value="${storeList.getStore_ID()}">${storeList.getStore_name()}</option>
														</c:forEach>
													</form:select>
													 -->

													<div class="form-group">
														<label for="inputAddress">Store Address</label>

														<form:input type="text" class="form-control"
															path="store_address" placeholder=""></form:input>
													</div>

													<div class="form-group">
														<label for="inputAddress">Store Staff Employee
															Name</label>

														<form:select id="PermanentEmployee" class="form-control"
															path="store_staff_emp_ID">
															<option selected>Choose Item...</option>
															<c:forEach var="employeeList" items="${employeeList}"
																varStatus="loopCounter">
																<option value="${employeeList.getId()}">${employeeList.getFullname()}</option>
															</c:forEach>
														</form:select>
													</div>












													<button type="submit" class="btn btn-primary">Update</button>
											</form:form>

										</table>

									</table>

								</div>

								<!-- data table end -->

							</div>



						</div>
					</div>



				</div>

			</div>
		</div>

		<!-- start icons -->
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

