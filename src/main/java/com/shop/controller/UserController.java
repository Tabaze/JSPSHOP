package com.shop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.metier.IMetier;
import com.shop.metier.MetierProduit;
import com.shop.metier.MetierUsers;
import com.shop.model.Produit;
import com.shop.model.User;

/**
 * Servlet implementation class UserController
 */
@WebServlet(name = "UserController", urlPatterns = "/users/*")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MetierUsers musers = new MetierUsers();
	IMetier<Produit> metier = new MetierProduit();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			switch (request.getPathInfo()) {
			case "/signin":
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				Controller.user = musers.signin(username, password);
				if (Controller.user != null) {
					if (Controller.user.isAdmin()) {
						request.getRequestDispatcher("/index.jsp?direct=dashboard").forward(request, response);
					} else {
						request.getRequestDispatcher("/index.jsp?direct=produitCard").forward(request, response);
					}
				} else
					request.getRequestDispatcher("/pages/error.html").forward(request, response);
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
