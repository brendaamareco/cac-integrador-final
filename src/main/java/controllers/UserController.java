package controllers;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.User;

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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	if ( request.isRequestedSessionIdValid() )
    		request.getRequestDispatcher("user.jsp").forward(request, response);

    	else
    		request.getRequestDispatcher("login.html").forward(request, response);
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String username = request.getParameter("username");
		String server = request.getParameter("server");
		String email = username + "@" + server;
		String password = request.getParameter("password");

		userData = new UserData(dataSource);
		User user = userData.getUser(email, password);
		
		if ( user != null )
		{
			HttpSession session = request.getSession(true);
			session.setMaxInactiveInterval(3600); 
			session.setAttribute("user", user);
			request.getRequestDispatcher("user.jsp").forward(request, response);
		}
		
		else
			response.getWriter().print("Los datos son incorrectos. Inténtalo nuevamente");

	}

}
