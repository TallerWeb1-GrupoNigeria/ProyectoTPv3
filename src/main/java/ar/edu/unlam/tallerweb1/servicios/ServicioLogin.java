package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

// Interface que define los metodos del Servicio de Usuarios.
public interface ServicioLogin {

	public void crearUsuarioSERVICE(Usuario usuario);
	Usuario consultarUsuario(Usuario usuario);
	public Usuario buscarUsuarioXIdSERVICE(Long id);
	public Usuario existeUsuarioEnBDSERVICE(Usuario usuario);
	public Usuario validarUsuario (String email);
	public void registrarUsuario (Usuario usuario);
}
