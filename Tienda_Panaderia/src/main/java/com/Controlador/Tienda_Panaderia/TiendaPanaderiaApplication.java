package com.Controlador.Tienda_Panaderia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.DAO.Tienda_Panaderia.Conexion;

@SpringBootApplication
public class TiendaPanaderiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiendaPanaderiaApplication.class, args);
		
		// Conexion conn = new Conexion();
		// conn.getCon();
	}

}
