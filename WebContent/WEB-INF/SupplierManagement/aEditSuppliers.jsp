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

    <title>Edit Suppliers</title>
</head>

<body>


<!-- start of the the navigation header-->

<%@include file="/WEB-INF/SupplierManagement/SupplierAdminNavBar.jsp"%>
<!-- end of the navigation header-->



<div class="row justify-content-end " >
    <div class="col-md-10" style="padding-top: 90px;padding-left: 40px;padding-right: 40px">
        <!--center edit start -->






        <!-- forms starts -->
        <div class="col-md-12">
            <div class="card mb-3" >
                <div class="card-header" style="color: #003399" >
                    <h5><span class="fa fa-pencil"></span>Edit Form</h5></div>
                <div class="card-body">

                    <form:form method="post" action="Update_Supplier_Post1" modelAttribute="supplier">

                        <div class="form-group">
                            <label for="inputEmail4">Name</label>
                            <form:input type="text" class="form-control"  path="supplier_name" required="required"></form:input>
                        </div>

                        <div class="form-group">
                            <label for="inputEmail4">Company Name</label>
                            <form:input type="text" class="form-control" path="supplier_companyname" required="required"></form:input>
                        </div>

                        <div class="form-group">
                            <label for="inputAddress">Address</label>
                            <form:input type="text" class="form-control"  path="supplier_address" required="required"></form:input>
                        </div>
                        <div class="form-group">
                            <label for="contactNo">Contact No</label>
                            <form:input type="number" class="form-control"  path="supplier_contactno" required="required"></form:input>
                        </div>
                        
                            
                            <form:input type="hidden"   path="supplier_regNo" ></form:input>
                            
                           	
                        
                         <form:input  type="hidden"  path="supplier_ID"/>	
                        <button type="submit" class="btn btn-primary">Update</button>
                        <button type="reset" class="btn btn-primary">Reset</button>

                    </form:form>
                </div>
            </div>
        </div>





        <!-- forms ends-->



        <!-- /.content-wrapper-->


        <!-- Bootstrap tooltips -->
        <script type="text/javascript" src="Styles/js/popper.min.js"></script>
        <!-- Bootstrap core JavaScript -->
        <script type="text/javascript" src="Styles/js/bootstrap.min.js"></script>
        <!-- MDB core JavaScript -->
        <script src="https://maps.googleapis.com/maps/api/js?callback=myMap"></script>

        <script type="text/javascript" src="Styles/js/mdb.min.js"></script>
    </div>
</div>
</body>
</html>