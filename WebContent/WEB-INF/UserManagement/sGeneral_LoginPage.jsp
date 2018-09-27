<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
		<div class="col-md-4 col-sm-10 col-10">

			
			<form:form class="form-signin" method="post" action="sloginPOST" modelAttribute="supplier">
				<img class="mb-4" src="Styles/Images/logo%20-%20colour.png"
					style="height: 250px; width: auto">
				<h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
				<br> 
				<label for="inputEmail" class="sr-only">Username</label> 
					<form:input type="text"  path="supplier_username" class="form-control"
					placeholder="Username" ></form:input>
					<br> 
					<label
					for="inputPassword" class="sr-only">Password</label> 
					<form:input
					type="password"  path="supplier_password" class="form-control"
					placeholder="Password" ></form:input>
					 <br>
				<div class="checkbox mb-3">
					<label> <input type="checkbox" value="remember-me">
						Remember me
					</label>
				</div>
				<br>
				<button class="btn btn-lg btn-primary btn-block" type="submit"
					style="background-color: #003399">
					<span class="fa fa-sign-in"> </span> Sign In
				</button>
				<p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>
			</form:form>

			



		</div>
		</center>
	
</html>