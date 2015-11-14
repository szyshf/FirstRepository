package com.bright.estore.order.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.codehaus.xfire.XFire;
import org.codehaus.xfire.XFireFactory;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;
import com.bright.comm.CreditCardPortType;
//import com.bright.estore.service.biz.IProcessCredit;


public class ProcessOrder extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ProcessOrder() {
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
		String creditCard = request.getParameter("creditCard");
		double total = ((Double) session.getAttribute("total")).doubleValue();
		// 创建服务元数据
		Service serviceModel = new ObjectServiceFactory()
				.create(CreditCardPortType.class);
		// 创建服务代理
		XFire xFire = XFireFactory.newInstance().getXFire();
		XFireProxyFactory factory = new XFireProxyFactory(xFire);

		// 服务的地址
		String serviceURL = "http://localhost/estore/services/CreditCard";
		CreditCardPortType client = null;
		try {
			client = (CreditCardPortType) factory.create(serviceModel, serviceURL);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 调用服务
		int serviceResponse = 0;
		try {
			serviceResponse = client.creditProcess(creditCard, total);
		} catch (Exception e) {
			e.printStackTrace();
		}
          if(serviceResponse == 1){
        	  response.sendRedirect("process.jsp?total=" + total);
  			  session.invalidate();
          }else{
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

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
