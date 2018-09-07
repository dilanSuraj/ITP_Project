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
<link rel="stylesheet" href="Styles/css/shopping%20cart.css">

<!-- font awesome icon pack-->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">



<script type="Styles/text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="Styles/text/javascript" src="js/paginationList.js"></script>
+

<title>Sumith Tyres pvt Ltd</title>

</head>
<body>
	<%@include
		file="/WEB-INF/OrderManagment/RetailerOrder/RetailerDashbordnavBar.jsp"%>


	<div class="row justify-content-end ">
		<div class="col-md-10"
			style="padding-top: 90px; padding-left: 40px; padding-right: 40px">
			<!--center edit start -->

			<h3>
				<i class="fa fa-shopping-cart" aria-hidden="true"></i> Order No :
				${orderDetails.getRetailer_OrderID()}
			</h3>
			<br>
			<h6>
				<i class="fa fa-calendar-o" aria-hidden="true"></i> <span
					style="padding-left: 3px">Date <span
					style="padding-left: 11px">: ${orderDetails.getDateInString()}
				
			</h6>
			<h6>
				<i class="fa fa-info" aria-hidden="true"></i> <span
					style="padding-left: 12px"> Status :
					${orderDetails.getRetailer_orderstatus()}
			</h6>
			<br>
			<div class="container">
				<table id="cart" class="table table-hover table-condensed">
					<thead>
						<tr>
							<th style="width: 45%">Product</th>
							<th style="width: 15%">Unit Price</th>
							<th style="width: 8%">Quantity</th>
							<th style="width: 22%" class="text-center">Subtotal</th>
							<c:if
								test="${orderDetails.getRetailer_orderstatus()}=='Incomplete'">
								<th style="width: 10%"></th>
							</c:if>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="itemList" items="${itemList}"
							varStatus="loopCounter">
							<tr>
								<td data-th="Product">
									<div class="row">
										<div class="col-sm-3 hidden-xs">
											<img src="http://placehold.it/100x100" alt="..."
												class="img-responsive" />
										</div>
										<div class="col-sm-9">
											<h5 class="nomargin">${itemList.getItemName()}</h5>
										</div>
									</div>
								</td>
								<td data-th="Price">${itemList.getUnitPrice()}</td>
								<td data-th="Quantity">${itemList.getOrderItem_unitscount()}</td>
								<td data-th="Subtotal" class="text-center">${itemList.getOderitem_totalcost()}</td>
								<c:if
									test="${orderDetails.getRetailer_orderstatus()=='Incomplete'}">
									<td class="actions" data-th="">
										<a class="btn btn-danger btn-sm" href="<c:url value='/DeleteOrderItem?orderItemID=${orderDetails.getOrderItem_ID()}' />">
											<i class="fa fa-trash-o" style="color:white"></i>
										</a>
									</td>
								</c:if>
							</tr>
						</c:forEach>



					</tbody>
					<tfoot>
						<tr>

							<td></td>
							<td colspan="2" class="hidden-xs"></td>
							<td class="hidden-xs text-center"><strong>Total Rs.
									${orderDetails.getOder_total()}0</strong></td>

							<c:if
								test="${orderDetails.getRetailer_orderstatus()=='Incomplete'}">
								<td><a class="btn btn-success btn-block"
									href="<c:url value='/checkOutRetailerOrder?orderID=${orderDetails.getRetailer_OrderID()}' />"><i
										class="fa fa-check" aria-hidden="true"></i> Checkout</a></td>
							</c:if>

						</tr>
					</tfoot>
				</table>
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