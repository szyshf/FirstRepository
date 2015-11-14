package com.bright.estore.order.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bright.estore.order.biz.IUserOrderServiec;
import com.bright.estore.order.biz.impl.UserOrderImpl;
import com.bright.estore.order.model.OrderModel;

public class ProcessServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		HttpSession session = request.getSession();
		Double total = (Double) session.getAttribute("total");
		String userName = request.getParameter("username");
		String creditCard = request.getParameter("creditCard");
		String zipCode = request.getParameter("zipCode");
		String phone1 = request.getParameter("phone");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String phone = phone1 + "-" + phone2 + "-" + phone3;
		OrderModel orderModel = new OrderModel();
		orderModel.setUserName(userName);
		orderModel.setCreditCard(creditCard);
		orderModel.setPhone(phone);
		orderModel.setZipcode(zipCode);
		orderModel.setTotal(total.doubleValue());
		IUserOrderServiec iorder = new UserOrderImpl();
		if (iorder.saveOrder(orderModel)) {
			request.getRequestDispatcher("ProcessOrder").forward(request,
					response);
		} else {
			response.sendRedirect("order.html");
		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
