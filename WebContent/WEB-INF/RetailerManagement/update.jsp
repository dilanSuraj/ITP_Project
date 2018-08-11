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

 <nav class="navbar fixed-top navbar-expand-lg navbar-dark" style="background-color: #003399;color: white" >
     <a class="navbar-brand " href="#"   style="padding-right: 3%"> <img class="logo" src="Images/logo.png" alt="Home" ></a>
     <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
         <span class="navbar-toggler-icon"></span>
     </button>

     <div class="navbar-collapse collapse w-100 order-3 dual-collapse2"  id="navbarNav">
         <ul class="navbar-nav ml-auto navbar-icons">

             <!-- side bar items to navigation bar only for the screen sizes below  7'0 tab-->
             <!-- you need to give the same links in the side bar to this links -->

             <div class="d-block d-md-none">
                 <li class="nav-item ">
                     <a class="nav-link" href="#" style="color: white">
                         <span class="fa fa-home " style="font-size: 18px"></span> Home</a>
                 </li>

                 <li class="nav-item">
                     <a class="nav-link" href="#"  style="color: white"><span class="fa fa-history " style="font-size: 18px"></span>   Order History</a>
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
                     <a class="nav-link" href="#"  style="color: white"><span class="fa fa-shopping-cart " style="font-size: 18px"></span>   Cart</a>
                 </li>
                
                 <li class="nav-item">
                     <a class="nav-link " href="#" style="color: white" ><span class="fa fa-user-plus" style="font-size: 18px"></span>
                         Profile Settings</a>
                 </li>

                 <li class="nav-item">
                     <a class="nav-link" href="#" style="color: white"><span class="fa fa-money" style="font-size: 18px"></span>
                         Payment</a>
                 </li>
             </div>

             <!-- end of side bar links to nav bar -->

             

             <li class="nav-item">
                 <a  href="#"  class="admin-name">Admin Name</a>
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

             <li class="nav-item active">
                 <a class="nav-link" href="#" >
                     <span class="fa fa-home " style="font-size: 18px"></span> Home</a>
             </li>

             <li class="nav-item">
                 <a class="nav-link" href="#"  ><span class="fa fa-history " style="font-size: 18px"></span>   Order History</a>
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
                 <a class="nav-link " href="#" ><span class="fa fa-user-plus" style="font-size: 18px"></span>
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

      <!-- forms starts -->

     <div class="col-md-12">
         <div class="card mb-3" >
             <div class="card-header" style="color: #003399" >
                 <h5><span class="fa fa-pencil"></span> Update Profile</h5></div>
             <div class="card-body">

                 <form>
				 <h5>Contact</h5>
                     <div class="form-column">
                         <div class="form-group col-md-6">
                             <label for="inputEmail4">Contact Name</label>
                             <input type="text" class="form-control" id="inputFirstl4" placeholder="Contact Name">
                         </div>
                         <div class="form-group col-md-6">
                             <label for="inputPassword4">Registered Number</label>
                             <input type="text" class="form-control" id="inputLast4" placeholder="Reg number">
                         </div>
						  <div class="form-group col-md-6">
                             <label for="inputEmail4">Email Address</label>
                             <input type="text" class="form-control" id="inputFirstl4" placeholder="Email">
                         </div>
						 <div class="form-group col-md-6">
                             <label for="inputEmail4">Telephone Number(Official)</label>
                             <input type="text" class="form-control" id="inputFirstl4" placeholder="07123456978">
                         </div>
						  <div class="form-group col-md-6">
                             <label for="inputEmail4">Telephone Number(Personal)</label>
                             <input type="text" class="form-control" id="inputFirstl4" placeholder="07123456978">
                         </div>
						 <div class="form-group col-md-6">
                             <label for="inputEmail4">Password</label>
                             <input type="password" class="form-control" id="inputFirstl4" placeholder="Password">
                         </div>
						 <div class="form-group col-md-6">
                             <label for="inputEmail4">Confirm Password</label>
                             <input type="password" class="form-control" id="inputFirstl4" placeholder="Confirm Password">
                         </div>
				 <h5>Shop Details</h5>
					 <div class="form-column">
							<div class="form-group col-md-6">
								<label for="inputAddress">Shop Name</label>
								<input type="text" class="form-control" id="inputAddress" placeholder="Shop name">
							</div>
							<div class="form-group col-md-6 ">
								<label for="inputAddress">Shop Address Line 01</label>
								<input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St">
							</div>
							<div class="form-group col-md-6">
								<label for="inputAddress2">Shop Address Line 02</label>
								<input type="text" class="form-control" id="inputAddress2" placeholder="Apartment, studio, or floor">
							</div>
					 <div class="form-row">
							<div class="form-group col-md-6">
								<label for="inputCity">City</label>
								<input type="text" class="form-control" id="inputCity">
							</div>
							<div class="form-group col-md-4">
								<label for="inputState">Province</label>
								<select id="inputState" class="form-control">
									<option selected>Choose...</option>
									<option>Northern</option>
									<option>North Western</option>
									<option>Western</option>
									<option>North Central</option>
									<option>Central</option>
									<option>Sabaragamuwa</option>
									<option>Eastern</option>
									<option>Uva</option>
									<option>Southern</option>
								</select>
								</div>
							<div class="form-group col-md-2">
								<label for="inputZip">Zip</label>
								<input type="text" class="form-control" id="inputZip">
							</div> 
                     </div>
             </div>

                     <button type="submit" class="btn btn-primary">Update</button>

                 </form>
			</div>
         </div>
     </div>
	<pre>                                                                                                                         <a href>Delete Request</a><pre>
     <!-- forms ends-->
	 
	 
<!-- Bootstrap tooltips -->
<script type="text/javascript" src="js/popper.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<!-- MDB core JavaScript -->
<script src="https://maps.googleapis.com/maps/api/js?callback=myMap"></script>

<script type="text/javascript" src="js/mdb.min.js"></script>
</body>
</html>
 