package ar.edu.unlam.tallerweb1.servicios;
//import java.util.List;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
public interface ServicioUsuario {

		public Usuario buscarUsuarioPorIdService(Long id);	
		public void actualizarUsuarioService(Usuario usuario);

}
