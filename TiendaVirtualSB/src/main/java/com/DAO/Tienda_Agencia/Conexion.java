package com.DAO.Tienda_Agencia;

import java.sql.*;

public class Conexion 
{
	// Parametros de Conexión
	String bd = "DB_Tienda_Agencia";
	String Login = "root";
	String password = "MinTic@21Jose";
	String url = "jdbc:mysql://localhost/"+bd;
	
	Connection con = null;
	
	// Constructor de Conexión
	public Conexion()
	{
		try
		{
			// Obtener el driver para MySQL
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Obtener la Conexión
			con = DriverManager.getConnection(url, Login, password);
			
			if(con != null)
				System.out.println("Conexión a la base de Datos: " + bd + "Exitosa!!!");
			
		}
		catch(SQLException e)
		{
			System.out.println("Error de Conexión " + e);
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Error de Conexión " + e);
		}
		catch(Exception e)
		{
			System.out.println("Error de Conexión " + e);
		}
	}
	
	// Metodo para retornar la Conexión
	public Connection getCon()
	{
		return con;
	}
	
	// Metodo para desconectar la Base de Datos
	public void desconectar()
	{
		con = null;
	}
	
}
