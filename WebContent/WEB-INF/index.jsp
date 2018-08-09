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
    <!-- Your custom styles (optional) -->
    <link rel="stylesheet" href="Styles/css/customStyle.css">

    <!-- font awesome icon pack-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <title>Sumith Tyres pvt Ltd</title>
</head>

<body>
<!-- create a sapare file for nav bar later -->
<!--Main Navigation-->
<header>
    <nav class="navbar fixed-top navbar-expand-lg navbar-dark scrolling-navbar" style="padding-right: 5%;padding-left:5%">

        <a class="navbar-brand " href="#"   style="padding-right: 3%"> <img class="logo" src="Styles/Images/logo.png" alt="Home"></a>

        <div class="d-none d-md-block d-lg-none">
            <form class="form-inline" >
                <input class="form-control mr-sm-2 " type="search" placeholder="Search" aria-label="Search" style="height: 32.5px">
                <button class="btn btn-sm btn-outline-light " type="submit">Search</button>
            </form>
        </div>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Products <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">About Us</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Contac Us </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="#">Services Us </a>
                </li>

                <li class="nav-item">

                    <div class="d-none d-sm-block d-md-none  d-block d-sm-none">

                        <form class="form-inline" >
                            <input class="form-control mr-sm-2 " type="search" placeholder="Search" aria-label="Search" style="height: 32.5px">
                            <button class="btn btn-sm btn-outline-light my-2 my-sm-0" type="submit" >Search</button>
                        </form>

                    </div>

                </li>
            </ul>


            <div class="d-md-none d-lg-block d-none d-sm-block"  >
                <div class="d-sm-none d-md-block">
                    <form class="form-inline my-2 my-lg-0" >
                        <input class="form-control mr-sm-2 " type="search" placeholder="Search" aria-label="Search" style="height: 32.5px">
                        <button class="btn btn-sm btn-outline-light my-2 my-sm-0" type="submit" >Search</button>
                    </form>
                </div>
            </div>
        </div>
    </nav>
</header>

<!-- create a sapare file for nav bar later -->

<div class="d-none d-md-block">
    <div id="carouselExampleIndicators" class="carousel slide hidden-sm-down" data-ride="carousel">
        <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
        </ol>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img class="d-block w-100" src="Styles/Images/Image1.jpg" alt="First slide">

                <div class="carousel-caption d-none d-md-block" style="padding-bottom: 17%">
                    <h1>Sumith Tyre House </h1>
                    <p>Best Solution for Tyers,Batteries and Alloy wheels </p>
                </div>
            </div>
            <div class="carousel-item">
                <img class="d-block w-100" src="Styles/Images/Image2.jpg" alt="Second slide">

                <div class="carousel-caption d-none d-md-block" style="padding-bottom: 17%">
                    <h1>Sumith Tyre House </h1>
                    <p>Best Solution for Tyers,Batteries and Alloy wheels </p>
                </div>
            </div>
            <div class="carousel-item">
                <img class="d-block w-100" src="Styles/Images/Image3.jpg" alt="Third slide">

                <div class="carousel-caption d-none d-md-block" style="padding-bottom: 17%">
                    <h1>Sumith Tyre House </h1>
                    <p>Best Solution for Tyers,Batteries and Alloy wheels </p>
                </div>

            </div>

            <div class="carousel-item">
                <img class="d-block w-100" src="Styles/Images/Image4.jpg" alt="Third slide">
                <div class="carousel-caption d-none d-md-block" style="padding-bottom: 17%">
                    <h1>Sumith Tyre House </h1>
                    <p>Best Solution for Tyers,Batteries and Alloy wheels </p>
                </div>
            </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>

</div>

<!-- middle-->

<h4 class="text-center py-4">Two equal columns layout</h4>
<div class="col-md-12" style="padding-left:1.5%;padding-right: 1.5%;">
<div class="row">
    <div class=" col-lg-3 col-md-6 mb-4">
        <div class="card default-color-dark">
            <!--Card image-->
            <div class="view">
                <img src="Styles/Images/card1%20(2).jpg"  class="card-img-top" alt="photo">
                <a href="#">
                    <div class="mask rgba-white-slight"></div>
                </a>
            </div>
            <!--Card content-->
            <div class="card-body text-center">
                <!--Title-->
                <h4 class="card-title white-text">Title of the news</h4>
                <!--Text-->
                <p class="card-text white-text">Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas.</p>
                <a href="#" class="btn btn-outline-white btn-md waves-effect">Button</a>
            </div>

        </div>
        <!--/.Card-->

    </div>

    <div class="col-lg-3 col-md-6 mb-4">
        <div class="card default-color-dark">
            <!--Card image-->
            <div class="view">
                <img src="Styles/Images/card1%20(2).jpg" class="card-img-top" alt="photo">
                <a href="#">
                    <div class="mask rgba-white-slight"></div>
                </a>
            </div>
            <!--Card content-->
            <div class="card-body text-center">
                <!--Title-->
                <h4 class="card-title white-text">Title of the news</h4>
                <!--Text-->
                <p class="card-text white-text">Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas.</p>
                <a href="#" class="btn btn-outline-white btn-md waves-effect">Button</a>
            </div>

        </div>
        <!--/.Card-->

    </div>

    <div class="col-lg-3 col-md-6 mb-4">
        <div class="card default-color-dark">
            <!--Card image-->
            <div class="view">
                <img src="Styles/Images/card1%20(2).jpg" class="card-img-top" alt="photo">
                <a href="#">
                    <div class="mask rgba-white-slight"></div>
                </a>
            </div>
            <!--Card content-->
            <div class="card-body text-center">
                <!--Title-->
                <h4 class="card-title white-text">Title of the news</h4>
                <!--Text-->
                <p class="card-text white-text">Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas.</p>
                <a href="#" class="btn btn-outline-white btn-md waves-effect">Button</a>
            </div>

        </div>


        <!--/.Card-->

    </div>

    <div class="col-lg-3 col-md-6 mb-4">
        <div class="card default-color-dark">
            <!--Card image-->
            <div class="view">
                <img src="Styles/Images/card1%20(2).jpg" class="card-img-top" alt="photo">
                <a href="#">
                    <div class="mask rgba-white-slight"></div>
                </a>
            </div>
            <!--Card content-->
            <div class="card-body text-center">
                <!--Title-->
                <h4 class="card-title white-text">Title of the news</h4>
                <!--Text-->
                <p class="card-text white-text">Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas.</p>
                <a href="#" class="btn btn-outline-white btn-md waves-effect">Button</a>
            </div>

        </div>
        <!--/.Card-->

    </div>

</div>

</div>


<!-- Footer -->
<div>
    <div class="navbar navbar-dark " style="background-color: #2e2e2e; padding-right: 5%;padding-left:5%">

<div class="col-md-6">
    <center>        <h6 CLASS="navbar-brand">Get connected with us on social networks!</h6></center>

</div>
        <div class="col-md-6 ">
            <center>
        <a href="#"> <img src="Styles/Images/Social_icons/fb.png" class="social-icon"> </a>

        <a href="#"> <img src="Styles/Images/Social_icons/insta.png" class="social-icon"> </a>

        <a href="#" > <img src="Styles/Images/Social_icons/twitter.png" class="social-icon"> </a>

            </center>
        </div>

    </div>

</div>

<div class="row" style="background-color: #003399">
<div class="col-lg-6" style="padding: 2%">
    <center>
        <div   id="map" style="width:80%;height: 300px" >map</div>
    </center>
</div>

    <div class="col-lg-3" style="padding: 2%">
        <center>
            <div style="color: white">

                <p><span class="fa fa-home"  aria-hidden="true" style="font-size:28px;" ></span></p>
                <p>Sumith Tyre Center (PVT) LTD,</p>
                    <p> Negombo Road,</p>
                    <p>Kurunegala,</p>
                    <p>North Western Province.</p>

                <p><span class="fa fa-phone"  aria-hidden="true" style="font-size:28px;" ></span></p>
                <p>+123 3459 3556</p>
            </div>
        </center>
    </div>

    <div class="col-lg-3" style="padding: 2%">
        <center>
            <div style="color: white">

                <h5><span class="fa fa-globe"></span>  Quick Links</h5>

                <p style="padding-top: 12px">Link 1</p>
                <p>Link 1</p>
                <p>Link 1</p>
                <p>Link 1</p>
            </div>
        </center>
    </div>



</div>

<div style="background-color: #1a237e;color: white;font-family:'28 Days Later'">
    <center>

    <p>© 2018 Copyright: chamika</p>

    </center>

</div>



    <script type="text/javascript">
        function myMap() {
            var mapOptions = {
                center: new google.maps.LatLng(7.4807351,80.3436382),
                zoom: 17,
                mapTypeId: google.maps.MapTypeId.HYBRID
            }
            var map = new google.maps.Map(document.getElementById("map"), mapOptions);
        }

    </script>

    <!-- end of footer-->
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script type="text/javascript" src="Styles/js/jquery-3.3.1.min.js"></script>
<!-- Bootstrap tooltips -->
<script type="text/javascript" src="Styles/js/popper.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script type="text/javascript" src="Styles/js/bootstrap.min.js"></script>
<!-- MDB core JavaScript -->
    <script src="https://maps.googleapis.com/maps/api/js?callback=myMap"></script>

    <script type="text/javascript" src="Styles/js/mdb.min.js"></script>
<script>
    // Animations initialization
    new WOW().init();
</script>
</body>
</html>