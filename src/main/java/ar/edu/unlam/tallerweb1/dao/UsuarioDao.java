package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

// Interface que define los metodos del DAO de Usuarios.
public interface UsuarioDao {
	
	public void crearUsuario(Usuario usuario);
	public Usuario consultarUsuario (Usuario usuario);
	public Usuario buscarUsuarioXId(Long id);
	public Usuario existeUsuarioEnBD(Usuario usuario);
}
