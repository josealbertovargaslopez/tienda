package com.DAO.Tienda_Agencia;

import java.sql.*;
import java.util.ArrayList;

import com.DTO.Tienda_Agencia.UsuarioVistaObjeto;

// Esta clase permite el acceso a la base de datos y realizar el CRUD a Usuarios

public class UsuarioDAO 
{
	// Metodo para consultar los Usuarios
	public ArrayList<UsuarioVistaObjeto> listaUsuarios()
	{
		ArrayList<UsuarioVistaObjeto> miLista = new ArrayList<UsuarioVistaObjeto>();
		Conexion con = new Conexion();
		
		try
		{
			PreparedStatement consulta = con.getCon().prepareStatement("SELECT * FROM T_Usuarios");
			ResultSet rs = consulta.executeQuery();
			
			while(rs.next())
			{
				UsuarioVistaObjeto persona = new UsuarioVistaObjeto();
				persona.setCedula(Integer.parseInt(rs.getString("CedulaUsuario")));
				persona.setNombre(rs.getString("NombreUsuario"));
				persona.setCorreo(rs.getString("CorreoUsuario"));
				persona.setUsuario(rs.getString("Usuario"));
				persona.setClave(rs.getString("ContraseñaUsuario"));
				
				miLista.add(persona);
			}
			
			rs.close();
			consulta.close();
			con.desconectar();
			
		}
		catch(Exception e)
		{
			System.out.println("Error NO se puede Conectar " + e);
		}
		
		return miLista;
	}
	
	
	//Para consultar un usuario por número de documento
	public ArrayList<UsuarioVistaObjeto> ConsultarUsuario(int documento)
	{
		ArrayList<UsuarioVistaObjeto> miLista = new ArrayList<UsuarioVistaObjeto>();
		Conexion con = new Conexion();
		
		try
		{
			PreparedStatement consulta = con.getCon().prepareStatement("SELECT * FROM T_Usuarios WHERE CedulaUsuario = ?");
			consulta.setInt(1, documento);
			ResultSet rs = consulta.executeQuery();
			
			if(rs.next())
			{
				UsuarioVistaObjeto persona = new UsuarioVistaObjeto();
				persona.setCedula(Integer.parseInt(rs.getString("CedulaUsuario")));
				persona.setNombre(rs.getString("NombreUsuario"));
				persona.setCorreo(rs.getString("CorreoUsuario"));
				persona.setUsuario(rs.getString("Usuario"));
				persona.setClave(rs.getString("ContraseñaUsuario"));
				
				miLista.add(persona);
			}
			rs.close();
			consulta.close();
			con.desconectar();
		}
		catch(Exception e)
		{
			System.out.println("Error usuario NO encontrado: " + e);
		}
		return miLista;
	}
	
	
	// Registrar un nuevo usuario
	public void registrarUsuario(UsuarioVistaObjeto persona)
	{
		Conexion con = new Conexion();
		
		try
		{
			Statement stmt = con.getCon().createStatement();
			stmt.executeUpdate("INSERT INTO T_Usuarios VALUES('"+persona.getCedula()+"','"+
					persona.getNombre()+"','"+persona.getCorreo()+"','"+persona.getUsuario()+"','"+
					persona.getClave()+"')");
			System.out.println("El usuario a sido adicionado");
			
			con.desconectar();
		}
		catch(Exception e)
		{
			System.out.println("Error de conexión: usuario no asignado " + e);
		}
	}
	
	
	//Para eliminar un usuario por numero de documento
		public void eliminarUsuario(int documento)
		{
			Conexion con = new Conexion();
			
			try
			{
				PreparedStatement consulta = con.getCon().prepareStatement("DELETE FROM T_Usuarios WHERE CedulaUsuario = ?");
				consulta.setInt(1, documento);
				consulta.executeUpdate();
				System.out.println("El usuario ha sido eliminado");
				
				
				consulta.close();
				con.desconectar();
			}
			catch(Exception e)
			{
				System.out.println("Error usuario NO encontrado: " + e);
			}
		}
		
		
		//Para actualizar un usuario por numero de documento
		public void eliminarUsuario(int documento, String nombre, String correo)
		{
			Conexion con = new Conexion();
					
			try
			{
				PreparedStatement consulta = con.getCon().prepareStatement("UPDATE T_Usuarios SET NombreUsuario = ?, CorreoUsuario = ? WHERE CedulaUsuario = ? ");
				consulta.setString(1, nombre);
				consulta.setString(2, correo);
				consulta.setInt(3, documento);
				consulta.executeUpdate();
				System.out.println("El usuario ha sido actualizado");
						
						
				consulta.close();
				con.desconectar();
			}
		
			catch(Exception e)
			{
				System.out.println("Error usuario NO encontrado: " + e);
			}
		}

}
