package com.training.spring.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.spring.model.Person;


/**
 * Servlet implementation class PersonSpringServlet
 */
@WebServlet("/PersonSpringServlet")
public class PersonSpringServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonSpringServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession httpSession = request.getSession();
		Person person = (Person) httpSession.getAttribute("person");
		if(person==null){
			System.out.println("Person not found. Redirecting");
			response.sendRedirect("persondetails.jsp");
		}else{
		
			System.out.println("Setting person " + person);
			request.setAttribute("person", person);
			httpSession.invalidate();
			System.out.println("Sendng using layout");
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("layout/header.jsp");
			dispatcher.include(request, response);
			dispatcher = request.
				getRequestDispatcher("viewpersondetails.jsp");
			dispatcher.include(request, response);
			dispatcher = request.getRequestDispatcher("layout/footer.jsp");
			dispatcher.include(request, response);

		doGet(request, response);
	}

}
