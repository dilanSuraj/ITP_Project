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
<!-- Your custom styles (optional) -->
<link rel="stylesheet" href="Styles/css/customStyle.css">

<!-- font awesome icon pack-->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<title>Sumith Tyres pvt Ltd</title>
</head>

<body>

	<br>
	<br>
	<center>
		<div class="col-md-12 col-sm-10 col-10">
			<form:form action="Register_POST" method="post"
				modelAttribute="retailer">
				<img class="mb-4" src="Styles/Images/logo%20-%20colour.png"
					style="height: 250px; width: auto">

				<div class="card-header">
					<h3>Please Sign Up</h3>
					</br>
					</br>


					<h5>Contact</h5>
					<div class="form-column">
						<div class="form-group col-md-6">
							<label for="inputEmail4">Contact Name</label>
							<form:input type="text" class="form-control" path="retailer_name"
								placeholder="Contact Name" required="True"></form:input>
						</div>
						<div class="form-group col-md-6">
							<label for="inputEmail4">Telephone Number</label>
							<form:input type="text" class="form-control"
								placeholder="0714578954" path="retailer_contactno" required="True"></form:input>
						</div>
						<div class="form-group col-md-6">
							<label for="inputPassword4">Registered Number</label>
							<form:input type="text" class="form-control"
								placeholder="Reg number" path="retailer_regno" required="True"></form:input>
						</div>
						<div class="form-group col-md-6 ">
							<label for="inputAddress">Shop Address</label>
							<form:input type="text" class="form-control"
								placeholder="1234 Main St" path="retailer_address" required="True"></form:input>
						</div>
						<div class="form-group col-md-6 ">
							<label for="inputAddress">Username</label>
							<form:input type="text" class="form-control"
								placeholder="Eshan A.M.N" path="retailer_username" required="True"></form:input>
						</div>
						<div class="form-group col-md-6">
							<label for="inputEmail4">Password</label>
							<form:input type="password" class="form-control"
								placeholder="Password" path="retailer_password" required="True"></form:input>
						</div>
						<div class="form-group col-md-6">
							<label for="inputEmail4">Confirm Password</label> <input
								type="password" class="form-control"
								placeholder="Confirm Password" required="True">
						</div>
						<div class="form-group col-md-6">
							<label for="inputState">Province</label>
							<form:select id="inputState" class="form-control"
								path="retailer_province" required="True">
								<option selected>Choose...</option>
								<option>Northern</option>
								<option>North Western</option>
								<option>Western</option>
								<option>North Central</option>
								<option>Central</option>
								<option>Sabaragamuwa</option>
								<option>Eastern</option>
								<option>Uva</option>
								<option>Southern</option>
							</form:select>
						</div>
					</div>
				<button type="submit" class="btn btn-primary active">
					<span class="fa fa-sign-in"> Sign Up 
				</button>
				<button type="button" class="btn btn-primary active">
					<span class="	fa fa-sign-out"> Cancel 
				</button>


			</form:form>
		</div>
	</center>
	<!-- forms ends-->






</body>

</html>