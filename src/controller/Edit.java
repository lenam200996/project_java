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
import model.bean.User;

/**
 * Servlet implementation class View
 */
@WebServlet("/View")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Edit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		UserBO u = new UserBO();
		
		HttpSession ss =  request.getSession();
		
		User user = new User();
		
		user =(User) ss.getAttribute("user");
		
		String fullname = request.getParameter("fullname");
		
		if(u.editProfile(user.getUsername().trim(), fullname)) {
			user.setFullname(fullname);
			ss.setAttribute("user",user);
			request.getRequestDispatcher("main.jsp").include(request, response);
		}
		else {
			out.println("Edit Failt");
			request.getRequestDispatcher("edit.jsp").include(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
