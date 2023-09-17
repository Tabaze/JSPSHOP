<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container">
	<c:forEach var="product" items="${produits}">
		<div class="product" data-index="<c:out value="${ product.getIdProduit() }" />">
			<div class="product__close">Close</div>
			<img class="product__img"
				src="${ product.getThumbnail() }" />
			<div class="product__brand" style="text-transform: uppercase">${ product.getBrand() }</div>
			<div class="product__title">${ product.getTitle() }</div>
			<div class="product__price">$${ product.getPrice() }</div>
			<div class="product__buttons" style="-delay: 0.2s">
<!-- 				<div class="product__options"> -->
<!-- 					<button class="product__option">SML</button> -->
<!-- 					<button class="product__option product__option--active">MED</button> -->
<!-- 					<button class="product__option">LRG</button> -->
<!-- 					<button class="product__option">XLG</button> -->
<!-- 				</div> -->
				<button class="product__option product__add">ADD TO CART</button>
			</div>
			<div class="product__subtitle">${ product.getDescription() }</div>
			<div class="product__subtitle product__subtitle--expanded"
				style="-delay: 0.3s">${ product.getDescription() }</div>
			<img class="product__detail-img"
				src="${ product.getImage1() }" />
			<div class="product__table">
				<div class="product__table-title">TECHNICAL SPECIFICATIONS</div>
				<div class="product__table-row">
					<div class="product__table-cell">Brand</div>
					<div class="product__table-cell">${ product.getBrand() }</div>
				</div>
				<div class="product__table-row">
					<div class="product__table-cell">Rating</div>
					<div class="product__table-cell">${ product.getRating() }</div>
				</div>
				<div class="product__table-row">
					<div class="product__table-cell">Stock</div>
					<div class="product__table-cell">${ product.getStock() }</div>
				</div>
				<div class="product__table-row">
					<div class="product__table-cell">Categorie</div>
					<div class="product__table-cell">${ product.getCategorie().getName() }</div>
				</div>
<!-- 				<div class="product__option">ALL SPECIFICATIONS</div> -->
			</div>
			<div class="product__grid">
				<img
					src="${ product.getThumbnail() }" />
				<img
					src="${ product.getImage1() }" />
				<img
					src="${ product.getImage2() }" />
				<img
					src="${ product.getImage3() }" />
				<img
					src="${ product.getImage4() }" />
			</div>
			<div class="product__detail">VIEW DETAILS</div>
		</div>
	</c:forEach>
	<div class="product__overlay" style="background: transparent"></div>
</div>