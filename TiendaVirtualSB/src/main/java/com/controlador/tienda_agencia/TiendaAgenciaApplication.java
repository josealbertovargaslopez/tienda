package com.controlador.tienda_agencia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.DAO.Tienda_Agencia.Conexion;

@SpringBootApplication
public class TiendaAgenciaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiendaAgenciaApplication.class, args);
		
		//Esto que sigue es para saber si hay conexión
		//Conexion conn = new Conexion();
		//conn.getCon();
	}

}
