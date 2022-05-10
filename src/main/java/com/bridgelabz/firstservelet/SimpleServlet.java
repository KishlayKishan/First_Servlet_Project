package com.bridgelabz.firstservelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Hello")

public class SimpleServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html"); // setting content to text or html
		PrintWriter out = response.getWriter();

		// printing on web server

		out.println("<h3>Hello World Kishan Kishan!</h3>");
		out.close();
	}
}