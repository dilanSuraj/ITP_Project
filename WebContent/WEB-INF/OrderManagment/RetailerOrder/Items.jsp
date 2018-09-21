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

<!-- font awesome icon pack-->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


<script type="text/javascript" src="Styles/js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="Styles/js/pagination.js"></script>

<title>Sumith Tyres pvt Ltd</title>
</head>

<body>


	<%@include
		file="/WEB-INF/OrderManagment/RetailerOrder/RetailerDashbordnavBar.jsp"%>

	<div class="row justify-content-end ">
		<div class="col-md-10"
			style="padding-top: 90px; padding-left: 40px; padding-right: 40px">
			<!--center edit start -->

			<div class="container" id="jar">
				<c:forEach var="tyerList" items="${tyerList}"
					varStatus="loopCounter">

					<div class="row mx-auto content">
						<div class="col">

							<center>
							<div class="row">
								<div class="col-sm-4" align="right">
									<img src="http://via.placeholder.com/350x150">
								</div>
								<div class="col-sm-6"  align="left">
									<h2><small>
										<a
											href="<c:url value='/ShoppingItem?itemNo=${tyerList.getItem_itemcode()}' />"
											style="text-decoration: none;">
											${tyerList.getItem_name()}</a>
									</small></h2>
									
									<h4><small>Rs.${tyerList.getItem_saleprice()}0</small></h4>
								</div>
								</div>
							</center>

						</div>
					</div>
					<br>
				</c:forEach>
			</div>


			<div style="margin-top: 20px">
				<nav>
					<ul class="pagination justify-content-center pagination-sm">
					</ul>
				</nav>
			</div>

			<!-- Bootstrap tooltips -->
			<script type="text/javascript" src="js/popper.min.js"></script>
			<!-- Bootstrap core JavaScript -->
			<script type="text/javascript" src="js/bootstrap.min.js"></script>
			<!-- MDB core JavaScript -->
			<script src="https://maps.googleapis.com/maps/api/js?callback=myMap"></script>

			<script type="text/javascript" src="js/mdb.min.js"></script>
</body>
</html>