package com.DTO.Tienda_Agencia;

// El que me dice como es la estructura de la base de datos

public class UsuarioVistaObjeto 
{
	private int Cedula;
	private String Nombre;
	private String Correo;
	private String Usuario;
	private String Clave;
	
	
	public int getCedula() 
	{
		return Cedula;
	}
	
	public void setCedula(int cedula) 
	{
		Cedula = cedula;
	}
	
	public String getNombre() 
	{
		return Nombre;
	}
	
	public void setNombre(String nombre)
	{
		Nombre = nombre;
	}
	
	public String getCorreo() 
	{
		return Correo;
	}
	
	public void setCorreo(String correo) 
	{
		Correo = correo;
	}
	
	public String getUsuario() 
	{
		return Usuario;
	}
	
	public void setUsuario(String usuario) 
	{
		Usuario = usuario;
	}
	
	public String getClave() 
	{
		return Clave;
	}
	
	public void setClave(String clave) 
	{
		Clave = clave;
	}
	
	

}
