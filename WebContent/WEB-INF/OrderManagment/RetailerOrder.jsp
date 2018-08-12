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
<link rel="stylesheet" href="Styles/css/shopping%20cart.css">

<!-- font awesome icon pack-->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">



    <script type="Styles/text/javascript" src="js/jquery-3.3.1.js"></script>
    <script type="Styles/text/javascript" src="js/paginationList.js"></script>+
    
<title>Sumith Tyres pvt Ltd</title>

</head>
<body>
	<%@include file="/WEB-INF/OrderManagment/RetailerDashbordnavBar.jsp"%>


<div class="row justify-content-end " >
    <div class="col-md-10" style="padding-top: 90px;padding-left: 40px;padding-right: 40px">
        <!--center edit start -->

        <ol class="breadcrumb" style="margin-top:10px;margin-bottom: 10px">
            <li class="breadcrumb-item">
                <p style="color: #003399;margin-bottom: -2px ">Order </p>
            </li>
        </ol>

        <div class="container">
            <table id="cart" class="table table-hover table-condensed">
                <thead>
                <tr>
                    <th style="width:45%">Product</th>
                    <th style="width:15%">Unit Price</th>
                    <th style="width:8%">Quantity</th>
                    <th style="width:22%" class="text-center">Subtotal</th>
                    <th style="width:10%"></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td data-th="Product">
                        <div class="row">
                            <div class="col-sm-3 hidden-xs"><img src="http://placehold.it/100x100" alt="..." class="img-responsive" /></div>
                            <div class="col-sm-9">
                                <h5 class="nomargin">Product 1</h5>
                            </div>
                        </div>
                    </td>
                    <td data-th="Price">$199</td>
                    <td data-th="Quantity">100</td>
                    <td data-th="Subtotal" class="text-center">1.99</td>
                    <td class="actions" data-th="">
                        <button class="btn btn-danger btn-sm"><i class="fa fa-trash-o"></i></button>
                    </td>
                </tr>

                <tr>
                    <td data-th="Product">
                        <div class="row">
                            <div class="col-sm-3 hidden-xs"><img src="http://placehold.it/100x100" alt="..." class="img-responsive" /></div>
                            <div class="col-sm-9">
                                <h5 class="nomargin">Product 1</h5>
                            </div>
                        </div>
                    </td>
                    <td data-th="Price">$199</td>
                    <td data-th="Quantity">100</td>
                    <td data-th="Subtotal" class="text-center">1.99</td>
                    <td class="actions" data-th="">
                        <button class="btn btn-danger btn-sm"><i class="fa fa-trash-o"></i></button>
                    </td>
                </tr><tr>
                    <td data-th="Product">
                        <div class="row">
                            <div class="col-sm-3 hidden-xs"><img src="http://placehold.it/100x100" alt="..." class="img-responsive" /></div>
                            <div class="col-sm-9">
                                <h5 class="nomargin">Product 1</h5>
                            </div>
                        </div>
                    </td>
                    <td data-th="Price">$199</td>
                    <td data-th="Quantity">100</td>
                    <td data-th="Subtotal" class="text-center">1.99</td>
                    <td class="actions" data-th="">
                        <button class="btn btn-danger btn-sm"><i class="fa fa-trash-o"></i></button>
                    </td>
                </tr><tr>
                    <td data-th="Product">
                        <div class="row">
                            <div class="col-sm-3 hidden-xs"><img src="http://placehold.it/100x100" alt="..." class="img-responsive" /></div>
                            <div class="col-sm-9">
                                <h5 class="nomargin">Product 1</h5>
                            </div>
                        </div>
                    </td>
                    <td data-th="Price">$199</td>
                    <td data-th="Quantity">100</td>
                    <td data-th="Subtotal" class="text-center">1.99</td>
                    <td class="actions" data-th="">
                        <button class="btn btn-danger btn-sm"><i class="fa fa-trash-o"></i></button>
                    </td>
                </tr>



                </tbody>
                <tfoot>
                <tr>
                    <td></td>
                    <td colspan="2" class="hidden-xs"></td>
                    <td class="hidden-xs text-center"><strong>Total $1.99</strong></td>
                    <td><a href="#" class="btn btn-success btn-block">Checkout <i class="fa fa-angle-right"></i></a></td>
                </tr>
                </tfoot>
            </table>
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