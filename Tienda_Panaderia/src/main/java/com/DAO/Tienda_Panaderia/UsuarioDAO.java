package com.DAO.Tienda_Panaderia;

import java.sql.*;
import java.util.ArrayList;

import org.apache.coyote.http11.filters.GzipOutputFilter;

import com.DTO.Tienda_Panaderia.UsuarioVO;

// Esta clase permite el acceso a la Base de Datos
public class UsuarioDAO {

	// Método para consultar los Usuarios
	
	public ArrayList<UsuarioVO> listaUsuarios()
	{
		ArrayList<UsuarioVO> miLista = new ArrayList<UsuarioVO>();
		Conexion con = new Conexion();
		
		try
		{
			PreparedStatement consulta = con.getCon().prepareStatement("SELECT * FROM T_Usuarios");
			ResultSet rs = consulta.executeQuery();
			while(rs.next())
			{
				UsuarioVO persona = new UsuarioVO();
				persona.setCedula(Integer.parseInt(rs.getString("Cedula_Usu")));
				persona.setNombre(rs.getString("Nombre_Usu"));
				persona.setCorreo(rs.getString("Correo_Usu"));
				persona.setUsuario(rs.getString("Usuario"));
				persona.setClave(rs.getString("Clave_Usu"));
				
				miLista.add(persona);
			}
			rs.close();
			consulta.close();
			con.desconectar();
		}
		catch(Exception e)
		{
			System.out.println("Error No se pudo Conectar: "+ e);
		}
		
		return miLista;
	}
	
	// Para Consultar un Usuario por Número de Documento
	
	public ArrayList<UsuarioVO> consultaUsuario(int documento)
	{
		ArrayList<UsuarioVO> miLista = new ArrayList<UsuarioVO>();
		Conexion con = new Conexion();
		
		try
		{
			PreparedStatement consulta = con.getCon().prepareStatement("SELECT * FROM T_Usuarios WHERE Cedula_Usu = ?");
			consulta.setInt(1, documento);
			ResultSet rs = consulta.executeQuery();
			while(rs.next())
			{
				UsuarioVO persona = new UsuarioVO();
				persona.setCedula(Integer.parseInt(rs.getString("Cedula_Usu")));
				persona.setNombre(rs.getString("Nombre_Usu"));
				persona.setCorreo(rs.getString("Correo_Usu"));
				persona.setUsuario(rs.getString("Usuario"));
				persona.setClave(rs.getString("Clave_Usu"));
				
				miLista.add(persona);
			}
			rs.close();
			consulta.close();
			con.desconectar();
		}
		catch(Exception e)
		{
			System.out.println("Error No se pudo Conectar: "+ e);
		}
		
		return miLista;
	}
	
	// Para Registrar un Usuario
	
	public void registraUsuario(UsuarioVO persona)
	{
		Conexion con = new Conexion();
		
		try
		{
			Statement stmt = con.getCon().createStatement();
			stmt.executeUpdate("INSERT INTO T_Usuarios VALUES('"+ persona.getCedula()+ "','"+ 
								persona.getNombre()+ "','"+ persona.getCorreo()+ "','"+ 
								persona.getUsuario()+ "','"+ persona.getClave()+ "')");
			System.out.println("El Usuario ha sido adicionado");
			con.desconectar();
		}
		catch(Exception e)
		{
			System.out.println("Error No se pudo Conectar: "+ e);
		}
	}
	
	// Para Eliminar un Usuario por Número de Documento
	
	public void eliminaUsuario(int documento)
	{
		Conexion con = new Conexion();
		
		try
		{
			PreparedStatement consulta = con.getCon().prepareStatement("DELETE FROM T_Usuarios WHERE Cedula_Usu = ?");
			consulta.setInt(1, documento);
			consulta.executeUpdate();
			System.out.println("El Usuario ha sido eliminado");
			
			consulta.close();
			con.desconectar();
		}
		catch(Exception e)
		{
			System.out.println("Error No se pudo Conectar: "+ e);
		}
	}
	
	// Para Actualizar un Usuario por Número de Documento
	
		public void actualizaUsuario(int documento, String nombre, String correo)
		{
			Conexion con = new Conexion();
			
			try
			{
				PreparedStatement consulta = con.getCon().prepareStatement("UPDATE T_Usuarios SET Nombre_Usu = ?, Correo_Usu = ? WHERE Cedula_Usu = ?");
				consulta.setString(1, nombre);
				consulta.setString(2, correo);
				consulta.setInt(3, documento);
				consulta.executeUpdate();
				System.out.println("El Usuario ha sido actualizado");
				
				consulta.close();
				con.desconectar();
			}
			catch(Exception e)
			{
				System.out.println("Error No se pudo Conectar: "+ e);
			}
		}
}
