package com.Controlador.Tienda_Panaderia;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.Tienda_Panaderia.UsuarioDAO;
import com.DTO.Tienda_Panaderia.UsuarioVO;

@RestController
public class UsuarioController {

	@RequestMapping("/listarUsuarios")
	public ArrayList<UsuarioVO> listarUsuarios()
	{
		UsuarioDAO Dao = new UsuarioDAO();		
		return Dao.listaUsuarios();
	}
	
	@RequestMapping("/consultarUsuario")
	public ArrayList<UsuarioVO> consultarUsuario(int documento)
	{
		UsuarioDAO Dao = new UsuarioDAO();		
		return Dao.consultaUsuario(documento);
	}
	
	@RequestMapping("/registrarUsuario")
	public void registrarUsuario(UsuarioVO persona)
	{
		UsuarioDAO Dao = new UsuarioDAO();		
		Dao.registraUsuario(persona);
	}
	
	@RequestMapping("/eliminarUsuario")
	public void eliminarUsuario(int documento)
	{
		UsuarioDAO Dao = new UsuarioDAO();		
		Dao.eliminaUsuario(documento);
	}
	
	@RequestMapping("/actualizarUsuario")
	public void actualizarUsuario(int documento, String nombre, String correo)
	{
		UsuarioDAO Dao = new UsuarioDAO();		
		Dao.actualizaUsuario(documento, nombre, correo);
	}	
}
