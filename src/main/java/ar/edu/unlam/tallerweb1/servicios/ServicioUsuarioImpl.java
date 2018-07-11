package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.dao.UsuarioDao;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Service
public class ServicioUsuarioImpl implements ServicioUsuario {
	 
	@Inject
	private UsuarioDao usuarioDao;
	
	@Override
	public Usuario buscarUsuarioPorIdService(Long id) {
		return usuarioDao.buscarUsuarioPorId(id);
	}
	
	@Override
	public void actualizarUsuarioService(Usuario usuario) {
		 usuarioDao.actualizarUsuario(usuario);
	}

}
