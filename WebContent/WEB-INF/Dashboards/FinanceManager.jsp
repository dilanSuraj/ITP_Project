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
                 <li class="nav-item ">
                     <a class="nav-link" href="Finance_Manager" style="color: white">
                         <span class="fa fa-pencil-square-o " style="font-size: 18px"></span> Home</a>
                 </li>

                 <li class="nav-item">
                     <a class="nav-link" href="Finance_Manager/Supplier_Finance"  style="color: white"><span class="fa fa-plus " style="font-size: 18px"></span>   Link</a>
                 </li>
                 <li class="nav-item dropdown">
                     <a class="nav-link dropdown-toggle" href="#" style="color: white" role="button" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false"
                     ><span class="fa fa-bar-chart " style="font-size: 18px"></span>
                         Charts
                     </a>
                     <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                         <a class="dropdown-item" href="#" style="color: black">Action</a>
                         <div class="dropdown-divider" ></div>
                         <a class="dropdown-item" href="#"  style="color: black">Another action</a>
                         <div class="dropdown-divider"></div>
                         <a class="dropdown-item" href="#"  style="color: black">Something else here</a>
                     </div>
                 </li>

                 <li class="nav-item">
                     <a class="nav-link " href="#" style="color: white" ><span class="fa fa-clone" style="font-size: 18px"></span>
                         Files</a>
                 </li>

                 <li class="nav-item">
                     <a class="nav-link " href="#" style="color: white"><span class="fa fa-database" style="font-size: 18px"></span>
                         Files</a>
                 </li>

                 <li class="nav-item">
                     <a class="nav-link" href="#" style="color: white"><span class="fa fa-envelope" style="font-size: 18px"></span>
                         Messages</a>
                 </li>
             </div>

             <!-- end of side bar links to nav bar -->

             <li class="nav-item">
                 <div class="dropdown ">
                     <p class=" dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                         <span class="fa fa-envelope navbarIcon" style="font-size:20px " ></span>
                     </p>
                     <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                         <a class="dropdown-item" href="#">Action</a>
                         <div class="dropdown-divider"></div>
                         <a class="dropdown-item" href="#">Another action</a>
                         <div class="dropdown-divider"></div>
                         <a class="dropdown-item" href="#">Something else here</a>
                     </div>
                 </div>
             </li>


             <li class="nav-item">
                 <div class="dropdown ">
                     <p class=" dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <span class="fa fa-bell navbarIcon" style="font-size:20px " ></span>
                     </p>
                     <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                         <a class="dropdown-item" href="#">Action</a>
                         <div class="dropdown-divider"></div>
                         <a class="dropdown-item" href="#">Another action</a>
                         <div class="dropdown-divider"></div>
                         <a class="dropdown-item" href="#">Something else here</a>
                     </div>
                 </div>
             </li>

             <li class="nav-item">
                 <a  href="#"  class="admin-name">Admin Name</a>
             </li>


             <li class="nav-item">
                 <form class="form-inline my-2 my-lg-0 mr-lg-2">
                     <div class="input-group">
                         <input class="form-control form-control-sm" type="text" placeholder="Search for...">
                         <span class="input-group-append">
                 <button class="btn btn-light btn-sm" type="button">
                   <i class="fa fa-search"></i>
                 </button>
               </span>
                     </div>
                 </form>
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
                 <a class="nav-link" href="Finance_Manager" >
                     <span class="fa fa-pencil-square-o " style="font-size: 18px"></span> Home</a>
             </li>

             <li class="nav-item">
                 <a class="nav-link" href="Finance_Manager/Supplier_Finance"  ><span class="fa fa-plus " style="font-size: 18px"></span>   Link</a>
             </li>
             <li class="nav-item dropdown">
                 <a class="nav-link dropdown-toggle" href="#"  role="button" data-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="false"
                   ><span class="fa fa-bar-chart " style="font-size: 18px"></span>
                     Charts
                 </a>
                 <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                     <a class="dropdown-item" href="#" style="color: black">Action</a>
                     <div class="dropdown-divider" ></div>
                     <a class="dropdown-item" href="#"  style="color: black">Another action</a>
                     <div class="dropdown-divider"></div>
                     <a class="dropdown-item" href="#"  style="color: black">Something else here</a>
                 </div>
             </li>

             <li class="nav-item">
                 <a class="nav-link " href="#" ><span class="fa fa-clone" style="font-size: 18px"></span>
                     Files</a>
             </li>

             <li class="nav-item">
                 <a class="nav-link " href="#" ><span class="fa fa-database" style="font-size: 18px"></span>
                     Files</a>
             </li>

             <li class="nav-item">
                 <a class="nav-link" href="#"><span class="fa fa-envelope" style="font-size: 18px"></span>
                     Messages</a>
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
                         <div class="mr-5">26 New Messages!</div>
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
                         <div class="mr-5">11 New Tasks!</div>
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
                             <i class="fa fa-fw fa-shopping-cart"></i>
                         </div>
                         <div class="mr-5">123 New Orders!</div>
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
                             <i class="fa fa-fw fa-support"></i>
                         </div>
                         <div class="mr-5">13 New Tickets!</div>
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

         <!-- topic bar starts-->

        <ol class="breadcrumb" style="margin-top:10px;margin-bottom: 10px">
            <li class="breadcrumb-item">
                <a href="#" style="color: #003399 ">Dashboard</a>
            </li>
            <li class="breadcrumb-item active">Navbar</li>
        </ol>

         <!-- topic bar end-->


 <div class="row">

     <!--graph start -->
     <div class="col-md-12">
         <div class="card mb-3" >
             <div class="card-header" style="color: #003399" >
                 <h5><span class="fa fa fa-area-chart"></span> Graph Example</h5></div>
             <div class="card-body">
                 <div id="chart_div" style="width: 100%; height: 400px;"></div>

                     <script type="text/javascript">
                     google.charts.load('current', {'packages':['corechart']});
                     google.charts.setOnLoadCallback(drawChart);

                     function drawChart() {
                         var data = google.visualization.arrayToDataTable([
                             ['Year', 'Sales', 'Expenses'],
                             ['2013',  1000,      400],
                             ['2014',  1170,      460],
                             ['2015',  660,       1120],
                             ['2016',  1030,      540]
                         ]);

                         var options = {
                             title: 'Company Performance',
                             hAxis: {title: 'Year',  titleTextStyle: {color: '#003399'}},
                             vAxis: {minValue: 0}
                         };

                         var chart = new google.visualization.AreaChart(document.getElementById('chart_div'));
                         chart.draw(data, options);
                     }
                 </script>

             </div>
             <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
         </div>
     </div>
     <!--end of the graph  -->


   <!--pie chart -->
    <div class="col-md-6">
        <div class="card mb-3" >
            <div class="card-header" style="color: #003399" >
                <h5><span class="fa fa-pie-chart"></span> Pie Chart Example</h5></div>
            <div class="card-body">


                <div id="piechart"></div>

                <script type="text/javascript">
                    // Load google charts
                    google.charts.load('current', {'packages':['corechart']});
                    google.charts.setOnLoadCallback(drawChart);

                    // Draw the chart and set the chart values
                    function drawChart() {
                        var data = google.visualization.arrayToDataTable([
                            ['Task', 'Hours per Day'],
                            ['Work', 8],
                            ['Eat', 2],
                            ['TV', 4],
                            ['Gym', 2],
                            ['Sleep', 8]
                        ]);

                        // Optional; add a title and set the width and height of the chart
                        var options = {'title':'My Average Day', 'width':550, 'height':400};

                        // Display the chart inside the <div> element with id="piechart"
                        var chart = new google.visualization.PieChart(document.getElementById('piechart'));
                        chart.draw(data, options);
                    }
                </script>

            </div>
            <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
        </div>
    </div>
        <!--end of pie chart -->


        <!--google  maps using google api starts-->

        <div class="col-md-6">
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
                <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
            </div>
        </div>

        <!--google  maps using google api end-->


     <!-- bar charts starts -->
     <div class="col-md-6">
         <div class="card mb-3" >
             <div class="card-header" style="color: #003399" >
                 <h5><span class="fa  fa-bar-chart"></span> Bar Chart</h5></div>
             <div class="card-body">
                 <script type="text/javascript">
                     google.charts.load("current", {packages:['corechart']});
                     google.charts.setOnLoadCallback(drawChart);
                     function drawChart() {
                         var data = google.visualization.arrayToDataTable([
                             ["Element", "Density", { role: "style" } ],
                             ["Copper", 8.94, "#b87333"],
                             ["Silver", 10.49, "silver"],
                             ["Gold", 19.30, "gold"],
                             ["Platinum", 21.45, "color: #e5e4e2"]
                         ]);

                         var view = new google.visualization.DataView(data);
                         view.setColumns([0, 1,
                             { calc: "stringify",
                                 sourceColumn: 1,
                                 type: "string",
                                 role: "annotation" },
                             2]);

                         var options = {
                             title: "Density of Precious Metals, in g/cm^3",
                             width: 500,
                             height: 300,
                             bar: {groupWidth: "95%"},
                             legend: { position: "none" },
                         };
                         var chart = new google.visualization.ColumnChart(document.getElementById("columnchart_values"));
                         chart.draw(view, options);
                     }
                 </script>
                 <div id="columnchart_values" style="width: 100%; height:100%;"></div>
                 <!-- for more type of charts go to this link :https://developers.google.com/chart/interactive/docs/gallery/table-->
             </div>
             <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
         </div>
     </div>
     <!-- bar charts ends -->

     <!-- progress bars starts-->

     <div class="col-md-6">
         <div class="card mb-3" >
             <div class="card-header" style="color: #003399" >
                 <h5><span class="fa fa-spinner"></span> Progress Bars</h5></div>
             <div class="card-body">

                 <!-- Blue -->

                 <h6>Progress Bar 1</h6>
                 <div class="progress">
                     <div class="progress-bar" style="width:10%"></div>
                 </div>
                 <br>
                 <!-- Green -->
                 <h6>Progress Bar 2</h6>
                 <div class="progress">
                     <div class="progress-bar bg-success" style="width:20%"></div>
                 </div>
                 <br>
                 <!-- Turquoise -->
                 <h6>Progress Bar 3</h6>
                 <div class="progress">
                     <div class="progress-bar bg-info" style="width:30%"></div>
                 </div>
                 <br>
                 <!-- Orange -->
                 <h6>Progress Bar 4</h6>
                 <div class="progress">
                     <div class="progress-bar bg-warning" style="width:40%"></div>
                 </div>
                 <br>

                 <!-- Red -->
                 <h6>Progress Bar 5</h6>
                 <div class="progress">
                     <div class="progress-bar bg-danger" style="width:50%"></div>
                 </div>
                 <br>

                 <!-- White -->
                 <h6>Progress Bar 6</h6>
                 <div class="progress border">
                     <div class="progress-bar bg-white" style="width:60%"></div>
                 </div>


                 <!-- Grey -->
                 <h6>Progress Bar 6</h6>
                 <div class="progress">
                     <div class="progress-bar bg-secondary" style="width:70%"></div>
                 </div>
                 <br>

                 <!-- Light Grey -->
                 <h6>Progress Bar 7</h6>
                 <div class="progress border">
                     <div class="progress-bar bg-light" style="width:80%"></div>
                 </div>
                 <br>
                 <!-- Dark Grey -->
                 <h6>Progress Bar 8</h6>
                 <div class="progress">
                     <div class="progress-bar bg-dark" style="width:90%"></div>
                 </div>


             </div>
             <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
         </div>
     </div>
     <!-- progress bars end -->


     <!-- meters starts-->

     <div class="col-md-6" style="margin-top: -20.5%">
         <div class="card mb-3" >
             <div class="card-header" style="color: #003399" >
                 <h5><span class="fa fa-tachometer"></span> Meters</h5></div>
             <div class="card-body">

                 <div id="meters" style="width: 100%; height: 100%;"></div>

                 <script type="text/javascript">
                     google.charts.load('current', {'packages':['gauge']});
                     google.charts.setOnLoadCallback(drawChart);

                     function drawChart() {

                         var data = google.visualization.arrayToDataTable([
                             ['Label', 'Value'],
                             ['Memory', 80],
                             ['CPU', 55],
                             ['Network', 68]
                         ]);

                         var options = {
                             width: 400, height: 120,
                             redFrom: 90, redTo: 100,
                             yellowFrom:75, yellowTo: 90,
                             minorTicks: 5
                         };

                         var chart = new google.visualization.Gauge(document.getElementById('meters'));

                         chart.draw(data, options);

                         setInterval(function() {
                             data.setValue(0, 1, 40 + Math.round(60 * Math.random()));
                             chart.draw(data, options);
                         }, 13000);
                         setInterval(function() {
                             data.setValue(1, 1, 40 + Math.round(60 * Math.random()));
                             chart.draw(data, options);
                         }, 5000);
                         setInterval(function() {
                             data.setValue(2, 1, 60 + Math.round(20 * Math.random()));
                             chart.draw(data, options);
                         }, 26000);
                     }
                 </script>

             </div>
             <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
         </div>
     </div>

     <!-- meters  ends-->


     <!-- forms starts -->

     <div class="col-md-12">
         <div class="card mb-3" >
             <div class="card-header" style="color: #003399" >
                 <h5><span class="fa fa-pencil"></span> Forms</h5></div>
             <div class="card-body">

                 <form>
                     <div class="form-row">
                         <div class="form-group col-md-6">
                             <label for="inputEmail4">Email</label>
                             <input type="email" class="form-control" id="inputEmail4" placeholder="Email">
                         </div>
                         <div class="form-group col-md-6">
                             <label for="inputPassword4">Password</label>
                             <input type="password" class="form-control" id="inputPassword4" placeholder="Password">
                         </div>
                     </div>
                     <div class="form-group">
                         <label for="inputAddress">Address</label>
                         <input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St">
                     </div>
                     <div class="form-group">
                         <label for="inputAddress2">Address 2</label>
                         <input type="text" class="form-control" id="inputAddress2" placeholder="Apartment, studio, or floor">
                     </div>
                     <div class="form-row">
                         <div class="form-group col-md-6">
                             <label for="inputCity">City</label>
                             <input type="text" class="form-control" id="inputCity">
                         </div>
                         <div class="form-group col-md-4">
                             <label for="inputState">State</label>
                             <select id="inputState" class="form-control">
                                 <option selected>Choose...</option>
                                 <option>...</option>
                             </select>
                         </div>
                         <div class="form-group col-md-2">
                             <label for="inputZip">Zip</label>
                             <input type="text" class="form-control" id="inputZip">
                         </div>
                     </div>
                     <div class="form-group">
                         <div class="form-check">
                             <input class="form-check-input" type="checkbox" id="gridCheck">
                             <label class="form-check-label" for="gridCheck">
                                 Check me out
                             </label>
                         </div>
                     </div>

                     <fieldset class="form-group">
                         <div class="row">
                             <legend class="col-form-label col-sm-2 pt-0">Radios</legend>
                             <div class="col-sm-10">
                                 <div class="form-check">
                                     <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios1" value="option1" checked>
                                     <label class="form-check-label" for="gridRadios1">
                                         First radio
                                     </label>
                                 </div>
                                 <div class="form-check">
                                     <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios2" value="option2">
                                     <label class="form-check-label" for="gridRadios2">
                                         Second radio
                                     </label>
                                 </div>
                                 <div class="form-check disabled">
                                     <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios3" value="option3" disabled>
                                     <label class="form-check-label" for="gridRadios3">
                                         Third disabled radio
                                     </label>
                                 </div>
                             </div>
                         </div>
                     </fieldset>
                    <div class="form-row">
                     <label class="sr-only" for="inlineFormInputName2">Name</label>
                     <input type="text" class="form-control mb-2 mr-sm-2 col-sm-4" id="inlineFormInputName2" placeholder="Jane Doe">

                     <label class="sr-only" for="inlineFormInputGroupUsername2">Username</label>
                     <div class="input-group mb-2 mr-sm-2 col-sm-4">
                         <div class="input-group-prepend">
                             <div class="input-group-text">@</div>
                         </div>
                         <input type="text" class="form-control" id="inlineFormInputGroupUsername2" placeholder="Username">
                     </div>

                     <div class="form-check mb-2 mr-sm-2">
                         <input class="form-check-input" type="checkbox" id="inlineFormCheck">
                         <label class="form-check-label" for="inlineFormCheck">
                             Remember me
                         </label>
                     </div>


             </div>

                     <button type="submit" class="btn btn-primary">Sign in</button>

                 </form>
     </div>
         </div>
     </div>

     <!-- forms ends-->

             <!-- cards starts-->
     <div class="col-md-12">
         <div class="card mb-3" >
             <div class="card-header" style="color: #003399" >
                 <h5><span class="fa fa-image"></span> Cards </h5></div>
             <div class="card-body">

             <div class="card-deck">
                 <div class="card">
                     <img class="card-img-top" src="Images/card1%20(2).jpg" alt="Card image cap">
                     <div class="card-body">
                         <h5 class="card-title">Card title</h5>
                         <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                     </div>
                     <div class="card-footer">
                         <small class="text-muted">Last updated 3 mins ago</small>
                     </div>
                 </div>
                 <div class="card">
                     <img class="card-img-top"src="Images/card1%20(1).jpg" alt="Card image cap">
                     <div class="card-body">
                         <h5 class="card-title">Card title</h5>
                         <p class="card-text">This card has supporting text below as a natural lead-in to additional content.</p>
                     </div>
                     <div class="card-footer">
                         <small class="text-muted">Last updated 3 mins ago</small>
                     </div>
                 </div>
                 <div class="card">
                     <img class="card-img-top" src="Images/card1%20(2).jpg" alt="Card image cap">
                     <div class="card-body">
                         <h5 class="card-title">Card title</h5>
                         <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This card has even longer content than the first to show that equal height action.</p>
                     </div>
                     <div class="card-footer">
                         <small class="text-muted">Last updated 3 mins ago</small>
                     </div>
                 </div>
             </div>
 </div>
        <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
    </div>
</div>

             <!--End of cards-->


     <!-- data table start -->


     <div class="col-md-12">
         <div class="card mb-3" >
             <div class="card-header" style="color: #003399" >
                 <h5><span class="fa fa-image"></span> Cards </h5></div>
             <div class="card-body">

                 <script>
                     $(document).ready(function() {
                         $('#example').DataTable();
                     } );
                 </script>

                 <table id="example" class="table table-striped table-bordered" style="width:100%">
                     <thead>
                     <tr>
                         <th>Name</th>
                         <th>Position</th>
                         <th>Office</th>
                         <th>Age</th>
                         <th>Start date</th>
                         <th>Salary</th>
                     </tr>
                     </thead>
                     <tbody>
                     <tr>
                         <td>Tiger Nixon</td>
                         <td>System Architect</td>
                         <td>Edinburgh</td>
                         <td>61</td>
                         <td>2011/04/25</td>
                         <td>$320,800</td>
                     </tr>
                     <tr>
                         <td>Garrett Winters</td>
                         <td>Accountant</td>
                         <td>Tokyo</td>
                         <td>63</td>
                         <td>2011/07/25</td>
                         <td>$170,750</td>
                     </tr>
                     <tr>
                         <td>Ashton Cox</td>
                         <td>Junior Technical Author</td>
                         <td>San Francisco</td>
                         <td>66</td>
                         <td>2009/01/12</td>
                         <td>$86,000</td>
                     </tr>
                     <tr>
                         <td>Cedric Kelly</td>
                         <td>Senior Javascript Developer</td>
                         <td>Edinburgh</td>
                         <td>22</td>
                         <td>2012/03/29</td>
                         <td>$433,060</td>
                     </tr>
                     <tr>
                         <td>Airi Satou</td>
                         <td>Accountant</td>
                         <td>Tokyo</td>
                         <td>33</td>
                         <td>2008/11/28</td>
                         <td>$162,700</td>
                     </tr>
                     <tr>
                         <td>Brielle Williamson</td>
                         <td>Integration Specialist</td>
                         <td>New York</td>
                         <td>61</td>
                         <td>2012/12/02</td>
                         <td>$372,000</td>
                     </tr>
                     <tr>
                         <td>Herrod Chandler</td>
                         <td>Sales Assistant</td>
                         <td>San Francisco</td>
                         <td>59</td>
                         <td>2012/08/06</td>
                         <td>$137,500</td>
                     </tr>
                     <tr>
                         <td>Rhona Davidson</td>
                         <td>Integration Specialist</td>
                         <td>Tokyo</td>
                         <td>55</td>
                         <td>2010/10/14</td>
                         <td>$327,900</td>
                     </tr>
                     <tr>
                         <td>Colleen Hurst</td>
                         <td>Javascript Developer</td>
                         <td>San Francisco</td>
                         <td>39</td>
                         <td>2009/09/15</td>
                         <td>$205,500</td>
                     </tr>
                     <tr>
                         <td>Sonya Frost</td>
                         <td>Software Engineer</td>
                         <td>Edinburgh</td>
                         <td>23</td>
                         <td>2008/12/13</td>
                         <td>$103,600</td>
                     </tr>
                     <tr>
                         <td>Jena Gaines</td>
                         <td>Office Manager</td>
                         <td>London</td>
                         <td>30</td>
                         <td>2008/12/19</td>
                         <td>$90,560</td>
                     </tr>
                     <tr>
                         <td>Quinn Flynn</td>
                         <td>Support Lead</td>
                         <td>Edinburgh</td>
                         <td>22</td>
                         <td>2013/03/03</td>
                         <td>$342,000</td>
                     </tr>
                     <tr>
                         <td>Charde Marshall</td>
                         <td>Regional Director</td>
                         <td>San Francisco</td>
                         <td>36</td>
                         <td>2008/10/16</td>
                         <td>$470,600</td>
                     </tr>
                     <tr>
                         <td>Haley Kennedy</td>
                         <td>Senior Marketing Designer</td>
                         <td>London</td>
                         <td>43</td>
                         <td>2012/12/18</td>
                         <td>$313,500</td>
                     </tr>
                     <tr>
                         <td>Tatyana Fitzpatrick</td>
                         <td>Regional Director</td>
                         <td>London</td>
                         <td>19</td>
                         <td>2010/03/17</td>
                         <td>$385,750</td>
                     </tr>
                     <tr>
                         <td>Michael Silva</td>
                         <td>Marketing Designer</td>
                         <td>London</td>
                         <td>66</td>
                         <td>2012/11/27</td>
                         <td>$198,500</td>
                     </tr>
                     <tr>
                         <td>Paul Byrd</td>
                         <td>Chief Financial Officer (CFO)</td>
                         <td>New York</td>
                         <td>64</td>
                         <td>2010/06/09</td>
                         <td>$725,000</td>
                     </tr>
                     <tr>
                         <td>Gloria Little</td>
                         <td>Systems Administrator</td>
                         <td>New York</td>
                         <td>59</td>
                         <td>2009/04/10</td>
                         <td>$237,500</td>
                     </tr>
                     <tr>
                         <td>Bradley Greer</td>
                         <td>Software Engineer</td>
                         <td>London</td>
                         <td>41</td>
                         <td>2012/10/13</td>
                         <td>$132,000</td>
                     </tr>
                     <tr>
                         <td>Dai Rios</td>
                         <td>Personnel Lead</td>
                         <td>Edinburgh</td>
                         <td>35</td>
                         <td>2012/09/26</td>
                         <td>$217,500</td>
                     </tr>
                     <tr>
                         <td>Jenette Caldwell</td>
                         <td>Development Lead</td>
                         <td>New York</td>
                         <td>30</td>
                         <td>2011/09/03</td>
                         <td>$345,000</td>
                     </tr>
                     <tr>
                         <td>Yuri Berry</td>
                         <td>Chief Marketing Officer (CMO)</td>
                         <td>New York</td>
                         <td>40</td>
                         <td>2009/06/25</td>
                         <td>$675,000</td>
                     </tr>
                     <tr>
                         <td>Caesar Vance</td>
                         <td>Pre-Sales Support</td>
                         <td>New York</td>
                         <td>21</td>
                         <td>2011/12/12</td>
                         <td>$106,450</td>
                     </tr>
                     <tr>
                         <td>Doris Wilder</td>
                         <td>Sales Assistant</td>
                         <td>Sidney</td>
                         <td>23</td>
                         <td>2010/09/20</td>
                         <td>$85,600</td>
                     </tr>
                     <tr>
                         <td>Angelica Ramos</td>
                         <td>Chief Executive Officer (CEO)</td>
                         <td>London</td>
                         <td>47</td>
                         <td>2009/10/09</td>
                         <td>$1,200,000</td>
                     </tr>
                     <tr>
                         <td>Gavin Joyce</td>
                         <td>Developer</td>
                         <td>Edinburgh</td>
                         <td>42</td>
                         <td>2010/12/22</td>
                         <td>$92,575</td>
                     </tr>
                     <tr>
                         <td>Jennifer Chang</td>
                         <td>Regional Director</td>
                         <td>Singapore</td>
                         <td>28</td>
                         <td>2010/11/14</td>
                         <td>$357,650</td>
                     </tr>
                     <tr>
                         <td>Brenden Wagner</td>
                         <td>Software Engineer</td>
                         <td>San Francisco</td>
                         <td>28</td>
                         <td>2011/06/07</td>
                         <td>$206,850</td>
                     </tr>
                     <tr>
                         <td>Fiona Green</td>
                         <td>Chief Operating Officer (COO)</td>
                         <td>San Francisco</td>
                         <td>48</td>
                         <td>2010/03/11</td>
                         <td>$850,000</td>
                     </tr>
                     <tr>
                         <td>Shou Itou</td>
                         <td>Regional Marketing</td>
                         <td>Tokyo</td>
                         <td>20</td>
                         <td>2011/08/14</td>
                         <td>$163,000</td>
                     </tr>
                     <tr>
                         <td>Michelle House</td>
                         <td>Integration Specialist</td>
                         <td>Sidney</td>
                         <td>37</td>
                         <td>2011/06/02</td>
                         <td>$95,400</td>
                     </tr>
                     <tr>
                         <td>Suki Burks</td>
                         <td>Developer</td>
                         <td>London</td>
                         <td>53</td>
                         <td>2009/10/22</td>
                         <td>$114,500</td>
                     </tr>
                     <tr>
                         <td>Prescott Bartlett</td>
                         <td>Technical Author</td>
                         <td>London</td>
                         <td>27</td>
                         <td>2011/05/07</td>
                         <td>$145,000</td>
                     </tr>
                     <tr>
                         <td>Gavin Cortez</td>
                         <td>Team Leader</td>
                         <td>San Francisco</td>
                         <td>22</td>
                         <td>2008/10/26</td>
                         <td>$235,500</td>
                     </tr>
                     <tr>
                         <td>Martena Mccray</td>
                         <td>Post-Sales support</td>
                         <td>Edinburgh</td>
                         <td>46</td>
                         <td>2011/03/09</td>
                         <td>$324,050</td>
                     </tr>
                     <tr>
                         <td>Unity Butler</td>
                         <td>Marketing Designer</td>
                         <td>San Francisco</td>
                         <td>47</td>
                         <td>2009/12/09</td>
                         <td>$85,675</td>
                     </tr>
                     <tr>
                         <td>Howard Hatfield</td>
                         <td>Office Manager</td>
                         <td>San Francisco</td>
                         <td>51</td>
                         <td>2008/12/16</td>
                         <td>$164,500</td>
                     </tr>
                     <tr>
                         <td>Hope Fuentes</td>
                         <td>Secretary</td>
                         <td>San Francisco</td>
                         <td>41</td>
                         <td>2010/02/12</td>
                         <td>$109,850</td>
                     </tr>
                     <tr>
                         <td>Vivian Harrell</td>
                         <td>Financial Controller</td>
                         <td>San Francisco</td>
                         <td>62</td>
                         <td>2009/02/14</td>
                         <td>$452,500</td>
                     </tr>
                     <tr>
                         <td>Timothy Mooney</td>
                         <td>Office Manager</td>
                         <td>London</td>
                         <td>37</td>
                         <td>2008/12/11</td>
                         <td>$136,200</td>
                     </tr>
                     <tr>
                         <td>Jackson Bradshaw</td>
                         <td>Director</td>
                         <td>New York</td>
                         <td>65</td>
                         <td>2008/09/26</td>
                         <td>$645,750</td>
                     </tr>
                     <tr>
                         <td>Olivia Liang</td>
                         <td>Support Engineer</td>
                         <td>Singapore</td>
                         <td>64</td>
                         <td>2011/02/03</td>
                         <td>$234,500</td>
                     </tr>
                     <tr>
                         <td>Bruno Nash</td>
                         <td>Software Engineer</td>
                         <td>London</td>
                         <td>38</td>
                         <td>2011/05/03</td>
                         <td>$163,500</td>
                     </tr>
                     <tr>
                         <td>Sakura Yamamoto</td>
                         <td>Support Engineer</td>
                         <td>Tokyo</td>
                         <td>37</td>
                         <td>2009/08/19</td>
                         <td>$139,575</td>
                     </tr>
                     <tr>
                         <td>Thor Walton</td>
                         <td>Developer</td>
                         <td>New York</td>
                         <td>61</td>
                         <td>2013/08/11</td>
                         <td>$98,540</td>
                     </tr>
                     <tr>
                         <td>Finn Camacho</td>
                         <td>Support Engineer</td>
                         <td>San Francisco</td>
                         <td>47</td>
                         <td>2009/07/07</td>
                         <td>$87,500</td>
                     </tr>
                     <tr>
                         <td>Serge Baldwin</td>
                         <td>Data Coordinator</td>
                         <td>Singapore</td>
                         <td>64</td>
                         <td>2012/04/09</td>
                         <td>$138,575</td>
                     </tr>
                     <tr>
                         <td>Zenaida Frank</td>
                         <td>Software Engineer</td>
                         <td>New York</td>
                         <td>63</td>
                         <td>2010/01/04</td>
                         <td>$125,250</td>
                     </tr>
                     <tr>
                         <td>Zorita Serrano</td>
                         <td>Software Engineer</td>
                         <td>San Francisco</td>
                         <td>56</td>
                         <td>2012/06/01</td>
                         <td>$115,000</td>
                     </tr>
                     <tr>
                         <td>Jennifer Acosta</td>
                         <td>Junior Javascript Developer</td>
                         <td>Edinburgh</td>
                         <td>43</td>
                         <td>2013/02/01</td>
                         <td>$75,650</td>
                     </tr>
                     <tr>
                         <td>Cara Stevens</td>
                         <td>Sales Assistant</td>
                         <td>New York</td>
                         <td>46</td>
                         <td>2011/12/06</td>
                         <td>$145,600</td>
                     </tr>
                     <tr>
                         <td>Hermione Butler</td>
                         <td>Regional Director</td>
                         <td>London</td>
                         <td>47</td>
                         <td>2011/03/21</td>
                         <td>$356,250</td>
                     </tr>
                     <tr>
                         <td>Lael Greer</td>
                         <td>Systems Administrator</td>
                         <td>London</td>
                         <td>21</td>
                         <td>2009/02/27</td>
                         <td>$103,500</td>
                     </tr>
                     <tr>
                         <td>Jonas Alexander</td>
                         <td>Developer</td>
                         <td>San Francisco</td>
                         <td>30</td>
                         <td>2010/07/14</td>
                         <td>$86,500</td>
                     </tr>
                     <tr>
                         <td>Shad Decker</td>
                         <td>Regional Director</td>
                         <td>Edinburgh</td>
                         <td>51</td>
                         <td>2008/11/13</td>
                         <td>$183,000</td>
                     </tr>
                     <tr>
                         <td>Michael Bruce</td>
                         <td>Javascript Developer</td>
                         <td>Singapore</td>
                         <td>29</td>
                         <td>2011/06/27</td>
                         <td>$183,000</td>
                     </tr>
                     <tr>
                         <td>Donna Snider</td>
                         <td>Customer Support</td>
                         <td>New York</td>
                         <td>27</td>
                         <td>2011/01/25</td>
                         <td>$112,000</td>
                     </tr>
                     </tbody>
                     <tfoot>
                     <tr>
                         <th>Name</th>
                         <th>Position</th>
                         <th>Office</th>
                         <th>Age</th>
                         <th>Start date</th>
                         <th>Salary</th>
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
<script type="text/javascript" src="Styles/js/popper.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script type="text/javascript" src="Styles/js/bootstrap.min.js"></script>
<!-- MDB core JavaScript -->
<script src="https://maps.googleapis.com/maps/api/js?callback=myMap"></script>

<script type="text/javascript" src="Styles/js/mdb.min.js"></script>
</body>
</html>

