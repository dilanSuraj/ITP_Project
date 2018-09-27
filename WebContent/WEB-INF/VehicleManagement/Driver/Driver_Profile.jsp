<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
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

    <!--java scrip file for google charts-->
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

    <!--google maps library -->
    <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY&callback=myMap"></script>

	
    <!--data table files -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script type="text/javascript" src="Styles/js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="Styles/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="Styles/js/dataTables.bootstrap4.min.js"></script>
    <link rel="stylesheet" href="Styles/css/dataTables.bootstrap4.min.css">

	
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
     <title>Sumith Tyres pvt Ltd</title>
 </head>

 <body>


<!-- start of the the navigation header-->

 <nav class="navbar fixed-top navbar-expand-lg navbar-dark" style="background-color: #003399;color: white" >
     <a class="navbar-brand " href="#"   style="padding-right: 3%"> <img class="logo" src="Styles/Images/logo.png" alt="Home" ></a>
     <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
         <span class="navbar-toggler-icon"></span>
     </button>

     <div class="navbar-collapse collapse w-100 order-3 dual-collapse2"  id="navbarNav">
         <ul class="navbar-nav ml-auto navbar-icons">

             <!-- side bar items to navigation bar only for the screen sizes below  7'0 tab-->
             <!-- you need to give the same links in the side bar to this links -->

             <div class="d-block d-md-none">
                

                
             </div>

             <!-- end of side bar links to nav bar -->

             
             <li class="nav-item">
                 <a  href="#"  class="admin-name">silva V.M</a>
             </li>


            

             <li class="nav-item">
                 <button type="button" class="btn btn-dark btn-sm "> <span class="fa fa-key"></span> Logout</button>
             </li>



         </ul>
     </div>

 </nav>
<!-- end of the navigation header-->

 <!-- side bar starts -->

                <!-- only visibale in 10'0 inch or above screens-->
 <div class="col-md-2 position-fixed d-none d-md-block" style="background-color: #003399;height: 100%;padding-top: 60px;">
     <nav class="navbar  navbar-expand-lg navbar-dark"  style="padding-top: 30px;padding-left:0%">


         <ul class="nav flex-column sidbar-items">
             <li>

             </li>

            

         </ul>

     </nav>
 </div>

 <!--side bar end-->

 <div class="row justify-content-end " >
     <div class="col-md-10" style="padding-top: 90px;padding-left: 40px;padding-right: 40px">
 <!--center edit start -->

 
        <!-- top 4 cards starts -->
         <div class="row">
             <div class="col-xl-3 col-sm-6 mb-3">
                 <div class="card text-white  o-hidden h-100" style="background-color: #003399">
                     <div class="card-body">
                         <div class="card-body-icon">
                             <i class="fa fa-fw fa-comments"></i>
                         </div>
                         <div class="mr-5">Vehicle Number</div>
                     </div>
                     <a class="card-footer text-white clearfix small z-1" href="#">
                         <span class="float-left">QZ-1521</span>
                         <span class="float-right">
                <i class="fa fa-angle-right"></i>
              </span>
                     </a>
                 </div>
             </div>
             <div class="col-xl-3 col-sm-6 mb-3">
                 <div class="card text-white bg-warning o-hidden h-100">
                     <div class="card-body">
                         <div class="card-body-icon">
                             <i class="fa fa-fw fa-list"></i>
                         </div>
                         <div class="mr-5">Mileage</div>
                     </div>
                     <a class="card-footer text-white clearfix small z-1" href="#">
                         <span class="float-left">123456KM</span>
                         <span class="float-right">
                <i class="fa fa-angle-right"></i>
              </span>
                     </a>
                 </div>
             </div>
             <div class="col-xl-3 col-sm-6 mb-3">
                 <div class="card text-white bg-success o-hidden h-100">
                     <div class="card-body">
                         <div class="card-body-icon">
                             <i class="fa fa-fw fa-shopping-cart"></i>
                         </div>
                         <div class="mr-5">Next Service Date</div>
                     </div>
                     <a class="card-footer text-white clearfix small z-1" href="#">
                         <span class="float-left">15-09-2018</span>
                         <span class="float-right">
                <i class="fa fa-angle-right"></i>
              </span>
                     </a>
                 </div>
             </div>
             <div class="col-xl-3 col-sm-6 mb-3">
                 <div class="card text-white bg-danger o-hidden h-100">
                     <div class="card-body">
                         <div class="card-body-icon">
                             <i class="fa fa-fw fa-support"></i>
                         </div>
                         <div class="mr-5">Fuel Count</div>
                     </div>
                     <a class="card-footer text-white clearfix small z-1" href="#">
                         <span class="float-left">10 Liters</span>
                         <span class="float-right">
                <i class="fa fa-angle-right"></i>
              </span>
                     </a>
                 </div>
             </div>
         </div>
             <!--top 4 cards end-->
<div class="container">
  <h2>Driver Details</h2>
  <Br>
  <ul class="list-group">
    <li class="list-group-item"><b>Name</b> : D.K.M.G.P.Silva</li>
    <li class="list-group-item"><b>Driver ID</b> :  ID5212</li>
    <li class="list-group-item"><b>Age</b> : 35</li>
    <li class="list-group-item"><b>NIC</b> : 642472689V</li>
	<li class="list-group-item"><b>Driver Licence Number</b> : C4573573 </li>
	<li class="list-group-item"><b>Address Line 01</b> : 132/C</li>
	<li class="list-group-item"><b>Address Line 02</b> : Kosgahathenna</li>
	<li class="list-group-item"><b>City</b> : Gampaha</li>
	<li class="list-group-item"><b>Province</b> : Western</li>
	<li class="list-group-item"><b>Vehicle Number</b> : PQ-4521</li>
    <li class="list-group-item"><b>Vehicle Type</b> : Lorry</li>
	
  </ul>
  
</div>


   
     
</div>
<!-- /.content-wrapper-->


<!-- Bootstrap tooltips -->
<script type="text/javascript" src="Styles/js/popper.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script type="text/javascript" src="Styles/js/bootstrap.min.js"></script>
<!-- MDB core JavaScript -->
<script src="https://maps.googleapis.com/maps/api/js?callback=myMap"></script>

<script type="text/javascript" src="Styles/js/mdb.min.js"></script>
</body>
</html>