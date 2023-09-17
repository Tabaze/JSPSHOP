<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="app-container">
	<div class="app-content">
		<div class="app-content-header">
			<h1 class="app-content-headerText">Categories</h1>
			<a href="../index.jsp?direct=AddCate"
				class="app-content-headerButton">Add Categories</a>
		</div>
		<div class="app-content-actions">
<!-- 			<input class="search-bar" placeholder="Search..." type="text"> -->
			<div class="app-content-actions-wrapper">
				<div class="filter-button-wrapper">
<!-- 					<button class="action-button filter jsFilter"> -->
<!-- 						<span>Filter</span> -->
<!-- 						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" -->
<!-- 							viewBox="0 0 24 24" fill="none" stroke="currentColor" -->
<!-- 							stroke-width="2" stroke-linecap="round" stroke-linejoin="round" -->
<!-- 							class="feather feather-filter"> -->
<!-- 								<polygon points="22 3 2 3 10 12.46 10 19 14 21 14 12.46 22 3" /></svg> -->
<!-- 					</button> -->
<!-- 					<div class="filter-menu"> -->
<!-- 						<label>Category</label> <select> -->
<!-- 							<option>All Categories</option> -->
<%-- 							<c:forEach var="cate" items="${categories}"> --%>
<%-- 								<option value="${cate.getName() }">${cate.getName() }</option> --%>
<%-- 							</c:forEach> --%>
<!-- 						</select> -->
<!-- 						<div class="filter-menu-buttons"> -->
<!-- 							<button class="filter-button reset">Reset</button> -->
<!-- 							<button class="filter-button apply">Apply</button> -->
<!-- 						</div> -->
<!-- 					</div> -->
				</div>
<!-- 				<button class="action-button list active" title="List View"> -->
<!-- 					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" -->
<!-- 						viewBox="0 0 24 24" fill="none" stroke="currentColor" -->
<!-- 						stroke-width="2" stroke-linecap="round" stroke-linejoin="round" -->
<!-- 						class="feather feather-list"> -->
<!-- 							<line x1="8" y1="6" x2="21" y2="6" /> -->
<!-- 							<line x1="8" y1="12" x2="21" y2="12" /> -->
<!-- 							<line x1="8" y1="18" x2="21" y2="18" /> -->
<!-- 							<line x1="3" y1="6" x2="3.01" y2="6" /> -->
<!-- 							<line x1="3" y1="12" x2="3.01" y2="12" /> -->
<!-- 							<line x1="3" y1="18" x2="3.01" y2="18" /></svg> -->
<!-- 				</button> -->
<!-- 				<button class="action-button grid" title="Grid View"> -->
<!-- 					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" -->
<!-- 						viewBox="0 0 24 24" fill="none" stroke="currentColor" -->
<!-- 						stroke-width="2" stroke-linecap="round" stroke-linejoin="round" -->
<!-- 						class="feather feather-grid"> -->
<!-- 							<rect x="3" y="3" width="7" height="7" /> -->
<!-- 							<rect x="14" y="3" width="7" height="7" /> -->
<!-- 							<rect x="14" y="14" width="7" height="7" /> -->
<!-- 							<rect x="3" y="14" width="7" height="7" /></svg> -->
<!-- 				</button> -->
			</div>
		</div>
		<div class="products-area-wrapper tableView">
			<div class="products-header">
				<div class="product-cell category">Category</div>
				<div class="product-cell sales">Brand</div>
			</div>

			<c:forEach var="cate" items="${categories}">
				<div class="products-row">
					<div class="product-cell category">
						<span class="cell-label">Category:</span>${cate.getName() }
					</div>
					<div class="product-cell status-cell">
						<span class="cell-label">Products:</span>${cate.getProduits().size() }
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</div>
<script>
	document.querySelector(".jsFilter").addEventListener("click", function() {
		document.querySelector(".filter-menu").classList.toggle("active");
	});

	document.querySelector(".grid").addEventListener(
			"click",
			function() {
				document.querySelector(".list").classList.remove("active");
				document.querySelector(".grid").classList.add("active");
				document.querySelector(".products-area-wrapper").classList
						.add("gridView");
				document.querySelector(".products-area-wrapper").classList
						.remove("tableView");
			});

	document.querySelector(".list").addEventListener(
			"click",
			function() {
				document.querySelector(".list").classList.add("active");
				document.querySelector(".grid").classList.remove("active");
				document.querySelector(".products-area-wrapper").classList
						.remove("gridView");
				document.querySelector(".products-area-wrapper").classList
						.add("tableView");
			});

	var modeSwitch = document.querySelector('.mode-switch');
	modeSwitch.addEventListener('click', function() {
		document.documentElement.classList.toggle('light');
		modeSwitch.classList.toggle('active');
	});
</script>