package com.DAO.Tienda_Panaderia;

import java.sql.*;

public class Conexion {

	// Parametros de Conexión
	
	String bd = "DB_Panaderia";
	String Login = "root";
	String password = "&Admin#123&.";
	String url = "jdbc:mysql://localhost/"+bd;
	
	Connection con = null;
	
	// Constructor de Conexión
	
	public Conexion()
	{
		try
		{
			// Obtener el driver para MySQL
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Obtener la conexión
			con = DriverManager.getConnection(url,Login,password);
			if(con!=null)
			{
				System.out.println("Conexión a la Base de Datos "+ bd+ "Exitosa");
			}
		}
		catch(SQLException e)
		{
			System.out.println("Error de conexión: "+ e);
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Error de conexión: "+ e);
		}
		catch(Exception e)
		{
			System.out.println("Error de conexión: "+ e);
		}
	}
	
	// Método para retornar la Conexión
	public Connection getCon()
	{
		return con;
	}
	
	//Método para desconectar
	public void desconectar()
	{
		con = null;
	}
	
}
