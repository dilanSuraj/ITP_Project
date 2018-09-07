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


	<div class="row justify-content-end ">
		<div class="col-md-10"
			style="padding-top: 90px; padding-left: 40px; padding-right: 40px">
			<!--center edit start -->

			<!-- forms starts -->

			<div class="col-md-12">
				<div class="card mb-3">
					<div class="card-header" style="color: #003399">
						<h5>
							<span class="fa fa-pencil"></span> Update Supplier Order
							<Item></Item>
						</h5>
					</div>
					<div class="card-body">
						<form action="SupplierOrderRefresh">
							<div class="form-row">
								<div class="form-group col-md-5">
									<select id="Supplier" class="form-control" name="SupplierID">
										<option selected>Choose Supplier...</option>
										<c:forEach var="SupplierList" items="${SupplierList}"
											varStatus="loopCounter">
											<option value="${SupplierList.getSupplier_ID()}">${SupplierList.getSupplier_name()}</option>
										</c:forEach>
									</select>
								</div>
								<div>

									<button type="submit" class="btn btn-primary"
										style="width: 90px;">
										<i class="fa fa-refresh" aria-hidden="true"></i> Refresh
									</button>
								</div>
							</div>
						</form>
						<div class="container">
							<table id="cart" class="table table-hover table-condensed">
								<thead>
									<tr>
										<th style="width: 45%">Product</th>
										<th style="width: 12%">Currnet Order</th>
										<th style="width: 12%">New Quantity</th>
										<th style="width: 10%"></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="SupplierOrderItems"
										items="${SupplierOrderItems}" varStatus="loopCounter">
										<tr>
											<td data-th="Product">
												<div class="row">
													<div class="col-sm-9">
														<h5 class="nomargin">${SupplierOrderItems.getSupplier_order_item_Name()}</h5>
													</div>
												</div>
											</td>
											<td data-th="currentAmount">${SupplierOrderItems.getSupplier_order_item_Amount()}</td>
											<form action="SOrderitemUpdate" name="">
												<td data-th="Quantity"><input type="number"
													class="form-control text-center"
													name="supplier_order_item_Amount"></td> 
													<input type="hidden"
													value="${SupplierOrderItems.getSupplier_order_ItemID()}"
													name="supplier_order_ItemID" />
													
													<input type="hidden"
													value="${SupplierOrderItems.getSupplier_order_ID()}"
													name="supplier_order_ID" />
												
												<td class="actions" data-th="">
													<button class="btn btn-info" type="submit">
														</i>Update
													</button>
												</td>

											</form>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>

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

