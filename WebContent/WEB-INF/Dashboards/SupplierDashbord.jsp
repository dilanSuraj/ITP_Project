<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


    <!-- Bootstrap CSS -->
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">

    <!-- Bootstrap core CSS -->
    <link href="Styles/css/bootstrap.min.css" rel="stylesheet">

    <!-- Your custom styles -->
    <link rel="stylesheet" href="Styles/css/dashboardStyleSheet.css">

    <!-- font awesome icon pack-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <!--java script file for google charts-->
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

    <!--google maps library -->
    <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY&callback=myMap"></script>

    <!--data table files -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script type="text/javascript" src="Styles/js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="Styles/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="Styles/js/dataTables.bootstrap4.min.js"></script>
    <link rel="stylesheet" href="Styles/css/dataTables.bootstrap4.min.css">

     <title>Supplier dashboard</title>
 </head>

 <body>


<!-- start of the the navigation header-->

 <%@include file="/WEB-INF/SupplierManagement/SupplierNavBar.jsp"%>
<!-- end of the navigation header-->

 <div class="row justify-content-end " >
     <div class="col-md-10" style="padding-top: 90px;padding-left: 40px;padding-right: 40px">
 <!--center edit start -->

        <!-- top 4 cards starts -->
         <div class="row">
             <div class="col-xl-3 col-sm-6 mb-3">
                 <div class="card text-white  o-hidden h-100" style="background-color: #003399">
                     <div class="card-body">
                         <div class="card-body-icon">
                             <i class="fa fa-edit"></i>
                         </div>
                         <div class="mr-5">New Orders!</div>
                         <h4>${totalToBesupply} Orders</h4>
                         <br>
                     </div>


                 </div>
             </div>
             
             <div class="col-xl-3 col-sm-6 mb-3">
                 <div class="card text-white bg-warning o-hidden h-100">
                     <div class="card-body">
                         <div class="card-body-icon">
                             <i class="fa fa-fw fa-list"></i>
                         </div>
                         <div class="mr-5">Previous Orders</div>
                         <h4>${totalSupplied} Orders</h4>
                         <br>
                     </div>

                 </div>
             </div>
             
             <div class="col-xl-3 col-sm-6 mb-3">
                 <div class="card text-white bg-success o-hidden h-100">
                     <div class="card-body">
                         <div class="card-body-icon">
                             <i class="fa fa-money"></i>
                         </div>
                         <div class="mr-5">Payments Received</div>
                         <h4>RS ${totalPaid}</h4>
                         <br>
                     </div>

                 </div>
             </div>
             <div class="col-xl-3 col-sm-6 mb-3">
                 <div class="card text-white bg-danger o-hidden h-100">
                     <div class="card-body">
                         <div class="card-body-icon">
                             <i class="fa fa-credit-card"></i>
                         </div>
                         <div class="mr-5">Payments to be recevied</div>
                         <h4>RS ${totalToBePaid}</h4>
                         <br>
                     </div>

                 </div>
             </div>

         </div>
             
         <nav >
             <div class="nav nav-tabs card-header"  id="nav-tab" role="tablist">
                 <a class="nav-item nav-link active navbar-dark" id="nav-norders-tab" data-toggle="tab" href="#nav-norders" role="tab" aria-controls="nav-norders" aria-selected="true">New Orders</a>
                 <a class="nav-item nav-link" id="nav-porders-tab" data-toggle="tab" href="#nav-porders" role="tab" aria-controls="nav-porders" aria-selected="false">Previous Orders</a>
                 <a class="nav-item nav-link" id="nav-rpayments-tab" data-toggle="tab" href="#nav-rpayments" role="tab" aria-controls="nav-rpayments" aria-selected="false">Payments received</a>
                 <a class="nav-item nav-link" id="nav-rpayments-tab" data-toggle="tab" href="#nav-apayments" role="tab" aria-controls="nav-rpayments" aria-selected="false">Advance Payments</a>
                 <a class="nav-item nav-link" id="nav-rtpayments-tab" data-toggle="tab" href="#nav-rtpayments" role="tab" aria-controls="nav-rtpayments" aria-selected="false">Payments to be received</a>
             </div>
         </nav>



     <div class="tab-content" id="nav-tabContent">
         <div class="tab-pane fade show active" id="nav-norders" role="tabpanel" aria-labelledby="nav-norders-tab">

            <div class="row">




                 <!-- data table start -->


                <div class="col-md-12">
                    <div class="card mb-3" >
                    <div class="card-header" style="color: #003399" >
                    <h5><span class="fa fa-edit"></span> New Orders </h5></div>
                    <div class="card-body">

                 <script>
                     $(document).ready(function() {
                         $('#example').DataTable();
                     } );
                 </script>

                 <table id="example" class="table table-striped table-bordered" style="width:100%">
                     <thead>
                     <tr>
										<th style="width: 45%">Product</th>
										<th style="width: 12%">Order Date</th>
										<th style="width: 12%">Order Amount</th>
										
					</tr>
                     </thead>
                     <tbody>
									<c:forEach var="SupplierItems" items="${SupplierItems}"
										varStatus="loopCounter">
										<tr>
											<td >
												<div class="row">
													<div class="col-sm-9">
														<h4 class="nomargin"><small>${SupplierItems.getItemname()}</small></h4>
													</div>
												</div>
											</td>
											<td >${SupplierItems.getOrderDate()}</td>
											<td >${SupplierItems.getAmount()}</td>
											
										</tr>
										</c:forEach>
								</tbody>
                     <tfoot>
                     <tr>
                         				<th style="width: 45%">Product</th>
                         				<th style="width: 12%">Order Date</th>
										<th style="width: 12%">Order Amount</th>
										
                     </tr>
                     </tfoot>
                 </table>
             </div>
             <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
         </div>
     </div>

                <!-- data table end -->
            </div>
         </div>
         
         <div class="tab-pane fade" id="nav-porders" role="tabpanel" aria-labelledby="nav-porders-tab">

            <div class="row">




                 <!-- data table start -->


                <div class="col-md-12">
                    <div class="card mb-3" >
                    <div class="card-header" style="color: #003399" >
                    <h5><span class="fa fa-bars"></span> Previous Orders </h5></div>
                    <div class="card-body">

                 <script>
                     $(document).ready(function() {
                         $('#example5').DataTable();
                     } );
                 </script>

                 <table id="example5" class="table table-striped table-bordered" style="width:100%">
                     <thead>
                     <tr>
										<th style="width: 45%">Product</th>
										<th style="width: 12%">Order Date</th>
										<th style="width: 12%">Order Amount</th>
										
					</tr>
                     </thead>
                     <tbody>
									<c:forEach var="SupplierItems1" items="${SupplierItems1}"
										varStatus="loopCounter">
										<tr>
											<td >
												<div class="row">
													<div class="col-sm-9">
														<h4 class="nomargin"><small>${SupplierItems1.getItemname()}</small></h4>
													</div>
												</div>
											</td>
											<td >${SupplierItems1.getOrderDate()}</td>
											<td >${SupplierItems1.getAmount()}</td>
											
										</tr>
										</c:forEach>
								</tbody>
                     <tfoot>
                     <tr>
                         				<th style="width: 45%">Product</th>
                         				<th style="width: 12%">Order Date</th>
										<th style="width: 12%">Order Amount</th>
										
                     </tr>
                     </tfoot>
                 </table>
             </div>
             <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
         </div>
     </div>

                <!-- data table end -->
            </div>
         </div>
         
         <div class="tab-pane fade" id="nav-rpayments" role="tabpanel" aria-labelledby="nav-rpayments-tab">
             <div class="row">




                 <!-- data table start -->


                 <div class="col-md-12">
                     <div class="card mb-3" >
                         <div class="card-header" style="color: #003399" >
                             <h5><span class="fa fa-money"></span> Payments received </h5></div>
                         <div class="card-body">

                             <script>
                                 $(document).ready(function() {
                                     $('#example3').DataTable();
                                 } );
                             </script>

                            <table id="example3" class="table table-striped table-bordered" style="width:100%">
                     <thead>
                     <tr>
										<th>Order ID</th>
										<th>Payment date</th>
										<th>Amount</th>
					</tr>
                     </thead>
                     <tbody>
									<c:forEach items="${Supplier_Finance}" var="Supplier_Finance" 
										varStatus="loopCounter">
										<tr>
											<td >
												<div class="row">
													<div class="col-sm-9">
														<h4 class="nomargin"><small>${Supplier_Finance.getSupplier_orderID()}</small></h4>
													</div>
												</div>
											</td>
											<td >${Supplier_Finance.getPaymentDateInString()}</td>
											<td >${Supplier_Finance.getAmount()}</td>
											
										</tr>
										</c:forEach>
								</tbody>
                     <tfoot>
                     <tr>
                         				<th>Order ID</th>
										<th>Payment date</th>
										<th>Amount</th>
										
                     </tr>
                     </tfoot>
                 </table>
                         </div>
                         <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
                     </div>
                 </div>
             </div>

                 <!-- data table end -->
         </div>
         
         <div class="tab-pane fade" id="nav-apayments" role="tabpanel" aria-labelledby="nav-rpayments-tab">
             <div class="row">




                 <!-- data table start -->


                 <div class="col-md-12">
                     <div class="card mb-3" >
                         <div class="card-header" style="color: #003399" >
                             <h5><span class="fa fa-money"></span> Advanced Payments</h5></div>
                         <div class="card-body">

                             <script>
                                 $(document).ready(function() {
                                     $('#example8').DataTable();
                                 } );
                             </script>

                            <table id="example8" class="table table-striped table-bordered" style="width:100%">
                     <thead>
                     <tr>
										<th>Order ID</th>
										<th>Payment date</th>
										<th>Amount</th>
					</tr>
                     </thead>
                     <tbody>
									<c:forEach items="${Supplier_Financea}" var="Supplier_Financea" 
										varStatus="loopCounter">
										<tr>
											<td >
												<div class="row">
													<div class="col-sm-9">
														<h4 class="nomargin"><small>${Supplier_Financea.getSupplier_orderID()}</small></h4>
													</div>
												</div>
											</td>
											<td >${Supplier_Financea.getPaymentDateInString()}</td>
											<td >${Supplier_Financea.getAmount()}</td>
											
										</tr>
										</c:forEach>
								</tbody>
                     <tfoot>
                     <tr>
                         				<th>Order ID</th>
										<th>Payment date</th>
										<th>Amount</th>
										
                     </tr>
                     </tfoot>
                 </table>
                         </div>
                         <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
                     </div>
                 </div>
             </div>

                 <!-- data table end -->
         </div>
         
         <div class="tab-pane fade" id="nav-rtpayments" role="tabpanel" aria-labelledby="nav-rtpayments-tab">
             <div class="row">




                 <!-- data table start -->


                 <div class="col-md-12">
                     <div class="card mb-3" >
                         <div class="card-header" style="color: #003399" >
                             <h5><span class="fa fa-credit-card"></span> Payments to be received </h5></div>
                         <div class="card-body">

                             <script>
                                 $(document).ready(function() {
                                     $('#example4').DataTable();
                                 } );
                             </script>

                             <table id="example4" class="table table-striped table-bordered" style="width:100%">
                      <thead>
                     <tr>
										<th>Order ID</th>
										<th>Amount</th>
										
					</tr>
                     </thead>
                     <tbody>
									<c:forEach items="${Supplier_Finance1}" var="Supplier_Finance1" 
										varStatus="loopCounter">
										<tr>
											<td >
												<div class="row">
													<div class="col-sm-9">
														<h5 class="nomargin"><small>${Supplier_Finance1.getSupplier_orderID()}</small></h5>
													</div>
												</div>
											</td>
											<td >${Supplier_Finance1.getAmount()}</td>
											
										</tr>
										</c:forEach>
								</tbody>
                     <tfoot>
                     <tr>
                         				<th>Order ID</th>
										<th>Amount</th>
										
                     </tr>
                     </tfoot>
                 </table>
                         </div>
                         <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
                     </div>
                 </div>
             </div>

             <!-- data table end -->
         </div>
     </div>
<!-- /.content-wrapper-->

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