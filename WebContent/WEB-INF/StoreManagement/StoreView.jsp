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

    <!--side bar end-->
     
    <%@ include file="/WEB-INF/StockManagement/StoreDashboardNavBar.jsp"  %> 

	<!--side bar end-->
	<%@ include file="/WEB-INF/PageSegments/Finance_Management/_cards.jsp"%>


	<!-- topic bar starts-->


	<!-- topic bar end-->


	<!-- start icons -->

	<!-- cards starts-->
	<!-- data table start -->

	<div class="col-md-12">

		<div class="card mb-3">
			<div class="card-header" style="color: #003399">
				<h5>
					<span class="fa fa-image"></span> Other Income details
				</h5>

			</div>
			<!--  Add New Stock button-->

			<a href="InsertStore">
				<div class="pull-right" style="padding-left: 77%; padding-top: 30px">

					<button class="btn btn-success" data-toggle="modal"
						data-target="#create-user" style="margin-right: 20px">+
						Add New Store
				</div>
			</a>

			<!-- End of the Button -->
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
							<th>Store Name</th>
							<th>Store Address</th>
							<th>Store Staff Employee ID</th>
							<th>Edit</th>
							<th>Delete</th>



						</tr>
					</thead>
					<tbody>

						<c:forEach var="storeList" items="${storeList}" varStatus="status">
							<tr>
								<td>${storeList. getStore_name()}</td>
								<td>${storeList.getStore_address()}</td>
								<td>${storeList.getStaff_name()}</td>


								<td><a
									href="<c:url value='/UpdateStore_Get?id=${storeList.getStore_ID()}' />"
									class="btn btn-warning">EDIT</a></td>

								<td><a
									href="<c:url value='/DeleteStore?id=${storeList.getStore_ID()}' />"
									class="btn btn-danger">DELETE</a></td>
							</tr>
						</c:forEach>
					</tbody>
					<!--  
					
				</table>

			</div>

		</div>
	</div>

	<!-- data table end -->
					</div>

					<!-- start icons -->
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

