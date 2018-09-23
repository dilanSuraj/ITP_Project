<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar fixed-top navbar-expand-lg navbar-dark"
		style="background-color: #003399;color: white"> <a
		class="navbar-brand " href="#" style="padding-right: 3%"> <img
		class="logo" src="Styles/Images/logo.png" alt="Home"></a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNav" aria-controls="navbarNav"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="navbar-collapse collapse w-100 order-3 dual-collapse2"
		id="navbarNav">
		<ul class="navbar-nav ml-auto navbar-icons">

			<!-- side bar items to navigation bar only for the screen sizes below  7'0 tab-->
			<!-- you need to give the same links in the side bar to this links -->

			<div class="d-block d-md-none">
				<li class="nav-item "><a class="nav-link" href="#"
					style="color: white"> <span class="fa fa-pencil-square-o "
						style="font-size: 18px"></span> Home
				</a></li>

				<li class="nav-item"><a class="nav-link" href="#"
					style="color: white"><span class="fa fa-plus "
						style="font-size: 18px"></span> Link</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" style="color: white"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"><span class="fa fa-bar-chart "
						style="font-size: 18px"></span> Charts </a>
					<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
						<a class="dropdown-item" href="#" style="color: black">Action</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#" style="color: black">Another
							action</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#" style="color: black">Something
							else here</a>
					</div></li>

				<li class="nav-item"><a class="nav-link " href="#"
					style="color: white"><span class="fa fa-clone"
						style="font-size: 18px"></span> Files</a></li>

				<li class="nav-item"><a class="nav-link " href="#"
					style="color: white"><span class="fa fa-database"
						style="font-size: 18px"></span> Files</a></li>

				<li class="nav-item"><a class="nav-link" href="#"
					style="color: white"><span class="fa fa-envelope"
						style="font-size: 18px"></span> Messages</a></li>
			</div>

			<!-- end of side bar links to nav bar -->

			<li class="nav-item">
				<div class="dropdown ">
					<p class=" dropdown-toggle" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false">
						<span class="fa fa-envelope navbarIcon" style="font-size: 20px"></span>
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
					<p class=" dropdown-toggle" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false">
						<span class="fa fa-bell navbarIcon" style="font-size: 20px"></span>
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

			<li class="nav-item"><a href="#" class="admin-name">DEO Name</a>
			</li>


			<li class="nav-item">
				<form class="form-inline my-2 my-lg-0 mr-lg-2">
					<div class="input-group">
						<input class="form-control form-control-sm" type="text"
							placeholder="Search for..."> <span
							class="input-group-append">
							<button class="btn btn-light btn-sm" type="button">
								<i class="fa fa-search"></i>
							</button>
						</span>
					</div>
				</form>
			</li>

			<li class="nav-item">
				<button type="button" class="btn btn-dark btn-sm ">
					<span class="fa fa-key"></span> Logout
				</button>
			</li>



		</ul>
	</div>

	</nav>

	<!-- side bar starts -->

	<!-- only visibale in 10'0 inch or above screens-->
	<div class="col-md-2 position-fixed d-none d-md-block"
		style="background-color: #003399; height: 100%; padding-top: 60px;">
		<nav class="navbar  navbar-expand-lg navbar-dark"
			style="padding-top: 30px;padding-left:0%">


		<ul class="nav flex-column sidbar-items">
			<li></li>

			<li class="nav-item active"><a class="nav-link" href="#"> <span
					class="fa fa-pencil-square-o " style="font-size: 18px"></span> Home
			</a></li>

			<li class="nav-item"><a class="nav-link"
				href="AdminDashbord add.html"><span class="fa fa-plus "
					style="font-size: 18px"></span> Add Retailer</a></li>

			<li class="nav-item"><a class="nav-link "
				href="AdminDashbord update.html"><span class="fa fa-clone"
					style="font-size: 18px"></span> Update Retailer Profile</a></li>

			<li class="nav-item"><a class="nav-link "
				href="AdminDashbord delete.html"><span class="fa fa-database"
					style="font-size: 18px"></span> Delete Retailer</a></li>





		</ul>

		</nav>
	</div>

	<!--side bar end-->
</body>
</html>