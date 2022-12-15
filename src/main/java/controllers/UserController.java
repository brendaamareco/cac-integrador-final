package controllers;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import javax.sql.DataSource;

import data.UserData;


@WebServlet("/user")
public class UserController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	@Resource( name = "jdbc/codoacodo_final")
	private DataSource dataSource;
	private UserData userData;
	
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

		userData = new UserData(dataSource);
		if ( userData.getUser(email, password) != null)
		{
			response.getWriter().print("Login exitoso");
		}
		
		else
			response.getWriter().print("Usuario inválido. email:" + email + ", pass:" + password);

	}

}
