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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
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


	<!-- start of the the navigation header-->

	<%@ include
		file="/WEB-INF/PageSegments/Finance_Management/_navigationheader.jsp"%>
	<!-- end of the navigation header-->

	<!-- side bar starts -->

	<!-- only visibale in 10'0 inch or above screens-->
	<%@ include
		file="/WEB-INF/PageSegments/Finance_Management/_sidebar.jsp"%>

	<!--side bar end-->
	<%@ include file="/WEB-INF/PageSegments/Finance_Management/_cards.jsp"%>
	<!-- topic bar starts-->

	<ol class="breadcrumb" style="margin-top: 10px; margin-bottom: 10px">
		<li class="breadcrumb-item"><a href="#" style="color: #003399">Dashboard</a>
		</li>
		<li class="breadcrumb-item active">Navbar</li>
	</ol>



	<!-- start icons -->

	<!-- cards starts-->
	<!-- data table start -->

	<div class="col-md-12">

		<div class="card mb-3">
			<div class="card-header" style="color: #003399">
				<h5>
					<span class="fa fa-image"></span> Total Employee Month Salary
				</h5>

			</div>

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
							<th>Year</th>
							<th>Month</th>
							<th>Total Salary</th>
							<th>Salary Payment State</th>
							<th>Salary Payment Date</th>
							<th>Edit</th>

						</tr>
					</thead>
					<tbody>
					<c:forEach var="salarylist" items="${salarylist}"
							varStatus="status">
							<tr>
                                  
								<td>${salarylist.getEmp_month_sal_year()}</td>
								<td>${salarylist.getEmp_month_sal_month()}</td>
								<td>${salarylist.getEmp_month_sal_amount()}</td>
								<td>${salarylist.getEmp_month_sal_status()}</td>
								<td>${salarylist.getEmp_month_sal_dateInString()}</td>
								<td><a
									href="<c:url value='/Edit_Salary_Finace_GET?year=${salarylist.getEmp_month_sal_year()}&month=${salarylist.getEmp_month_sal_month()}' />">EDIT</a></td>

								
							</tr>
						</c:forEach>
						
					</tbody>
					<tfoot>
						<tr>
							<th>Year</th>
							<th>Month</th>
							<th>Total Salary</th>
							<th>Payment State</th>
							<th>Salary Payment Date</th>
							<th>Edit</th>

						</tr>
					</tfoot>
				</table>
			</div>

		</div>
	</div>
	<!-- Button to Open the pop up -->


	


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

