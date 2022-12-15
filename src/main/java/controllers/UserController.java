package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/user")
public class UserController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

    public UserController() 
    {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String username = request.getParameter("username");
		String server = request.getParameter("server");
		String email = username + "@" + server;
		
		String password = request.getParameter("password");

		PrintWriter output = response.getWriter();
		output.print("email: " + email);
		output.print("password: " + password);

	}

}
