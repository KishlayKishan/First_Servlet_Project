package com.bridgelabz.firstservelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(description = "Login Servlet Testing", urlPatterns = { "/LoginServlet" }, initParams = {
		@WebInitParam(name = "user", value = "Kishlay_Kishan"), @WebInitParam(name = "password", value = "Kishan20@") })
public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// get request for userID and Password

		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");

		// get servlet config init params

		String userID = getServletConfig().getInitParameter("user");
		String password = getServletConfig().getInitParameter("password");

		String userRegex = "^[A-Z]{1}.{2,}$";// username regex

		/*
		 * Checking for i)User name regex ii) Atleast one upper case iii) Min 3
		 * characters
		 */

		if (!user.matches(userRegex)) {
			PrintWriter out = response.getWriter();
			out.println("<font color=red>Kindly Enter Correct User Name</font>");
		}

		/*
		 * ^ represents starting character of the string. (?=.*[0-9]) represents a digit
		 * must occur at least once. (?=.*[a-z]) represents a lower case alphabet must
		 * occur at least once. (?=.*[A-Z]) represents an upper case alphabet that must
		 * occur at least once. (?=.*[@#$%^&-+=()] represents a special character that
		 * must occur at least once. (?=\\S+$) white spaces don’t allowed in the entire
		 * string. .{8, 20} represents at least 8 characters and at most 20 characters.
		 * $ represents the end of the string.
		 */

		String passwordRegex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$";

		/*
		 * Checking for password regex
		 */

		if (!pwd.matches(passwordRegex)) {
			PrintWriter out = response.getWriter();
			out.println("<font color=red>Kindly Enter Correct Password</font>");
		}

		if (userID.equals(user) && password.equals(pwd)) {
			request.setAttribute("user", user);
			request.getRequestDispatcher("LoginSuccess.jsp").forward(request, response);
		} else {
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/login.html");
			PrintWriter out = response.getWriter();
			out.println("<font color=yellow> Either User Name Or Password Is Wrong.</font>");
			requestDispatcher.include(request, response);
		}
	}
}