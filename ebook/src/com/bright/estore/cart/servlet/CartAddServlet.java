package com.bright.estore.cart.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bright.estore.cart.model.CartItemsModel;
import com.bright.estore.product.model.BookModel;


public class CartAddServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CartAddServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here 
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		int i = Integer.parseInt(request.getParameter("number"));
		HttpSession session = request.getSession();
		Map cart = (Map)session.getAttribute("cart");
		if(cart == null){
			cart = new HashMap();
			session.setAttribute("cart", cart);
		}
			
			BookModel bookModel = (BookModel)session.getAttribute("bookModel");
			String isbn = bookModel.getIsbn();
		
			if(cart.get(isbn)== null){
				cart.put(isbn, new CartItemsModel(bookModel,i));
			}else{
				CartItemsModel cartItemsModel = (CartItemsModel)cart.get(isbn);
				cartItemsModel.setQty(cartItemsModel.getQty()+i);
			}
			request.getRequestDispatcher("viewCart.jsp").forward(request, response);
		}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
