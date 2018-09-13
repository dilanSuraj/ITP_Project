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


	<script type="text/javascript">
		$(window).on('load', function() {
			$('#myModal').modal('show');
		});
	</script>
	


		<!-- Alert to show item added succesfully -->


		<div class="modal hide fade" id="myModal">
			<div class="modal-header">
				<a class="close" data-dismiss="modal">×</a>
				<h3>Item Added to the Cart</h3>
			</div>
			<div class="modal-body">
				<p>One fine body</p>
			</div>
			<div class="modal-footer">
				<a href="#" class="btn">Close</a> <a href="#"
					class="btn btn-primary">Save changes</a>
			</div>
		</div>



	<div class="row justify-content-end ">
		<div class="col-md-10"
			style="padding-top: 90px; padding-left: 40px; padding-right: 40px">
			<!--center edit start -->

			<h3 style="padding-bottom: 10px">Shopping Cart</h3>
			<br>

			<div class="container">
				<table id="cart" class="table table-hover table-condensed">
					<thead>
						<tr>
							<th style="width: 50%">Product</th>
							<th style="width: 10%">Unit Price</th>
							<th style="width: 8%">Quantity</th>
							<th style="width: 10%"></th>
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
											<h5 class="nomargin">${itemList.getItem_name()}</h5>
										</div>
									</div>
								</td>
								<td data-th="Price">${itemList.getItem_saleprice()}</td>

								<form action="RetailerAddToOrder">
									<td data-th="Quantity"><input type="number"
										class="form-control text-center"
										value="${itemList.getItem_amount()}" name="amount"></td>

									<td class="actions" data-th=""><input type="hidden"
										value="${itemList.getItem_itemcode()}" name="itemCode" />
										<button class="btn btn-info btn-sm" type="submit"
											style="width: 120px; margin-top: 2px; background-color: #003399;">
											<i class="fa fa-cart-plus" aria-hidden="true"></i> Add to
											Order
										</button>
								</form>
								<a class="btn btn-danger btn-sm"
									style="width: 120px; margin-top: 2px"
									href="<c:url value='/DeleteCartItem?cartID=${itemList.getCart_ID()}' />"><i
									class="fa fa-trash-o"></i> Remove </a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
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