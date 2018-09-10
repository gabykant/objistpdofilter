package com.objis.dofilter;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.objis.dofilter.db.DBConnection;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("login.jsp").forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("userEmail");
		String pass = request.getParameter("userPass");
		String forwardUrl = "/login";
		
		DBConnection db = new DBConnection();
		if (db.login(email, pass)) {
			HttpSession session = request.getSession();
			session.setAttribute("authenticated", true);
			forwardUrl = "/welcome";
			System.out.println("Connecte");
		} else {
			System.out.println("Non connecte");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardUrl);
		dispatcher.forward(request, response);
	}

}
