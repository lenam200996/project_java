package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BO.UserBO;

/**
 * Servlet implementation class LoginSV
 */
@WebServlet("/LoginSV")
public class LoginSV extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginSV() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String us = request.getParameter("us");
		String pw = request.getParameter("pw");
		PrintWriter out = response.getWriter();
		
		UserBO u = new UserBO();
		HttpSession ss = request.getSession();
		if(u.checkLogin(us, pw)) {
			ss.setAttribute("user", u.getUser());
			request.getRequestDispatcher("main.jsp").include(request, response);
		}else {
			out.println("Login Failt");
			request.getRequestDispatcher("Login.jsp").include(request, response);
		}
	}

}
