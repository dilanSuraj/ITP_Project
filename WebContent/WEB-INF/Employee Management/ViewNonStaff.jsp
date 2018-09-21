<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
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
    <link rel="stylesheet" href="css/dataTables.bootstrap4.min.css">

    <title>Sumith Tyres pvt Ltd</title>
</head>

<body>


<!-- start of the the navigation header-->

 <%@ include file="/WEB-INF/PageSegments/EmployeeManagement/_navigationheaderHR.jsp" %>
	<!-- end of the navigation header-->

	<!-- side bar starts -->

	<!-- only visibale in 10'0 inch or above screens-->
	<%@ include file="/WEB-INF/PageSegments/EmployeeManagement/_sidebarHR.jsp" %>

	<!--side bar end-->
    <%@ include file="/WEB-INF/PageSegments/EmployeeManagement/_cardsHR.jsp" %>

        <!-- topic bar starts-->

        <ol class="breadcrumb" style="margin-top:10px;margin-bottom: 10px">
            <li class="breadcrumb-item">
                <a href="#" style="color: #003399 ">Dashboard</a>
            </li>
            <li class="breadcrumb-item active">Navbar</li>
        </ol>

        <!-- topic bar end-->
<div class="text-center"><h1 > Temporary Employee Information </h1></div>

        <div class="row">




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
                              	<th>ID</th>
                            	<th>FULLNAME</th>
                                <th>NIC</th>
                                <th>ADDRESS</th>
                                <th>AGE</th>
                                
                                <th>Basic Salary</th>
                                <th>PHONENO</th>
                                <th>GENDER</th>
                                <th>OT</th>
                                <th>ROLE</th>
                                <th>TOTALSAL</th>
                                <th>MONTH</th>
                                <th>YEAR</th>
                                 <th>EDIT</th>
                             
                               
                            </tr>
                            </thead>
                            <tbody>
                          
                     
                           <c:forEach var="emplist" items="${emplist}"
							varStatus="status">
							<tr>

								
								<td>${emplist.getId()} </td>
								<td>${emplist.getFullname()}</td>
								<td>${emplist.getNIC()}</td>
								<td>${emplist.getAddress()}</td>
								<td>${emplist.getAge()}</td>
								<td>${emplist.getSalary()}</td>
								<td>${emplist.getPhoneno()}</td>
								<td>${emplist.getGender()}</td>
								<td>${emplist.getOt()}</td>
								<td>${emplist.getRole()}</td>
								<td>${emplist.getTotalsal()}</td>
								<td>${emplist.getMonth()}</td>
								<td>${ emplist.getYear()}</td>
								<td><a href="<c:url value='/UpdateNonStaff?id=${emplist.getId()}' />" >EDIT</a></td>
								
								
							
						</c:forEach>
                     
                     
                     
                     
                     
                     </tr>
                    
                     
                            </tbody>
                           
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



    </div>


</div>

</body>
</html>