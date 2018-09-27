<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
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
    <script type="text/javascript" src="js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="js/dataTables.bootstrap4.min.js"></script>
    <link rel="stylesheet" href="css/dataTables.bootstrap4.min.css">
	
	<!--Scrollspy-->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	
     <title>Sumith Tyres pvt Ltd</title>
 </head>

 <body>


<!-- start of the the navigation header-->

	<%@include file="/WEB-INF/RetailerManagement/RetailerDashbordnavBar.jsp"%>

	<!-- end of the navigation header-->

 <!-- side bar starts -->

                <!-- only visibale in 10'0 inch or above screens-->
 <div class="col-md-2 position-fixed d-none d-md-block" style="background-color: #003399;height: 100%;padding-top: 60px;">
     <nav class="navbar  navbar-expand-lg navbar-dark"  style="padding-top: 30px;padding-left:0%">


         <ul class="nav flex-column sidbar-items">
             <li>

             </li>

             <li class="nav-item active">
                 <a class="nav-link" href="Retailer" >
                     <span class="fa fa-home " style="font-size: 18px"></span> Home</a>
             </li>

             <li class="nav-item">
                 <a class="nav-link" href="RetailerOrderHistory"  ><span class="fa fa-history " style="font-size: 18px"></span>   Order History</a>
             </li>
			 
			 <li class="nav-item dropdown">
                 <a class="nav-link dropdown-toggle" href="#"  role="button" data-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="false"
                   ><span class="fa fa-sitemap " style="font-size: 18px"></span>
                     Items
                 </a>
                 <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                     <a class="dropdown-item" href="#" style="color: black">Tyres</a>
                     <div class="dropdown-divider" ></div>
                     <a class="dropdown-item" href="#"  style="color: black">Battery</a>
                     <div class="dropdown-divider"></div>
                     <a class="dropdown-item" href="#"  style="color: black">Alloy Wheel</a>
                 </div>
             </li>
			 
             <li class="nav-item">
                 <a class="nav-link " href="#" ><span class="fa fa-shopping-cart" style="font-size: 18px"></span>
                     Cart</a>
             </li>
             <li class="nav-item">
                 <a class="nav-link " href="update_GET" ><span class="fa fa-user-plus" style="font-size: 18px"></span>
                     Profile Settings</a>
             </li>

             <li class="nav-item">
                 <a class="nav-link " href="#" ><span class="fa fa-money" style="font-size: 18px"></span>
                     Payment</a>
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
                             <i class="fa fa-fw fa-shopping-cart"></i>
                         </div>
                         <div class="mr-5">Items in cart</div>
                     </div>
                     <a class="card-footer text-white clearfix small z-1" href="#">
                         <span class="float-left">View Details</span>
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
                         <div class="mr-5">Total orders</div>
                     </div>
                     <a class="card-footer text-white clearfix small z-1" href="#">
                         <span class="float-left">View Details</span>
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
                             <i class="fa fa-credit-card" aria-hidden="true"></i>
                         </div>
                         <div class="mr-5">Total bill paid</div>
                     </div>
                     <a class="card-footer text-white clearfix small z-1" href="#">
                         <span class="float-left">View Details</span>
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
                             <i class="fa fa-money" aria-hidden="true"></i>
                         </div>
                         <div class="mr-5">Total amount to pay</div>
                     </div>
                     <a class="card-footer text-white clearfix small z-1" href="#">
                         <span class="float-left">View Details</span>
                         <span class="float-right">
                <i class="fa fa-angle-right"></i>
              </span>
                     </a>
                 </div>
             </div>
         </div>
             <!--top 4 cards end-->
 <div class="row">

     <!--Cards-->
          <div class="col-md-12">
         <div class="card mb-3" >
             <div class="card-header" style="color: #003399" >
                 <h5><span class="fa fa-image"></span> Items </h5></div>
             <div class="card-body">

             <div class="card-deck">
                 <div class="card">
                     <a href="#"><img class="card-img-top" src="Styles/Images/Tyres.jpg" alt="Card image cap"></a>
                     <div class="card-body">
                         <a href="#"><h5 class="card-title" align="center">Tyres</h5></a>
                     </div>
                    
                 </div>
                 <div class="card">
                     <a href="#"><img class="card-img-top"src="Styles/Images/Battery.jpg" alt="Card image cap"></a>
                     <div class="card-body">
                         <a href="#"><h5 class="card-title" align="center">Battery</h5></a>
                     </div>
                    
                 </div>
                 <div class="card">
					 <a href="#"><img class="card-img-top" src="Styles/Images/Wheels.png" alt="Card image cap"></a>
                     <div class="card-body">
                         <a href="#"><h5 class="card-title" align="center">Alloy wheel</h5></a>
                     </div>
                     
                 </div>
             </div>
 </div>
    </div>
</div>
     <!--cards-->

        <!--google  maps using google api starts-->

        <div class="col-md-12">
            <div class="card mb-3" >
                <div class="card-header" style="color: #003399" >
                    <h5><span class="fa fa fa-location-arrow"></span> Location map</h5></div>
                <div class="card-body">

                    <div id="map" style="width:100%;height:400px;"></div>

                        <script>
                        function myMap() {
                        var mapCanvas = document.getElementById("map");
                        var mapOptions = {
                        center: new google.maps.LatLng(8.5, 80.2),
                        zoom: 10
                        };
                        var map = new google.maps.Map(mapCanvas, mapOptions);
                        }
                        </script>
                </div>
            </div>
        </div>

        <!--google  maps using google api end-->


     
 
</div>
<!-- /.content-wrapper-->


<!-- Bootstrap -->
<script type="text/javascript" src="js/popper.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<!-- MDB core JavaScript -->
<script src="https://maps.googleapis.com/maps/api/js?callback=myMap"></script>

<script type="text/javascript" src="js/mdb.min.js"></script>
</body>
</html>