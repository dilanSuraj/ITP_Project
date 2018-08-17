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
    <script type="text/javascript" src="js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="js/dataTables.bootstrap4.min.js"></script>
    <link rel="stylesheet" href="Styles/css/dataTables.bootstrap4.min.css">

     <title>Delete Retailer</title>
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
                 <li class="nav-item ">
                     <a class="nav-link" href="#" style="color: white">
                         <span class="fa fa-pencil-square-o " style="font-size: 18px"></span> Home</a>
                 </li>

                 <li class="nav-item">
                     <a class="nav-link" href="AdminDashbord add.html"  style="color: white"><span class="fa fa-plus " style="font-size: 18px"></span>   Add Retailer</a>
                 </li>
                 
                 <li class="nav-item">
                     <a class="nav-link " href="AdminDashbord Update.html" style="color: white" ><span class="fa fa-clone" style="font-size: 18px"></span>
                         Update Retailer Profile</a>
                 </li>

                 <li class="nav-item">
                     <a class="nav-link " href="AdminDashbord Delete.html" style="color: white"><span class="fa fa-database" style="font-size: 18px"></span>
                         Delete Retailer</a>
                 </li>

                
             </div>

             <!-- end of side bar links to nav bar -->

            

             <li class="nav-item">
                 <a  href="#"  class="admin-name">Eshan A.M.N</a>
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
                     <span class="fa fa-pencil-square-o " style="font-size: 18px"></span> Home</a>
             </li>

             <li class="nav-item">
                 <a class="nav-link" href="AdminDashbord add.html"  ><span class="fa fa-plus " style="font-size: 18px"></span>   Add Retailer</a>
             </li>
             
             <li class="nav-item">
                 <a class="nav-link " href="AdminDashbord update.html" ><span class="fa fa-clone" style="font-size: 18px"></span>	Update Retailer Profile</a>
             </li>

             <li class="nav-item">
                 <a class="nav-link " href="AdminDashbord delete.html" ><span class="fa fa-database" style="font-size: 18px"></span>
                     Delete Retailer</a>
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
                 <h5><span class="fa fa-pencil"></span> Delete Retailer</h5></div>
             <div class="card-body">

                 <form>
				 <div class="form-group col-md-4">
                             <label for="inputState">Retailer ID</label>
                             <select id="inputState" class="form-control">
                                 <option selected>Choose...</option>
                                 <option>...</option>
                             </select>
                         </div>
                     <button type="button" class="btn btn-primary active">Delete</button>
					<button type="button" class="btn btn-primary active">Cancel</button>
                 </form>
     </div>
         </div>
     </div>

     <!-- forms ends-->
      <!-- data table start -->


     <div class="col-md-12">
         <div class="card mb-3" >
             <div class="card-header" style="color: #003399" >
                 <h5><span class="fa fa-image"></span> Retailer Details </h5></div>
             <div class="card-body">

                 <script>
                     $(document).ready(function() {
                         $('#example').DataTable();
                     } );
                 </script>

                 <table id="example" class="table table-striped table-bordered" style="width:100%">
                     <thead>
                     <tr>
                         <th>Contact Name</th>
                         <th>Registered Number</th>
                         <th>Email Address</th>
                         <th>Telephone Number(Official)</th>
						 <th>Telephone Number(personal)</th>
						 <th>Password</th>
						 <th>Confirm Password</th>
                     </tr>
                     </thead>
                     <tbody>
                     <tr>
                         <td>Eshan A.B</td>
                         <td>reg-123-1234-245</td>
                         <td>eshan1@gmail.com</td>
                         <td>0112345678</td>
						 <td>0712345678</td>
						 <td>navindu1</td>
						 <td>navindu1</td>
                     </tr>
                     <tr>
                        <td>Eshan A.C</td>
                         <td>reg-123-1234-275</td>
                         <td>eshan2@gmail.com</td>
                         <td>0112245678</td>
						 <td>0712745678</td>
						 <td>navindu2</td>
						 <td>navindu2</td>
                     </tr>
                     <tr>
                         <td>Eshan A.D</td>
                         <td>reg-223-1234-245</td>
                         <td>eshan3@gmail.com</td>
                         <td>0112367678</td>
						 <td>0712313678</td>
						 <td>navindu3</td>
						 <td>navindu3</td>
                     </tr>
						 <td>Eshan A.E</td>
                         <td>reg-142-1234-245</td>
                         <td>eshan4@gmail.com</td>
                         <td>0112348678</td>
						 <td>0712252678</td>
						 <td>navindu4</td>
						 <td>navindu4</td>
                     <tr>
                        <td>Eshan A.F</td>
                         <td>reg-123-1780-245</td>
                         <td>eshan5@gmail.com</td>
                         <td>0112375678</td>
						 <td>0712098678</td>
						 <td>navindu5</td>
						 <td>navindu5</td>
                     </tr>
                     </tfoot>
                 </table>
             </div>
             <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
         </div>
     </div>

     <!-- data table end -->
         
</div>
<!-- /.content-wrapper-->


<!-- Bootstrap tooltips -->
<script type="text/javascript" src="js/popper.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<!-- MDB core JavaScript -->
<script src="https://maps.googleapis.com/maps/api/js?callback=myMap"></script>

<script type="text/javascript" src="js/mdb.min.js"></script>
</body>
</html>