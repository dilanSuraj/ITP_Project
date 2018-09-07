<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!--  jQuery -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.11.3.min.js"></script>

<!-- Isolated Version of Bootstrap, not needed if your site already uses Bootstrap -->
<link rel="stylesheet"
	href="https://formden.com/static/cdn/bootstrap-iso.css" />

<!-- Bootstrap Date-Picker Plugin -->
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css" />

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



	<%@ include
		file="/WEB-INF/PageSegments/Finance_Management/_navigationheader.jsp"%>
	<!-- end of the navigation header-->

	<!-- side bar starts -->

	<!-- only visibale in 10'0 inch or above screens-->
	<%@ include
		file="/WEB-INF/PageSegments/Finance_Management/_sidebar.jsp"%>

	<!--side bar end-->

	<%@ include file="/WEB-INF/PageSegments/Finance_Management/_cards.jsp"%>
	
			<div class="col-md-12">
				<div class="card mb-3">
					<div class="card-header" style="color: #003399">
						<h5>
							<span class="fa fa-pencil"></span> Add Other Income Details
						</h5>
					</div>
					<div class="card-body">

						<form:form method="post" action="AddIncome_post"
							modelAttribute="payment">
							<div class="form-group col-md-4">
								<div class="row">
									<label for="inputState">Select Income Category</label>
									<form:select id="inputState" class="form-control"
										path="other_income_expense_category" required="true">										
										<form:option value="Sold Property">Sold property</form:option>
										<form:option value="Other">Other Income</form:option>
									</form:select>
								</div>
							</div>

							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="input_supp_name">Description</label>
									<form:input type="text" class="form-control"
										path="other_income_expense_description"
										placeholder="Enter description" required="true"></form:input>
								</div>
							</div>

							<div class="form-group">
								<label for="input_amt">Total Amount</label>
								<form:input type="text" class="form-control"
									path="other_income_expense_amount"
									placeholder="Enter the amount here" required="true"></form:input>
							</div>

							<div class="form-group">
								<label for="input_amt">Received Amount</label>
								<form:input type="text" class="form-control"
									path="other_income_expense_recieved"
									placeholder="Enter the amount here" required="true"></form:input>
							</div>

							<fieldset class="form-group">
								<div class="row">
									<div class="form-group col-md-4">

										<label for="inputState">Select Income Status</label>
										<form:select id="inputState" class="form-control"
											path="other_income_expense_paymentstate" required="true">
											
											<form:option value="Full">Full Payment Received</form:option>
											<form:option value="Advanced">Advanced Payment Received</form:option>
											<form:option value="None">No Payment Received</form:option>
										</form:select>
									</div>
								</div>
							</fieldset>

							<div class="form-row">


								<div>
									<div class="form-group">
										<!-- Date input -->
										<label class="control-label" for="date">Date(DD/MM/YYY)</label>
										<form:input class="form-control" id="date" name="date"
											path="other_income_expense_date" placeholder="DD/MM/YYY"
											type="text" required="true" />
									</div>
								</div>
							</div>

							<button type="submit" class="btn btn-success" name="add_payment">Add
								Income</button>
							<button type="reset" class="btn btn-danger" >Reset</button>
							
						</form:form>
					</div>
				</div>
			</div>


			<!-- forms ends-->

			<!-- data table end -->

			<!-- Bootstrap tooltips -->
			<script type="text/javascript" src="Styles/js/popper.min.js"></script>
			<!-- Bootstrap core JavaScript -->
			<script type="text/javascript" src="Styles/js/bootstrap.min.js"></script>
			<!-- MDB core JavaScript -->
			<script src="https://maps.googleapis.com/maps/api/js?callback=myMap"></script>

			<script type="text/javascript" src="Styles/js/mdb.min.js"></script>
			<script src="Styles/js/bootstrap-datepicker.js"></script>
</body>
</html>

