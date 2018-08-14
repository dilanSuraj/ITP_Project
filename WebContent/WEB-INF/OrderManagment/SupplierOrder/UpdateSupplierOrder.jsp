<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
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
    <link href="Styles/css/customText.css" rel="stylesheet">
    <!-- font awesome icon pack-->
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <!--java scrip file for google charts-->
    <script type="text/javascript"
            src="https://www.gstatic.com/charts/loader.js"></script>

    <!--google maps library -->
    <script
            src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY&callback=myMap"></script>

    <!--data table files -->
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossorigin="anonymous">
    <script type="text/javascript" src="Styles/js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="Styles/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript"
            src="Styles/js/dataTables.bootstrap4.min.js"></script>
    <link rel="stylesheet" href="Styles/css/dataTables.bootstrap4.min.css">

    <title>Sumith Tyres pvt Ltd</title>
</head>

<body>

	<%@include file="/WEB-INF/OrderManagment/SupplierOrder/storeManagerNavBar.jsp"%>


<div class="row justify-content-end ">
    <div class="col-md-10"
         style="padding-top: 90px; padding-left: 40px; padding-right: 40px">
        <!--center edit start -->

  <!-- forms starts -->

        <div class="col-md-12">
            <div class="card mb-3" >
                <div class="card-header" style="color: #003399" >
                    <h5><span class="fa fa-pencil"></span> Update Supplier Order <Item></Item></h5></div>
                <div class="card-body">

                    <div class="form-row">
                        <div class="form-group col-md-5">
                            <select id="Supplier" class="form-control">
                                <option selected>Choose Supplier...</option>
                                <option>...</option>
                            </select>
                        </div>
                            <div>

                            <button type="submit" class="btn btn-primary" style="width: 90px;"><i class="fa fa-refresh" aria-hidden="true"></i> Refresh</button>
                            </div>
                            </div>
                            <div class="container">
                        <table id="cart" class="table table-hover table-condensed">
                            <thead>
                            <tr>
                                <th style="width:45%">Product</th>
                                <th style="width:12%">Currnet Order</th>
                                <th style="width:12%">New Quantity</th>
                                <th style="width:10%"></th>
                            </tr>
                            </thead>
                            <tbody>

                            <tr>
                                <td data-th="Product">
                                    <div class="row">
                                        <div class="col-sm-9">
                                            <h5 class="nomargin">Product 1</h5>
                                        </div>
                                    </div>
                                </td>
                                <td data-th="Price">200</td>
                                <td data-th="Quantity">
                                    <input type="number" class="form-control text-center" value="1">
                                </td>
                                <td class="actions" data-th="">
                                    <button class="btn btn-info"></i>Update</button>
                                </td>
                            </tr>


                            <tr>
                                <td data-th="Product">
                                    <div class="row">
                                        <div class="col-sm-9">
                                            <h5 class="nomargin">Product 5</h5>
                                        </div>
                                    </div>
                                </td>
                                <td data-th="Price">100</td>
                                <td data-th="Quantity">
                                    <input type="number" class="form-control text-center" value="1">
                                </td>
                                <td class="actions" data-th="">
                                    <button class="btn btn-info"></i>Update</button>
                                </td>
                            </tr>




                            <tr>
                                <td data-th="Product">
                                    <div class="row">
                                        <div class="col-sm-9">
                                            <h5 class="nomargin">Product 3</h5>
                                        </div>
                                    </div>
                                </td>
                                <td data-th="Price">400</td>
                                <td data-th="Quantity">
                                    <input type="number" class="form-control text-center" value="1">
                                </td>
                                <td class="actions" data-th="">
                                    <button class="btn btn-info"></i>Update</button>
                                </td>
                            </tr>



                            <tr>
                                <td data-th="Product">
                                    <div class="row">
                                        <div class="col-sm-9">
                                            <h5 class="nomargin">Product 2</h5>
                                        </div>
                                    </div>
                                </td>
                                <td data-th="Price">100</td>
                                <td data-th="Quantity">
                                    <input type="number" class="form-control text-center" value="1">
                                </td>
                                <td class="actions" data-th="">
                                    <button class="btn btn-info"></i>Update</button>
                                </td>
                            </tr>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>

<!-- Bootstrap tooltips -->
<script type="text/javascript" src="Styles/js/popper.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script type="text/javascript" src="Styles/js/bootstrap.min.js"></script>
<!-- MDB core JavaScript -->
<script src="https://maps.googleapis.com/maps/api/js?callback=myMap"></script>

<script type="text/javascript" src="Styles/js/mdb.min.js"></script>
</body>
</html>

