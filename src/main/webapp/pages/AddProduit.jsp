<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" href="../CSS/form.css">
<title>Responsive Regisration Form</title>
</head>
<body>
	<div class="container">
		<header>Add Product</header>
		<form action="/JSPSHOP/produit/add" method="post">
			<div class="form first">
				<div class="details personal">

					<div class="fields">
						<div class="input-field">
							<label>Title</label> <input type="text"
								placeholder="Enter Title" name="title" required>
						</div>

						<div class="input-field">
							<label>Description</label> <input type="text"
								placeholder="Enter Description" name="Description" required>
						</div>

						<div class="input-field">
							<label>Price</label> <input type="number"
								placeholder="Enter price" name="price" required>
						</div>

						<div class="input-field">
							<label>Discount</label> <input type="number"
								placeholder="Enter discount" name="discount" required>
						</div>

						<div class="input-field">
							<label>Categorie</label> <select required name="cate">
								<c:forEach var="cate" items="${categories}">
									<option value="${cate.getIdCategorie() }">${cate.getName() }</option>
								</c:forEach>
							</select>
						</div>

						<div class="input-field">
							<label>Rating</label> <input type="number"
								placeholder="Enter rating" name="rating" required>
						</div>
						<div class="input-field">
							<label>Stock</label> <input type="number"
								placeholder="Enter stock" name="stock" required>
						</div>
						
						<div class="input-field">
							<label>Brand</label> <input type="text"
								placeholder="Enter stock" name="brand" required>
						</div>
						
						<div class="input-field">
							<label>Thumbnail</label> <input type="text"
								placeholder="Enter stock" name="thumbnail" required>
						</div>
						<div class="input-field">
							<label>image1</label> <input type="text"
								placeholder="Enter image1" name="image1" required>
						</div>
						<div class="input-field">
							<label>image2</label> <input type="text"
								placeholder="Enter image2" name="image2" required>
						</div>
						<div class="input-field">
							<label>image3</label> <input type="text"
								placeholder="Enter image3" name="image3" required>
						</div>
						<div class="input-field">
							<label>image4</label> <input type="text"
								placeholder="Enter image4" name="image4" required>
						</div>
					</div>
				</div>

					<div class="buttons">
						<a href="../index.jsp?direct=produitList" class="backBtn"> <span
							class="btnText">Annuler</span>
						</a>

						<button class="sumbit" type="submit">
							<span class="btnText">Submit</span>
						</button>
					</div>
			</div>

		</form>
	</div>

	<script>
    const form = document.querySelector("form"),
    nextBtn = form.querySelector(".nextBtn"),
    backBtn = form.querySelector(".backBtn"),
    allInput = form.querySelectorAll(".first input");


nextBtn.addEventListener("click", ()=> {
allInput.forEach(input => {
    if(input.value != ""){
        form.classList.add('secActive');
    }else{
        form.classList.remove('secActive');
    }
})
})

backBtn.addEventListener("click", () => form.classList.remove('secActive'));
    </script>
</body>
</html>