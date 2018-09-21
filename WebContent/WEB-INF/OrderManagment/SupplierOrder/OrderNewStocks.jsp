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



	<%@ include
		file="/WEB-INF/PageSegments/Finance_Management/_navigationheader.jsp"%>
	<%@ include
		file="/WEB-INF/PageSegments/Finance_Management/_sidebar.jsp"%>

	<div class="row justify-content-end ">
		<div class="col-md-10"
			style="padding-top: 90px; padding-left: 40px; padding-right: 40px">
			<!--center edit start -->

			<div class="card-body">

				<script>
					$(document).ready(function() {
						$('#example').DataTable();
					});
				</script>

				<table id="example" class="table table-striped table-bordered"
					style="width: 100%">

					<thead>
						<tr>
							<th>Item ID</th>
							<th>Item Name</th>
							<th>Item gross price</th>
							<th>Supplier</th>
							<th></th>



						</tr>
					</thead>
					<tbody>

						<c:forEach var="Items" items="${Items}" varStatus="status">
							<tr>

								<td>${Items.getItem_itemcode()}</td>
								<td>${Items.getItem_name()}</td>
								<td>${Items.getItem_grossprice()}</td>
								<td>${Items.getSupplier_Name()}</td>


								<td>
								
								<form action="SelectedItem">
								
								<input type="hidden" name="item_itemcode" value="${Items.getItem_itemcode()}" />
								<input type="hidden" name="item_type" value="${Items.getItem_type()}" />
								<input type="hidden" name="item_name" value="${Items.getItem_name()}" />
								<input type="hidden" name="item_saleprice" value="${Items.getItem_saleprice()}" />
								<input type="hidden" name="item_grossprice" value="${Items.getItem_grossprice()}" />
								<input type="hidden" name="item_supplier_ID" value="${Items.getItem_supplier_ID()}" />
								<input type="hidden" name="Supplier_Name" value="${Items.getSupplier_Name()}" />
								<button style=" border:none;
											    color: blue;
											    background:none;
											    border: none;
											    padding: 0;
											    font: inherit;
											    cursor: pointer;
											    outline: inherit;
											    " type="submit">Order New</button>
							
								</form> 
								</td>

							
							</tr>
						</c:forEach>
					</tbody>
				</table>
				</div>
</div>
</div>
					<!-- Bootstrap tooltips -->
					<script type="text/javascript" src="Styles/js/popper.min.js"></script>
					<!-- Bootstrap core JavaScript -->
					<script type="text/javascript" src="Styles/js/bootstrap.min.js"></script>
					<!-- MDB core JavaScript -->
					<script
						src="https://maps.googleapis.com/maps/api/js?callback=myMap"></script>

					<script type="text/javascript" src="Styles/js/mdb.min.js"></script>
</body>
</html>

