package com.training.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet("/Hello")
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorldServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Init called");
		super.init();
	}



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		String[] name = request.getParameterValues("name");
		//String name1 = request.getParameter("name1");
		//String name2 = request.getParameter("name2");
		String names = "";
		for(String s : name){
			names += s;
		}
		
		
		String resHtml="<!DOCTYPT hrml> <html><head><title>Hello World!</title></head>"+
				"<body bgcolor =\"#fdf5e6\">\n"+
				"<h1>Test</h1>\n"+
				"<p>HELLO "+ names +" </p>\n"+
				"</body></html>";
		writer.println(resHtml);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String age = request.getParameter("age");
		response.getWriter().println("Welcome " + firstName + " " + lastName);
	}

}
