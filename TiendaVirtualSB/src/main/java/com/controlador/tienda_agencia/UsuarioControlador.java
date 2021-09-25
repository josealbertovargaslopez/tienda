package com.controlador.tienda_agencia;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.Tienda_Agencia.UsuarioDAO;
import com.DTO.Tienda_Agencia.UsuarioVistaObjeto;

@RestController
public class UsuarioControlador 
{
	@RequestMapping("/listarUsuarios")
	public ArrayList<UsuarioVistaObjeto> listarUsuarios()
	{
		UsuarioDAO Dao = new UsuarioDAO();
		
		return Dao.listaUsuarios();
	}
	
	
	@RequestMapping("/consultarUsuario") // Se debe escribir en el buscador -> localhost:8080/consultarUsuario?documento=4455 el 4455 es en numero de documento
	public ArrayList<UsuarioVistaObjeto> consultarUsuario(int documento)
	{
		UsuarioDAO Dao = new UsuarioDAO();
		return Dao.ConsultarUsuario(documento);
	}
	
	
	@RequestMapping("/registrarUsuario") // Se debe escribir en el explorador lo siguiente -> localhost:8080/registrarUsuario?cedula=1234&nombre=Jose%20Vargas&correo=jvargas@gmail.com&usuario=jvargas&clave=987654
	public void registrarUsuario(UsuarioVistaObjeto persona)
	{
		UsuarioDAO Dao = new UsuarioDAO();
		Dao.registrarUsuario(persona);
	}
	
	
	@RequestMapping("/eliminarUsuario")
	public void eliminarUsuario(int documento)
	{
		UsuarioDAO Dao = new UsuarioDAO();
		Dao.eliminarUsuario(documento);
	}
	
	
	@RequestMapping("/actualizarUsuario")
	public void actualizarUsuario(int documento, String nombre, String correo)
	{
		UsuarioDAO Dao = new UsuarioDAO();
		Dao.eliminarUsuario(documento,nombre,correo);
	}

}
