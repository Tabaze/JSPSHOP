package com.shop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.metier.IMetier;
import com.shop.metier.MetierCategorie;
import com.shop.metier.MetierProduit;
import com.shop.model.Categorie;
import com.shop.model.Produit;

/**
 * Servlet implementation class ProduitController
 */
@WebServlet(name = "ProduitController", urlPatterns = "/produit/*")
public class ProduitController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IMetier<Produit> metier = new MetierProduit();
	IMetier<Categorie> metIMetier = new MetierCategorie();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProduitController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			switch (request.getPathInfo()) {
			case "/add":
				Produit proAdd = new Produit();
				proAdd.setTitle(request.getParameter("title"));
				proAdd.setDescription(request.getParameter("Description"));
				proAdd.setPrice(Float.valueOf(request.getParameter("price")));
				proAdd.setDiscount(Float.valueOf(request.getParameter("discount")));
				proAdd.setCategorie(metIMetier.getOne(Integer.valueOf(request.getParameter("cate"))));
				proAdd.setRating(Float.valueOf(request.getParameter("rating")));
				proAdd.setRating(Integer.valueOf(request.getParameter("stock")));
				proAdd.setBrand(request.getParameter("brand"));
				proAdd.setThumbnail(request.getParameter("thumbnail"));
				proAdd.setImage1(request.getParameter("image1"));
				proAdd.setImage2(request.getParameter("image2"));
				proAdd.setImage3(request.getParameter("image3"));
				proAdd.setImage4(request.getParameter("image4"));
				if(metier.create(proAdd)) {
					request.setAttribute("statu", "produit");
					request.getRequestDispatcher("/index.jsp?direct=produitList").forward(request, response);
				}
				else {
					throw new Exception("Can't Add this project");
				}
				break;
			default:
				request.getRequestDispatcher("/pages/error.html").forward(request, response);
				break;
			}
		} catch (Exception ex) {

			request.getRequestDispatcher("/pages/error.html").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
