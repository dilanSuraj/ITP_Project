<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">

<!-- Bootstrap core CSS -->
<link href="Styles/css/bootstrap.min.css" rel="stylesheet">

<!-- Your custom styles -->
<link rel="stylesheet" href="Styles/css/dashboardStyleSheet.css">
<link rel="stylesheet" href="Styles/css/customStyle.css">

<!-- font awesome icon pack-->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<title>Sumith Tyres pvt Ltd</title>
</head>
<body>

<%@include file="/WEB-INF/OrderManagment/RetailerOrder/RetailerDashbordnavBar.jsp" %>

<div class="row justify-content-end " >
    <div class="col-md-10" style="padding-top: 90px;padding-left: 40px;padding-right: 40px">
        <!--center edit start -->

        <div class="container" style="margin-top: 80px ">
            <div class="row">
            <div class="col-md-5">
                <a href="https://placeholder.com"><img src="http://via.placeholder.com/350x350" ></a>
            </div>

            <div class="col-md-6">
                <br>
               <h2 class="text-custom">${Item.item_name}</h2>
                <br>
                <h4 class="text-custom">Rs.5347.00 per unit</h4>
                <br>
                <form class="form-group">
                    <label class="text-custom">Amount :</label>
                    <input  type="number" name="amount" class="form-control col-md-4">
                    <br>
                    <button type="submit" class="btn btn-primary btn-sm" style="margin-top: 10px;margin-bottom: 10px">Add to cart</button>
                </form>

            </div>


            </div>
        </div>

    </div>
</div>

   <!-- Bootstrap tooltips -->
        <script type="text/javascript" src="js/popper.min.js"></script>
        <!-- Bootstrap core JavaScript -->
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <!-- MDB core JavaScript -->
        <script src="https://maps.googleapis.com/maps/api/js?callback=myMap"></script>

        <script type="text/javascript" src="js/mdb.min.js"></script>
        
</body>
</html>