package com.shop.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.dao.IDao;
import com.shop.metier.*;
import com.shop.model.*;

/**
 * Servlet implementation class Controller
 */
@WebServlet(name = "controllers", urlPatterns = { "/JSPSHOP/*" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static User user;
	IMetier<Produit> Prodmetier = new MetierProduit();
	IMetier<User> userMetier = new MetierUsers();
	IMetier<Commande> comMetier = new MetierCommande();
	IMetier<Categorie> cateMetier = new MetierCategorie();
	IMetier<LigneCommande> ligneMetier = new MetierLigne();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (user != null)
			request.setAttribute("isAdmin", user.isAdmin());
		switch (request.getPathInfo()) {
		case "/login":
			request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
			break;
		case "/dashboard":
			request.setAttribute("statu", "dashboard");
			request.setAttribute("userCount", userMetier.getAll().size());
			request.setAttribute("productCount", Prodmetier.getAll().size());
			request.setAttribute("comCount", comMetier.getAll().size());
			request.setAttribute("ligneCount", ligneMetier.getAll().size());
			request.setAttribute("userName", user.getFirstname() + ' ' + user.getLastname());
			request.getRequestDispatcher("/pages/home.jsp").forward(request, response);
			break;
		case "/productCard":
			request.setAttribute("statu", "produit");
			request.setAttribute("produits", Prodmetier.getAll());
			request.getRequestDispatcher("/pages/home.jsp").forward(request, response);
			break;
		case "/produitList":
			request.setAttribute("statu", "producAdmin");
			request.setAttribute("categories", cateMetier.getAll());
			request.setAttribute("produits", Prodmetier.getAll());
			request.getRequestDispatcher("/pages/home.jsp").forward(request, response);
			break;
		case "/cateList":
			request.setAttribute("statu", "cateList");
			request.setAttribute("categories", cateMetier.getAll());
			request.getRequestDispatcher("/pages/home.jsp").forward(request, response);
			break;
		case "/AddProduct":
			request.setAttribute("statu", "addProduit");
			request.setAttribute("categories", cateMetier.getAll());
			request.getRequestDispatcher("/pages/AddProduit.jsp").forward(request, response);
			break;
		default:
			request.getRequestDispatcher("/pages/error.html").forward(request, response);
			break;
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
