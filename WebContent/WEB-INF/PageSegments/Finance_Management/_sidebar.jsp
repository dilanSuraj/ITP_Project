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
<link
	href="https://file.myfontastic.com/BFkWJv83N7sbYQwrfx5VGe/icons.css"
	rel="stylesheet">

<link href="Styles/css/customText.css" rel="stylesheet">
<!-- font awesome icon pack-->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link
	href="https://file.myfontastic.com/BFkWJv83N7sbYQwrfx5VGe/icons.css"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<!--java scrip file for google charts-->
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>

<!--google maps library -->
<script
	src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY&callback=myMap"></script>
<link
	href="https://file.myfontastic.com/Mv2opBjoWZTWS4XHUM8BMP/icons.css"
	rel="stylesheet">

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
</head>
<body>
	<div class="col-md-2 position-fixed d-none d-md-block"
		style="background-color: #003399; height: 100%; padding-top: 60px;">
		<nav class="navbar  navbar-expand-lg navbar-dark"
			style="padding-top: 30px; padding-left: 0%">


			<ul class="nav flex-column sidbar-items">
				<li></li>

				<li class="nav-item active"><a class="nav-link"
					href="Finance_Manager"> <span class="fa fa-pencil-square-o "
						style="font-size: 18px"></span> Home
				</a></li>



				<li class="nav-item active"><a class="nav-link"
					href="Retailer_Finance"> <span
						class="fa fa-chevron-circle-right" style="font-size: 18px"></span>
						Retailer Order Payments
				</a></li>

				<li class="nav-item active"><a class="nav-link"
					href="Supplier_Finance"> <span
						class="fa fa-chevron-circle-right" style="font-size: 18px"></span>
						Supply Order Payments
				</a></li>

				<li class="nav-item active"><a class="nav-link"
					href="Payment_Manage"> <span class="fa fa-chevron-circle-right"
						style="font-size: 18px"></span> Other Income and Expense
				</a></li>

				<li class="nav-item active"><a class="nav-link"
					href="Salary_Finace"> <span class="fa fa-chevron-circle-right"
						style="font-size: 18px"></span> Monthly Salary Payments
				</a></li>

				<li class="nav-item active"><a class="nav-link"
					href="Sale_Price"> <span class="fa fa-chevron-circle-right"
						style="font-size: 18px"></span> Set Item Prices
				</a></li>

				<li class="nav-item active"><a class="nav-link"
					href="Retailer_Blacklist"> <span
						class="fa fa-chevron-circle-right" style="font-size: 18px"></span>
						Blacklisted Retailers
				</a></li>

				<li class="nav-item"><a class="nav-link" href="#"><span
						class="fa fa-cog" style="font-size: 18px"></span> My Profile</a></li>

			</ul>

		</nav>
	</div>
</body>
</html>