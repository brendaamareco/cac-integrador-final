package models;

public class User 
{
	int id;
	String nombre, apellido, email;
	
	public User(int id, String nombre, String apellido,
			String email)
	{
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
	}

	public int getId() 
	{
		return id;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public String getApellido() 
	{
		return apellido;
	}

	public String getEmail() 
	{
		return email;
	}
	
}
