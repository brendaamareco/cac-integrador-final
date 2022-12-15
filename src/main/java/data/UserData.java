package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;


public class UserData 
{
	private DataSource dataSource;
	
	public UserData(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}
	
	public boolean userExists(String email, String password)
	{
		try
	  	 {
	  		 Connection connect = dataSource.getConnection();
	  		 String query = "SELECT * FROM usuarios WHERE email = ? AND clave = ?";
	  		 PreparedStatement statement = connect.prepareStatement(query);
	  		 
	  		 statement.setString(1, email);
	  		 statement.setString(2, password);
	  		 
	  		ResultSet rs = statement.executeQuery();
	  		
	  		 if ( rs != null )
	  			 return true;
	  		 else 
	  			 return false;
	  		 
	  		 
	  	 } catch (SQLException e) { e.printStackTrace(); return false; }
	}
	
}
