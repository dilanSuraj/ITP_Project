<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    <link href="css/bootstrap.min.css" rel="stylesheet">

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

    <title>Supplier Profile</title>
</head>

<body>


<!-- start of the the navigation header-->

<%@include file="/WEB-INF/SupplierManagement/SupplierNavBar.jsp"%>
<!-- end of the navigation header-->

<!-- side bar starts -->

<!-- only visibale in 10'0 inch or above screens-->
<div class="col-md-2 position-fixed d-none d-md-block" style="background-color: #003399;height: 100%;padding-top: 60px;">
    <nav class="navbar  navbar-expand-lg navbar-dark"  style="padding-top: 30px;padding-left:0%">


        <ul class="nav flex-column sidbar-items">
            <li>

            </li>

            <li class="nav-item active">
                <a class="nav-link" href="SupplierDashbord" >
                    <span class="fa fa-pencil-square-o " style="font-size: 18px"></span> Home</a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="supplierProfile"  ><span class="fa fa-id-card-o " style="font-size: 18px"></span>   View profile</a>
            </li>

            <li class="nav-item">
                <a class="nav-link " href="editSupplierProfile" ><span class="fa fa-pencil" style="font-size: 18px"></span>
                    Edit Supplier</a>
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
                    <h5><span class="fa fa-id-card-o"></span>Profile Details</h5></div>
                <div class="card-body">



                    <ul class="list-group">
                        <li class="list-group-item"><b>Name</b> : D.K.M.G.P.Silva</li>
                        <li class="list-group-item"><b>Company Name</b> : abc PVT</li>
                        <li class="list-group-item"><b>Registration No </b> : RN2050</li>
                        <li class="list-group-item"><b>Address </b> : Address abcd efg </li>
                        <li class="list-group-item"><b>Contact No</b> : 0123456789</li>


                    </ul>
                        <br>

                       <center> <button  class="btn btn-primary" style="width: 120px"  onclick="window.location.href='editSupplierProfile.html'"><span class="fa fa-pencil-square-o"></span> Edit</button></center>



                </div>
            </div>
        </div>





        <!-- forms ends-->



        <!-- /.content-wrapper-->


        <!-- Bootstrap tooltips -->
        <script type="text/javascript" src="js/popper.min.js"></script>
        <!-- Bootstrap core JavaScript -->
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <!-- MDB core JavaScript -->
        <script src="https://maps.googleapis.com/maps/api/js?callback=myMap"></script>

        <script type="text/javascript" src="js/mdb.min.js"></script>
    </div>
</div>
</body>
</html>