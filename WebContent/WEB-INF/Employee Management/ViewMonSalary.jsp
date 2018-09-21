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


 <%@ include file="/WEB-INF/PageSegments/EmployeeManagement/_navigationheader.jsp" %>
	<!-- end of the navigation header-->

	<!-- side bar starts -->

	<!-- only visibale in 10'0 inch or above screens-->
	<%@ include file="/WEB-INF/PageSegments/EmployeeManagement/_sidebar.jsp" %>

	<!--side bar end-->
    <%@ include file="/WEB-INF/PageSegments/EmployeeManagement/_cards.jsp" %>

        <!-- topic bar end-->
	<div class="text-center"><h1 > Salary  Information </h1></div>

        <div class="row">




            <!-- data table start -->

							
            <div class="col-md-12">
                <div class="card mb-3" >
                    <div class="card-header" style="color: #003399" >
                        <h5><span class="fa fa-image"></span>  </h5></div>
                    <div class="card-body">

                        <script>
                            $(document).ready(function() {
                                $('#example').DataTable();
                            } );
                        </script>

                        <table id="example" class="table table-striped table-bordered" style="width:100%">
                            <thead>
                            <tr>
                            	<th>E.M.S ID</th>
                            	<th>Month</th>
                                <th>Year</th>
                                <th>Salary</th>
                                <th>Status</th>
                                <th>Date</th>
                                <th>Category</th>
                                <th>Emp_Sal_EmpID</th>
                                
                                
                                
                                 <th>EDIT</th>
                                 <th>DELETE</th>
                            </tr>
                            </thead>
                            <tbody>
                        
                           
                            <c:forEach var="slist" items="${slist}"
							varStatus="status">
							<tr>

								<td>${slist.getEmp_month_sal_ID()} </td>
								<td>${slist.getEmp_month_sal_month() }</td>
								<td>${slist.getEmp_month_sal_year()}</td>
								<td>${slist.getEmp_month_sal_amount()}</td>
								<td>${slist.getEmp_month_sal_status()}</td>
								<td>${slist.getEmp_month_sal_date()}</td>
								<td>${slist.getEmp_month_sal_category()}</td>
								<td>${slist.getEmp_month_sal_empID()}</td>
								
								
								<td><a href="<c:url value='/UpdateMonSalary?emp_month_sal_ID=${slist.getEmp_month_sal_ID()}' />" >EDIT</a></td>
								<td><a href="<c:url value='/DeleteSalaryPOST?emp_month_sal_ID=${slist.getEmp_month_sal_ID()}' />" >DELETE</a></td>
							</tr>
						</c:forEach>
                         
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