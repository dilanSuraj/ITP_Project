<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<%@ page import="java.util.*" %>
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

	<%@include
		file="/WEB-INF/OrderManagment/SupplierOrder/storeManagerNavBar.jsp"%>


<c:if test="${Items.getItem_itemcode()== 0}">
								<c:redirect url="orderNewItem"/>
</c:if>

	<div class="row justify-content-end ">
		<div class="col-md-10"
			style="padding-top: 90px; padding-left: 60px; padding-right: 40px">
			<!--center edit start -->


			<!-- forms starts -->
			<br>
			<h3>
				<span class="fa fa-pencil"></span> Order a New Item
			</h3>
			<br>
			<form onsubmit="return confirm('Do you want to order this item ?');" action="placeTheOrder">
				<div class="col-md-12">
					<div class="col-md-5">
					<h5><small>Item <span style="padding-left:50px"></span> : ${Items.getItem_name() }</small></h5>
					<h5><small>Supplier <span style="padding-left:22px"></span>: ${Items.getSupplier_Name()}</small></h5>
					<h5><small>Gross Price<span style="padding-left:2px"></span> : ${Items.getItem_grossprice() }0</small></h5>
					<br>
					<h5><small>Amount</small></h5>
						 
						 
						 <input type="hidden" name="Supplier_ID" value="${Items.getItem_supplier_ID() }"/>
						 <input type="hidden" name="item_code" value="${Items.getItem_itemcode() }"/>
						 
 						 
						 
						 <input type="number"
							class="form-control" id="inputPassword4" placeholder="Amount"
							name="amount">
							
						 <input type="hidden" name="Order_Status" value="Inprocessing"/>
						 <input type="hidden" name="Store_Manager_ID" value="50"/>
					</div>


					<div class="col-12" style="margin-top: 200px">
						<button type="submit" class="btn btn-primary" style="width: 90px">Order</button>
						<a href="orderNewItem" class="btn btn-primary" style="width: 90px">Cancel</a>

					</div>
					</div>
			</form>
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

