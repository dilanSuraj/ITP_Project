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
<link rel="stylesheet" href="Styles/css/customStyle.css">

<!-- font awesome icon pack-->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<title>Sumith Tyres pvt Ltd</title>

</head>
<body>

	<%@ include
		file="/WEB-INF/PageSegments/Finance_Management/_navigationheader.jsp"%>
	<%@ include
		file="/WEB-INF/PageSegments/Finance_Management/_sidebar.jsp"%>

	<%!int user = 50;%>
	<div class="row justify-content-end ">
		<div class="col-md-10"
			style="padding-top: 90px; padding-left: 40px; padding-right: 40px">
			<!--center edit start -->
			
				<div class="col-md-11" style="line-height: 60px;">
					<br>

					<h5>Order No :${order.getSupplier_Order_id()}</h5>
					<h6>Order Date</h6>
					<h6>
						<small>${order.getOrderDate()}</small>
					</h6><br>
					<h3><small>Ordered Item : 
						${order.getItemname() }</small>
					</h3>
					<h3><small>No of Items  <span style="padding-left:16.5px"></span> :
						${order.getAmount()}</small>
					</h3>
<br>
					<h5 style="line-height: 30px">
						<small>Supplier Name <span style="padding-left:42.5px"></span>: ${order.getSupplierName()}</small>
					</h5>
					<h5>
						<small>Current Order Status : ${order.getOrder_Status()}</small>
					</h5>
					<br>
					<center>
					<a
					
					 href="<c:url value='/OrderRecived?OrderId=${order.getSupplier_Order_id()}' />"
					 onclick="return confirm('Did the order Recived to the store ');"
					  class="btn btn-primary" style="width: 140px">Order
						Received</a>
					<div>
						<a href="SupplierOrders">Back</a>
					</div>
					</center>
				</div>

			
		</div>
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