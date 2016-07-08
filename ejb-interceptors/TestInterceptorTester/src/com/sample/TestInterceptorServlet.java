package com.sample;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestInterceptorServlet
 */
public class TestInterceptorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestInterceptorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello from Servlet");

		InitialContext initialContext;
		Echo echo;
		Echo echo2;

		String message = request.getParameter("printMessage");

		if (message != null) {

			try {

				initialContext = new InitialContext();
				
				echo = (Echo) initialContext.lookup("mytest");
				
				echo.printMessage("Echo:" + message);
				
				echo2 = (Echo) initialContext.lookup("TestClientInterceptorEAR/EchoBean/remote-com.sample.Echo");
				
				echo2.printMessage("Echo2:" + message);

			} catch (NamingException e) {
				
				e.printStackTrace();
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
