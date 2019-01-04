package com.training.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class PersonServlet
 */
@WebServlet("/person")
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession httpSession = request.getSession();
		String personName = (String) httpSession.getAttribute("person_name");
		if(personName == null){
			response.getWriter().write(" Person cannot be found");
			response.sendRedirect("PersonDetails.jsp");
		}
		else{
			Person person = new Person();
			person.setName(personName);
			System.out.println("Setting person");
			//response.getWriter().write(" Person name is " +  personName);
			request.setAttribute("person", person);
			//response.sendRedirect("PersonName.jsp");
			httpSession.invalidate();System.out.print("Sending using include");
			RequestDispatcher dispatcher = request.getRequestDispatcher("PersonName.jsp");
			dispatcher.forward(request,response);
			//dispatcher = request.getDispatcher

			System.out.println("Name is: " + person.getName());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("personname");
		if(name != null){
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("person_name",name);
			System.out.println("Stored the person");
			response.sendRedirect("person");
		}else 
			response.getWriter().write("Did not store the person");
		doGet(request, response);
	}

}
