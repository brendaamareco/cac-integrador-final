package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

import models.User;

public class UserData 
{
	private DataSource dataSource;
	
	public UserData(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}
	
	public User getUser(String email, String password)
	{
		try
	  	 {
	  		 Connection connect = dataSource.getConnection();
	  		 String query = "SELECT * FROM usuarios WHERE email = ? AND clave = ?";
	  		 PreparedStatement statement = connect.prepareStatement(query);
	  		 
	  		 statement.setString(1, email);
	  		 statement.setString(2, password);
	  		 
	  		 ResultSet rs = statement.executeQuery();
	  		

	  		 if ( rs.next() ) { return createUser(rs); }
	  		 
	  	 } catch (SQLException e) { e.printStackTrace(); }
		
		return null;
	}

	private User createUser(ResultSet rs) 
	{
		try 
		{
			int id = rs.getInt("id");
			String name = rs.getString("nombre");
			String lastName = rs.getString("apellido");
			String email = rs.getString("email");
			
			return new User(id, name, lastName, email);
		} 
		
		catch (SQLException e) { e.printStackTrace();}
		
		return null;
	}
	
}
