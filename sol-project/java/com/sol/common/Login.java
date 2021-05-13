package com.sol.common;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String usr, pwd;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		
		HttpSession session = request.getSession();	
		this.usr = request.getParameter( "user" );
		this.pwd = request.getParameter("pass");
		
		if ( this.usr.equals( "NFERNANDEZ" ) && this.pwd.equals( "123456" ) ) {
			session.setAttribute("solution.user", this.usr );
			response.sendRedirect( request.getContextPath() + "/projects/main.jsp" );
		} else {
			String json = "{ \"login\": { \"success\": false, \"error\": \"Usuario o contasela incorrectos\"} }";
			response.setContentType( "text/plain" );
			response.getWriter().write( json );
		}
	}
}