<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>JSPSHOP</title>
<link rel='stylesheet' href='../CSS/bootstrap.min.css'>
<link rel="stylesheet" href="../CSS/all.min.css">
<link rel="stylesheet" href="../CSS/normalize.min.css">
<link rel="stylesheet" href="../CSS/style.css">
<link rel="stylesheet" href="../CSS/produitCard.css">
<link rel="stylesheet" href="../CSS/producList.css">

</head>

<body>
	<aside
		class="sidebar position-fixed top-0 left-0 overflow-auto h-100 float-left"
		id="show-side-navigation1">
		<i class="uil-bars close-aside d-md-none d-lg-none"
			data-close="show-side-navigation1"></i>
		<div
			class="sidebar-header d-flex justify-content-center align-items-center px-3 py-4">
			<div class="ms-2">
				<h5 class="fs-6 mb-0">
					<a class="text-decoration-none" href="#"><img class="img-fluid"
						width="65" src="../Imgs/shop.png" alt=""></a>
				</h5>
				<p class="mt-1 mb-0"></p>
			</div>
		</div>

		<!-- <div class="search position-relative text-center px-4 py-3 mt-2">
      <input type="text" class="form-control w-100 border-0 bg-transparent" placeholder="Search here">
      <i class="fa fa-search position-absolute d-block fs-6"></i>
    </div> -->
		<c:choose>
			<c:when test="${isAdmin}">
				<ul class="categories list-unstyled">
					<li><a href="../index.jsp?direct=dashboard">Dashboard</a></li>
					<li><a href="../index.jsp?direct=produitList">Products</a></li>
					<li><a href="../index.jsp?direct=cateList">Categories</a></li>
					<li><a href="../index.jsp?direct=dashboard">Users</a></li>
				</ul>
			</c:when>
			<c:otherwise>
				<ul class="categories list-unstyled">
					<li><a href="../index.jsp?direct=produitCard">Products</a></li>
					<li><a href="./commandes.jsp">See commandes</a></li>
					<li><a href="../index.jsp?direct=dashboard">Users</a></li>
				</ul>
			</c:otherwise>
		</c:choose>
	</aside>

	<section id="wrapper">
		<nav class="navbar navbar-expand-md">
			<div class="container-fluid mx-2">
				<div id="toggle-navbar">
					<ul class="navbar-nav ms-auto">
						<li class="nav-item"><a class="nav-link" href="#"> <i
								data-show="show-side-navigation1"
								class="fa-solid fa-bars-staggered uil-bars show-side-btn"></i>
						</a></li>
					</ul>
				</div>
				<div class="navbar-header">
					<button class="navbar-toggler" type="button"
						data-bs-toggle="collapse" data-bs-target="#toggle-navbar"
						aria-controls="toggle-navbar" aria-expanded="false"
						aria-label="Toggle navigation">
						<i class="uil-bars text-white"></i>
					</button>
					<a class="navbar-brand" href="#">JSP <span class="main-color">SHOP</span></a>
				</div>
			</div>
		</nav>
		<c:choose>
			<c:when test="${statu eq 'produit'}">
				<%@include file="produit.jsp"%>
			</c:when>
			<c:when test="${statu eq 'dashboard'}">
				<%@include file="dashboar.jsp"%>
			</c:when>
			<c:when test="${statu eq 'addProduit'}">
				<%@include file="AddProduit.jsp"%>
			</c:when>
			<c:when test="${statu eq 'producAdmin'}">
				<%@include file="productList.jsp"%>
			</c:when>
			<c:when test="${statu eq 'cateList'}">
				<%@include file="cateList.jsp"%>
			</c:when>
			<c:otherwise>
			</c:otherwise>
		</c:choose>
	</section>

	<!-- partial -->
	<!-- <script src='https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.bundle.js'></script> -->


	<script src="../JS/jquery.min.js"></script>
	<script src='../JS/bootstrap.min.js'></script>
	<script src='../JS/all.min.js'></script>
	<script src="../JS/script.js"></script>

</body>

</html>